package electronica_main.electronica.articulos.marcas;

public class Marca {
    private String nombre;
    private String pais;
    private float facturacion;

    public Marca(String nombre, String pais, float facturacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.facturacion = facturacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(float facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", facturacion=" + facturacion +
                '}';
    }
}
