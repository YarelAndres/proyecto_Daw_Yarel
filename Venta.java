public class Venta {

    int precio;
    int idVenta;

    public Venta() {}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getIdVenta() {return idVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    @Override
    public String toString() {
        return "Venta{" +
                "precio=" + precio +
                ", idVenta=" + idVenta +
                '}';
    }
}
