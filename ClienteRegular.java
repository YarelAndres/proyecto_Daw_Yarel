

import java.time.LocalDate;

public class ClienteRegular extends Cliente{
    public ClienteRegular(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void aplicarBonificacion() {

    }
}
