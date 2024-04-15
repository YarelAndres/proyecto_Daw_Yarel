

import java.time.LocalDate;

public class ClienteInternacional extends Cliente {
    public ClienteInternacional(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void calcularCostoEnvioInternac() {

    }

    public void gestionarAduanas() {
        //Prueba grupal PUSH
    }
}
