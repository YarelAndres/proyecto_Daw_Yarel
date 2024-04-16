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

    final ArrayList<Venta> listaventas = new ArrayList<>();
    static final HashMap<Integer,Venta> mapaVentas=new HashMap<>();

//    public static void BuscarVentas(Scanner sc, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
//        System.out.println("Ingrese el ID del cliente a buscar: ");
//        int idCliente = sc.nextInt();
//        Venta venta = new Venta();
//        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
//        Cliente cliente = mapaClientes.get(idCliente);
//        if (cliente != null) {
//            for (Venta venta : venta.listaventas) {
//                if(venta.mapaVentas.get(idCliente)!=null) {
//                    System.out.println(venta);
//                }
//            }
//        }
//        else {
//            System.out.println("El cliente no tiene ventas registradas.");
//        }
//    }
}
