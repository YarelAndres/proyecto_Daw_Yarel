import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final ArrayList<Cliente> listaClientes = new ArrayList<>();
        final HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        final ArrayList<Venta> listaventas = new ArrayList<>();
        final HashMap<Venta,Integer> mapaVentas=new HashMap<>();

        Tienda tienda = new Tienda();

        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    1. Para crear un nuevo cliente
                    2. Para buscar un cliente
                    3. Para actualizar un cliente
                    4. Para eliminar un cliente
                    5. Pedidos
                    6. Para salir.""");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    Tienda.CrearCliente(listaClientes,mapaClientes,sc);
                }
                case 2 -> {
                    Tienda.BuscarCliente(sc,listaClientes,mapaClientes);
                }
                case 3 -> {
                    Tienda.ActualizarCliente(sc,listaClientes,mapaClientes);
                }
                case 4 -> {
                    Tienda.EliminarCliente(sc,listaClientes,mapaClientes);
                }
                case 5 -> {
                    Tienda.GuardarVenta(sc,listaventas,mapaClientes,mapaVentas);
                }
                case 6 -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                case 7 ->{
                    Tienda.BuscarVentas(sc,listaventas,mapaClientes,mapaVentas);
                }
                case 8 ->{
                    //Parametro precio ficticio obtenido del grupo libros.
                    double precio = 50.7;
                    ClienteVIP.aplicarDescuentoVIP(precio);
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
}
