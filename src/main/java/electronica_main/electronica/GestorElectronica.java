package electronica_main.electronica;

import electronica_main.database.DatabaseLocal;
import electronica_main.electronica.articulos.Articulo;
import electronica_main.electronica.articulos.Movil;
import electronica_main.electronica.articulos.Television;
import electronica_main.electronica.articulos.marcas.Marca;
import electronica_main.util.SistemaOperativo;
import electronica_main.util.TipoPantalla;

import java.util.*;
import java.util.stream.Collectors;

public class GestorElectronica {
    private final DatabaseLocal baseDatos = DatabaseLocal.getInstancia();

    // Añadir marca
    public boolean anadirMarca(Marca marca) {
        return baseDatos.guardarMarca(marca.getNombre(), marca);
    }

    // Añadir artículo (móvil o televisor)
    public boolean anadirArticulo(Articulo articulo) {
        if (baseDatos.obtenerMarca(articulo.getMarca().getNombre()) != null) {
            // Verificar si el artículo es un Móvil o un Televisor
            if (articulo instanceof Movil) {
                System.out.println("Añadiendo un móvil: " + articulo.getNombre());
            } else if (articulo instanceof Television) {
                System.out.println("Añadiendo un televisor: " + articulo.getNombre());
            } else {
                System.out.println("Añadiendo un artículo desconocido: " + articulo.getNombre());
            }

            // Guardar el artículo en la base de datos
            baseDatos.guardarArticulo(articulo.getNombre(), articulo);
            return true;
        }

        // Si la marca no existe
        System.out.println("Error: La marca " + articulo.getMarca().getNombre() + " no existe.");
        return false;
    }

    // Buscar marca
    public Marca buscarMarca(String nombre) {
        return baseDatos.obtenerMarca(nombre);
    }

    // Buscar Televisor por tipo de pantalla
    public List<Television> buscarTelevisores(TipoPantalla tipoPantalla) {
        return baseDatos.obtenerArticulos().values().stream()
                .filter(a -> a instanceof Television)
                .map(a -> (Television) a)
                .filter(t -> t.getTipoPantalla() == tipoPantalla)
                .collect(Collectors.toList());
    }

    // Buscar Movil por sistema operativo
    public List<Movil> buscarMoviles(SistemaOperativo sistemaOperativo) {
        return baseDatos.obtenerArticulos().values().stream()
                .filter(a -> a instanceof Movil)
                .map(a -> (Movil) a)
                .filter(m -> m.getSistemaOperativo() == sistemaOperativo)
                .collect(Collectors.toList());
    }

    // Listar Marcas ordenadas por facturación
    public List<Marca> listarMarcas() {
        return baseDatos.obtenerMarcas().stream() // Ya es una lista
                .sorted(Comparator.comparing(Marca::getFacturacion).reversed()) // Orden descendente
                .collect(Collectors.toList());
    }

    // Listar Artículos ordenados por marca, precio y nombre
    public List<Articulo> listarArticulos() {
        List<Articulo> articulos = new ArrayList<>(baseDatos.obtenerArticulos().values());
        Collections.sort(articulos); // Orden por marca, precio, nombre (definido en Articulo)
        return articulos;
    }
}
