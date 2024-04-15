

import java.time.LocalDate;

public class ClienteOnline extends Cliente {
    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void seguimientoEnvio(){
        System.out.println("Realizando seguimiento de envío para el cliente: " + this.getNombre());

    }
    public void gestionarDevolucion(){
        System.out.println("Gestionando devolución para el cliente: " + this.getNombre());


    }
}
