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
        double descuento = (porcentajeDescuento / 100.0) * precio;
        double montoConDescuento = precio - descuento;

        // Imprimimos un mensaje indicando el descuento aplicado.
        System.out.println("Descuento VIP del " + porcentajeDescuento + "%");
        System.out.println("Precio total antes del descuento: " + precio + "€");
        System.out.println("Precio con descuento aplicado: " + montoConDescuento + "€");
    }


    public static void accesoServicioPersonalizado() {
        // Asesoramiento personalizado
        System.out.println("Proporcionando acceso a asesoramiento personalizado para el cliente VIP.");

        // Envío prioritario
        System.out.println("Proporcionando acceso a envío prioritario para el cliente VIP.");

        // Ofertas exclusivas
        System.out.println("Proporcionando acceso a ofertas exclusivas para el cliente VIP.");

        // Servicio de atención al cliente preferencial
        System.out.println("Proporcionando acceso a servicio de atención al cliente preferencial para el cliente VIP.");

        // Invitaciones a eventos exclusivos
        System.out.println("Proporcionando acceso a eventos exclusivos para el cliente VIP.");
    }
}