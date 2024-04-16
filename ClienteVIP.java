import java.time.LocalDate;

public class ClienteVIP extends Cliente{
    public ClienteVIP(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void aplicarDescuentoVIP() {
//Cambio MAX
    }
    public void accesoServicioPersonalizado() {

    }
}
