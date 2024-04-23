import java.time.LocalDate;
import java.util.Scanner;

public class Venta {

    int precio;
    int idVenta;
    LocalDate FechaRegistro;
    LocalDate FechaEntrega;

    public LocalDate getFechaEntrega() {return FechaEntrega;}

    public void setFechaEntrega(LocalDate fechaEntrega) {FechaEntrega = fechaEntrega;}

    public Venta() {}

    public LocalDate getFechaRegistro() {return FechaRegistro;}

    public void setFechaRegistro(LocalDate fechaRegistro) {FechaRegistro = fechaRegistro;}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getIdVenta() {return idVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    @Override
    public String toString() {
        return "ID de venta: " + idVenta + "\n" + "Precio: " + precio;
    }
    public String ventaEncontrada(Venta venta) {
        return "Venta:" + idVenta+
                "\n"+ "Fecha de registro: " +  FechaRegistro+
                "\nFecha de envio esperada: " +FechaEntrega;
    }
    public String obtenerEstadoEnvio(Venta venta) {
        //Indicamos la fecha de entrega como la fecha de hoy + 7 dias.
        LocalDate fecha_actual = LocalDate.now();
        // Comprobar si la fecha actual es posterior a la fecha de registro
        if (fecha_actual.isBefore(venta.getFechaRegistro())) {
            // Comparar la fecha actual con la fecha de entrega esperada
            if (fecha_actual.isBefore(venta.getFechaEntrega())) {
                return "Pendiente de entrega";
            } else if (fecha_actual.equals(venta.getFechaEntrega())) {
                    return "Entrega esperada hoy";
            } else {
                    return "Entregado";
            }
        } else {
                return "Pendiente de registro";
        }
    }
}

