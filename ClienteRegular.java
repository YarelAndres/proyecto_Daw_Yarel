import java.time.LocalDate;

public class ClienteRegular extends Cliente{
    int TipoCliente=1;
    public ClienteRegular(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }

    public static int VerificarBonificacion(Venta venta) {
        int precioVenta= venta.getPrecio();
        precioVenta*=0.95;
        return precioVenta;
    }
}
