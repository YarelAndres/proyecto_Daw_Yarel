//package EjerciciosProgramacion.PROYECTOFINAL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

    //Creación de las variables de la clase cliente.
    String nombre, direccion, email;
    LocalDate fechaRegistro;

    int idCliente;
    int numTelefono;
    int puntosFidelidad;

    public int getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        TipoCliente = tipoCliente;
    }

    int TipoCliente;

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    // atributo del grupo libros.
    //Constructor completo de la clase cliente.
    public Cliente(String nombre, String direccion, String email, int numTelefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.numTelefono = numTelefono;
    }


    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    } //Tipo fecha.
    public LocalDate setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    //Metodo para buscar cliente por su número de teléfono. Le pasamos por parametro el numero de teléfono, el
    //ArrayList que contiene los clientes.
    public static Cliente buscarClientePorTelefono(int numTelefono, ArrayList<Cliente> listaClientes) {
        //Recorremos el arreglo de clientes, y si el numero de telefono introducido por parametro es igual al
        //numero de telefono de alguno de los clientes, retornamos la informacion de dicho cliente.
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumTelefono() == numTelefono) {
                return cliente;
            }
        }
        //Si no se encuentra ningun cliente, retornamos null.
        return null;
    }

    public static Cliente buscarClientePorNombre(String nombre, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente clienteBuscadoPorDireccion(String direccion, ArrayList<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDireccion().equals(direccion)) {
                return cliente;
            }
        }
        return null;
    }

    public static void buscarClientePorID(Scanner sc, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
        Cliente cliente = mapaClientes.get(id);
        if (cliente != null) {
            System.out.println("¡Cliente encontrado!");
            System.out.println("Nombre: " + cliente.getNombre() + " con el ID: " + cliente.getIdCliente());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("Telefono: " + cliente.getNumTelefono());
            System.out.println("Fecha de registro: " + cliente.getFechaRegistro());
            System.out.println("Puntos de fidelidad: " + cliente.getPuntosFidelidad());
            sc.nextLine();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    //Métodos asignarPuntosFidelidad y canjearPuntosFidelidad: Estos métodos se encargan de asignar y canjear puntos de fidelidad a un cliente.
    // Se calcula el número de puntos a asignar o canjear según el precio de la venta y se actualizan los puntos de fidelidad del cliente en consecuencia.
    // Además, se aplican descuentos en función de los puntos canjeados.
    public static void GuardarPuntosFidelidad(Cliente cliente,int precioVenta){
        cliente.setPuntosFidelidad((cliente.getPuntosFidelidad() + (precioVenta)));
    }
    public static void CanjearPuntosFidelidad(Cliente cliente,Venta venta){
        int PuntosCanjeables=cliente.getPuntosFidelidad();
        int PuntosNoCanjeados= cliente.getPuntosFidelidad()-PuntosCanjeables;
        cliente.setPuntosFidelidad(PuntosNoCanjeados);
        int Descuento=PuntosCanjeables/20;//Si tengo 200 puntos fidelidad se realiza un descuento de 5% (10 euros)
        venta.setPrecio(venta.getPrecio()-Descuento);
        System.out.println("Cantidad de puntos de fidelidad a canjear :"+PuntosCanjeables+" equivalentes a "+Descuento + " euros");
        System.out.println("¡Puntos de fidelidad canjeados exitosamente!");
    }
}
