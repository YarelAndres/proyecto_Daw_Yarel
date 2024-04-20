import java.time.LocalDate;
import java.util.Objects;

public class ClienteMayorista extends Cliente{
    public ClienteMayorista(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }


    public static int VerificarBonificacion(Venta venta){
        int precioVenta= venta.getPrecio();
        if((precioVenta<300)&&(precioVenta>=200)){
            precioVenta= (int) (precioVenta*0.9);//10% de descuento si su compra esta entre 200 y 300
        } else if((precioVenta>=300)&(precioVenta<500)){
            precioVenta= (int) (precioVenta*0.85);//15% de descuento si su compra esta entre 300 y 500
        }else if ((precioVenta>=500)&(precioVenta<800)){
            precioVenta= (int) (precioVenta*0.80);//20% de descuento si su compra esta entre 500 y 800
        }
        return precioVenta;
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
    public static int gestionarPedido(Cliente cliente){
        int envio;
        if(cliente.getDireccion().equals("Madrid")){
            envio=3;
        }
        else if(Objects.equals(cliente.getDireccion(), "España")){
            envio=5;
        }
        else {
            envio=7;
        }
        return envio;
    }
}
