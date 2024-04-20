public class Venta {

    int precio;
    int idVenta;

    public Venta() {}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getIdVenta() {return idVenta;}

    public void setIdVenta(int idVenta) {this.idVenta = idVenta;}

    @Override
    public String toString() {
        return "Venta{" +
                "precio=" + precio +
                ", idVenta=" + idVenta +
                '}';
    }
    public static void GestionarEnvios(Cliente cliente,Venta venta){
        switch(cliente.getTipoCliente()){
            case 1 ->{}
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}
        }
    }
}
