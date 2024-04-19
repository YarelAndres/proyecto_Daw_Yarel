import java.time.LocalDate;

public class ClienteMayorista extends Cliente{
    public ClienteMayorista(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }


    //Variable ficticia de numero de compras hechas por el mayorista.
    int cant_compra = 17;
    double precio= 50.3;

    public void calcularDescuentoMayorista(int cant_compra, double precio) {
        double descuento = 0.0;

        //Descuento al mayorista, cuanto mayor el numero de productos comprados, mayor el descuento.
        if (cant_compra > 50) {
            descuento = 0.15; // 15% de descuento si la cantidad de compras es mayor que 50
        } else if (cant_compra > 30) {
        descuento = 0.10; // 10% de descuento si la cantidad de compras es mayor que 30
        } else if(cant_compra > 10) {
            descuento = 0.5; // 5% de descuento si la cantidad de compras es mayor que 10
        }else {
            System.out.println("No ha hecho las compras suficientes para considerarse compra mayorista.");
        }

        double precio_total= precio*cant_compra;
        double precio_total_con_descuento= (precio_total*descuento)/100;
        System.out.println("El precio total de su compra es: " + precio_total + "€");
        System.out.println("Su descuento por compra mayorista es: " + descuento + "€");
        System.out.println("El precio total de su compra es: " + precio_total_con_descuento + "€");

    }

    public void gestionarPedidoMayorista() {
        // Simulando algunas operaciones de gestión de pedidos para un cliente mayorista
        System.out.println("Gestionando pedido para cliente mayorista...");
        System.out.println("Verificando inventario...");
        System.out.println("Generando orden de compra en grandes cantidades...");
        System.out.println("Asignando fecha de entrega preferida...");
        System.out.println("Confirmando pedido con el cliente mayorista...");
        System.out.println("Pedido gestionado exitosamente para el cliente mayorista.");
    }
}
