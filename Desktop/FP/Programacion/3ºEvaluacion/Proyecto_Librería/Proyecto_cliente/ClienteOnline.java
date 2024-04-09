

import java.time.LocalDate;

public class ClienteOnline extends Cliente {
    public ClienteOnline(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void seguimientoEnvio(){

    }
    public void gestionarDevolucion(){}
}
