import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Venta {

    int precio,idVenta;
    public Venta(int idVenta, int precio) {
        this.idVenta = idVenta;
        this.precio = precio;
    }
    public Venta() {}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getIdVenta() {return idVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    @Override
    public String toString() {
        return "Venta Encontrada{" +
                "precio=" + precio +
                ", idVenta=" + idVenta +
                '}';
    }
}
