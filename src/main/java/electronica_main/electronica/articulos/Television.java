package electronica_main.electronica.articulos;

import electronica_main.util.TipoPantalla;
import electronica_main.electronica.articulos.marcas.Marca;

public class Television extends Articulo{
    private int pulgadas;
    private TipoPantalla tipoPantalla;

    public Television(String nombre, float precio, Marca marca, int pulgadas, TipoPantalla tipoPantalla) {
        super(nombre, precio, marca);
        this.pulgadas = pulgadas;
        this.tipoPantalla = tipoPantalla;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public TipoPantalla getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(TipoPantalla tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public String toString() {
        return "Television{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca=" + marca.getNombre() +
                ", pulgadas=" + pulgadas +
                ", tipoPantalla='" + tipoPantalla + '\'' +
                '}';
    }
}
