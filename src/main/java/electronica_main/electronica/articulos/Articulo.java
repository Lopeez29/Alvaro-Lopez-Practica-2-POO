package electronica_main.electronica.articulos;

import electronica_main.electronica.articulos.marcas.Marca;

public abstract class Articulo implements Comparable<Articulo> {
    protected String nombre;
    protected float precio;
    protected Marca marca;

    public Articulo(String nombre, float precio, Marca marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public int compareTo(Articulo o) {
        int result = this.marca.getNombre().compareTo(o.marca.getNombre());
        if (result != 0) return result;

        result = Float.compare(this.precio, o.getPrecio());
        if (result != 0) return result;

        return this.nombre.compareTo(o.getNombre());
    }

    public abstract String toString();

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
