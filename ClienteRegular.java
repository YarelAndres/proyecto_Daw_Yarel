public class ClienteRegular extends Cliente {
    public ClienteRegular(String nombre, String direccion, String email, int numTelefono) {
        super(nombre, direccion, email, numTelefono);
    }
    public static int VerificarBonificacionRegular(Venta venta) {
        int DescuentoRegular =(int) (venta.getPrecio()*0.9);
        venta.setPrecio(venta.getPrecio()-DescuentoRegular);
        System.out.println("Descuentro de cliente regular aplicado exitosamente.");
        return venta.getPrecio();
    }
}
