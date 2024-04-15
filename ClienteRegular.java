

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteRegular extends Cliente{
    public ClienteRegular(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public void aplicarBonificacion(ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {

        }
    }
}
