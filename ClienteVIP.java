import java.time.LocalDate;

public class ClienteVIP extends Cliente{
    public ClienteVIP(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }




    public static void aplicarDescuentoVIP( double precio) {

        // Porcentaje de descuento
        double porcentajeDescuento = 15.0;

        // Aquí implementamos la lógica para aplicar el descuento. Por ejemplo, podríamos reducir el precio de ciertos
        // productos con un porcentaje de descuento. Supongamos que el descuento se aplica al monto total de la compra.
        double precioTotal = precio;
        double descuento = (porcentajeDescuento / 100.0) * precioTotal;
        double montoConDescuento = precioTotal - descuento;

        // Imprimimos un mensaje indicando el descuento aplicado.
        System.out.println("Descuento VIP del " + porcentajeDescuento + "%");
        System.out.println("Precio total antes del descuento: " + precioTotal + "€");
        System.out.println("Precio con descuento aplicado: " + montoConDescuento + "€");
    }


    public static void accesoServicioPersonalizado() {

    }
}