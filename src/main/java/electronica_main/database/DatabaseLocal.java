package electronica_main.database;

import electronica_main.electronica.articulos.Articulo;
import electronica_main.electronica.articulos.marcas.Marca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseLocal {
    private static DatabaseLocal instancia; // Singleton

    private final HashMap<String, Marca> marcas;
    private final HashMap<String, Articulo> articulos;

    // Constructor privado (Singleton)
    private DatabaseLocal() {
        this.marcas = new HashMap<>();
        this.articulos = new HashMap<>();
    }

    // Aqui accedemos a la única instancia de la base de datos
    public static DatabaseLocal getInstancia() {
        if (instancia == null) {
            synchronized (DatabaseLocal.class) {
                if (instancia == null) {
                    instancia = new DatabaseLocal();
                }
            }
        }
        return instancia;
    }

    // Añadir una marca si no existe
    public boolean guardarMarca(String id, Marca marca) {
        if (!marcas.containsKey(id)) {
            marcas.put(id, marca);
            return true;
        }
        return false; // Marca ya existe
    }

    // Obtener una marca por su ID
    public Marca obtenerMarca(String id) {
        return marcas.get(id);
    }

    // Listar todas las marcas
    public List<Marca> obtenerMarcas() {
        return new ArrayList<>(marcas.values());
    }

    // Guardar un artículo
    public void guardarArticulo(String id, Articulo articulo) {
        if (!articulos.containsKey(id)) {
            articulos.put(id, articulo);
        }
    }

    // Obtener todos los artículos almacenados
    public HashMap<String, Articulo> obtenerArticulos() {
        return articulos;
    }
}
