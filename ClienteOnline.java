import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteOnline extends Cliente {

    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, numTelefono);
    }


    // Método utilizado para realizar el seguimiento de un envío

    public static void seguimientoEnvio(Scanner sc, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        System.out.println("Ingrese el ID de la venta a buscar: ");
        int idVenta = sc.nextInt();
        sc.nextLine();

        // Buscamos la venta en el mapa de ventas
        Venta ventaEncontrada = null;
        for (Map.Entry<Venta, Integer> entry : mapaVentas.entrySet()) {
            if (entry.getKey().getIdVenta() == idVenta) {
                ventaEncontrada = entry.getKey();
                break;
            }
        }

        if (ventaEncontrada != null) {
            System.out.println(ventaEncontrada.ventaEncontrada(ventaEncontrada));
            System.out.println("""
                    ¿Desea consultar el estado del envio o cancelar un envío?\s
                    1. Consultar estado
                    2. Cancelar envío""");
            int x = sc.nextInt();
            if (x == 1) {
                System.out.println(ventaEncontrada.obtenerEstadoEnvio(ventaEncontrada));
            }
            if (x == 2) {
                System.out.println("Cancelando el envío.");
                GestionarDevolucion(ventaEncontrada);
            }
        } else {  // Si la venta no se encuentra, se muestra un mensaje indicándolo
            System.out.println("Venta no encontrada.");
        }
    }

    public static void GestionarDevolucion(Venta ventaEncontrada) {
        ventaEncontrada.setPrecio(0);
        ventaEncontrada.setFechaEntrega(null);
        System.out.println("Se ha devuelto el importe completo de la compra.");
    }
}



