import java.time.LocalDate;
import java.util.Scanner;

public class ClienteOnline extends Cliente {

    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public static void seguimientoEnvio(Venta venta) {
        //Consultamos el estado del envio con el metodo obtenerEstadoEnvio() creado debajo, y lo guardamos en la
        //variable estadoEnvio.
        //String estadoEnvio = obtenerEstadoEnvio();

        //Imprimimos el estado del envio.
        //System.out.println("Estado del envío: " + estadoEnvio);
    }

    private static String obtenerEstadoEnvio(Venta venta, Scanner sc) {
        System.out.println("Ingrese el ID de la venta: ");
        int id_venta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner
        //Indicamos la fecha de entrega como la fecha de hoy + 7 dias.
        LocalDate FechaEntrega= LocalDate.now().plusDays(7);
        // Verificar si el ID de la venta coincide
        if (venta.getIdVenta() == id_venta) {
            LocalDate fecha_actual = LocalDate.now();

            // Comprobar si la fecha actual es posterior a la fecha de registro
            if (fecha_actual.isBefore(venta.getFechaRegistro())) {
                LocalDate fecha_entrega_esperada =FechaEntrega;

                // Comparar la fecha actual con la fecha de entrega esperada
                if (fecha_actual.isBefore(fecha_entrega_esperada)) {
                    return "Pendiente de entrega";
                } else if (fecha_actual.equals(fecha_entrega_esperada)) {
                    return "Entrega esperada hoy";
                } else {
                    return "Entregado";
                }
            } else {
                return "Pendiente de registro";
            }
        } else {
            return "ID de venta no encontrado";
        }
    }




    public void gestionarDevolucion(){
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



