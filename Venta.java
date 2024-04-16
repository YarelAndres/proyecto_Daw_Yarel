import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Venta {

    int precio,idVenta,precioEnvio;
    String estadoVenta;
    public Venta(int idVenta, int precio, int precioEnvio, String[] estadoVenta) {
        this.idVenta = idVenta;
        this.precio = precio;
        this.precioEnvio = precioEnvio;
        this.estadoVenta = Arrays.toString(estadoVenta);
    }
    public Venta() {}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getIdVenta() {return idVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    final ArrayList<Venta> listaventas = new ArrayList<>();
    static final HashMap<Integer,Venta> mapaVentas=new HashMap<>();

    @Override
    public String toString() {
        return "Venta{" +
                "precio=" + precio +
                ", idVenta=" + idVenta +
                '}';
    }
}
