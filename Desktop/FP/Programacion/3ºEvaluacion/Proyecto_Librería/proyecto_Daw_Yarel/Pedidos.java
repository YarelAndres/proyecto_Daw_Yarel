import java.time.LocalDate;

public class Pedidos {
    private int idPedido;
    private final LocalDate fechaPedido;
    private final String estado;

    // Constructor
    public Pedidos(int idPedido, LocalDate fechaPedido, String estado) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }


    // Métodos de acceso
    public int getIdPedido() {
        return idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    // Método para realizar el seguimiento del pedido
    public void seguimientoPedido() {
        System.out.println("Realizando seguimiento del pedido " + idPedido + ":");
        System.out.println("Fecha de pedido: " + fechaPedido);
        System.out.println("Estado actual: " + estado);
    }

    // Método para gestionar la devolución del pedido
    public void gestionarDevolucion() {
        System.out.println("Gestionando devolución del pedido " + idPedido + ":");
        // Lógica para gestionar la devolución del pedido
    }
}
