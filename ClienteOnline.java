import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteOnline extends Cliente {

    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }


    // Método utilizado para realizar el seguimiento de un envío

    public static void seguimientoEnvio(Scanner sc, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        System.out.println("Ingrese el ID de la venta a buscar: ");
        int idVenta = sc.nextInt();
        sc.nextLine();

        // Buscamos la venta en el mapa de ventas
        Venta ventaEncontrada = null;
        for (Map.Entry<Venta, Integer> entry : mapaVentas.entrySet()) {
            if  (entry.getKey().getIdVenta() == idVenta) {
                ventaEncontrada = entry.getKey();
                break;
            }
        }

        if (ventaEncontrada != null) {
            System.out.println("La venta no es null");
            System.out.println(ventaEncontrada);
        } else {  // Si la venta no se encuentra, se muestra un mensaje indicándolo
            System.out.println("Venta no encontrada.");
        }
    }


    private String obtenerEstadoEnvio() {
        //Creamos un array de String con los posibles estados del envio.
        String[] estados = {"En tránsito", "En almacén local", "Entregado", "Retenido en aduanas"};
        //Utilizando Math.random() generamos un numero aleatorio para obtener el estado del envio del producto.
        //Guardamos el estado del envio en la variable entera estado.
        int estado = (int) (Math.random() * estados.length);
        return estados[estado];
    }


    public void gestionarDevolucion() {
        //Interacción con el cliente para identificar el artículo a devolver.
        System.out.println("Por favor, proporcione el número de seguimiento del artículo a devolver:");

        Scanner sc = new Scanner(System.in);
        String n_seguimiento = sc.nextLine();

        //Interacción con el cliente para confirmar la devolución.
        System.out.println("¿Está seguro de que desea devolver el artículo con número de seguimiento " +
                n_seguimiento + "? (S/N)");
        String r_cliente = sc.nextLine();

        if (r_cliente.equalsIgnoreCase("S")) {
            // Se procesa la devolución del artículo.
            System.out.println("La devolución del artículo con número de seguimiento " + n_seguimiento +
                    " ha sido procesada exitosamente.");
        } else {
            System.out.println("La devolución ha sido cancelada.");
        }
    }
}



