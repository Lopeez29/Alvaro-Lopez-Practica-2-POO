package electronica_main.electronica.articulos;
import electronica_main.electronica.articulos.marcas.Marca;
import electronica_main.util.SistemaOperativo;

public class Movil extends Articulo{
    private int ramGB;
    private SistemaOperativo sistemaOperativo;

    public Movil(String nombre, float precio, Marca marca, int ramGB, SistemaOperativo sistemaOperativo) {
        super(nombre, precio, marca);
        this.ramGB = ramGB;
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public SistemaOperativo getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return "Movil{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca=" + marca.getNombre() +
                ", ramGB=" + ramGB +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}
