import java.time.LocalDate;
import java.util.Scanner;

public class ClienteOnline extends Cliente {

    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void seguimientoEnvio() {
        //Consultamos el estado del envio con el metodo obtenerEstadoEnvio() creado debajo, y lo guardamos en la
        //variable estadoEnvio.
        String estadoEnvio = obtenerEstadoEnvio();

        //Imprimimos el estado del envio.
        System.out.println("Estado del envío: " + estadoEnvio);
    }

    private String obtenerEstadoEnvio() {
        //Creamos un array de String con los posibles estados del envio.
        String[] estados = {"En tránsito", "En almacén local", "Entregado", "Retenido en aduanas"};
        //Utilizando Math.random() generamos un numero aleatorio para obtener el estado del envio del producto.
        //Guardamos el estado del envio en la variable entera estado.
        int estado = (int) (Math.random() * estados.length);
        return estados[estado];
    }



    public void gestionarDevolucion(){
        // Supongamos que aquí hay una interacción con el cliente para identificar el artículo a devolver.
        System.out.println("Por favor, proporcione el número de seguimiento del artículo a devolver:");

        Scanner sc = new Scanner(System.in);
        String n_seguimiento = sc.nextLine();

        // Supongamos que aquí hay una interacción con el cliente para confirmar la devolución.
        System.out.println("¿Está seguro de que desea devolver el artículo con número de seguimiento " + n_seguimiento + "? (S/N)");


        String r_cliente = sc.nextLine();

        if (r_cliente.equalsIgnoreCase("S")) {
            // Supongamos que aquí se procesa la devolución del artículo.
            procesarDevolucion(numeroSeguimiento);
            System.out.println("La devolución del artículo con número de seguimiento " + numeroSeguimiento + " ha sido procesada exitosamente.");
        } else {
            System.out.println("La devolución ha sido cancelada.");
        }
    }

    private String obtenerNumeroSeguimiento() {
        // Supongamos que aquí se implementa la lógica para obtener el número de seguimiento del cliente.
        // Esto podría ser a través de una entrada de usuario o una consulta a una base de datos.
        // Por simplicidad, aquí devolvemos un número de seguimiento simulado.
        return "123456789";
    }

    private String obtenerRespuestaCliente() {
        // Supongamos que aquí se implementa la lógica para obtener la respuesta del cliente.
        // Esto podría ser a través de una entrada de usuario.
        // Por simplicidad, aquí devolvemos una respuesta simulada.
        return "S";
    }

    private void procesarDevolucion(String numeroSeguimiento) {
        // Supongamos que aquí se implementa la lógica para procesar la devolución del artículo.
        // Esto podría incluir la actualización del estado del artículo en el sistema.
        // Por simplicidad, aquí no se realiza ninguna operación específica.
    }
}


