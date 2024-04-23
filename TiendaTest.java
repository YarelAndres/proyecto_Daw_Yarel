import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TiendaTest {

    @Test
    public void testCrearCliente() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        Tienda.CrearCliente(listaClientes, mapaClientes, sc);

        assertEquals(1, listaClientes.size()); // Verificar que se agregó un cliente a la lista
        assertEquals(1, mapaClientes.size()); // Verificar que se agregó un cliente al mapa
    }

    @Test
    public void testGuardarCliente() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", LocalDate.now(), 123456789);

        Tienda.GuardarCliente(cliente, listaClientes, mapaClientes);

        assertEquals(1, listaClientes.size()); // Verificar que se agregó el cliente a la lista
        assertEquals(1, mapaClientes.size()); // Verificar que se agregó el cliente al mapa
    }


    @Test
    public void testActualizarCliente() {
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", LocalDate.now(), 123456789);
        mapaClientes.put(1, cliente);

        Scanner sc = new Scanner(System.in);
        Tienda.ActualizarCliente(sc, mapaClientes);

        assertEquals("Nueva Dirección", cliente.getDireccion()); // Verificar que se actualizó la dirección del cliente
    }


    @Test
    public void testEliminarCliente() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", LocalDate.now(), 123456789);
        listaClientes.add(cliente);
        mapaClientes.put(1, cliente);

        Scanner sc = new Scanner(System.in);
        Tienda.EliminarCliente(sc, listaClientes, mapaClientes);

        assertEquals(0, listaClientes.size()); // Verificar que se eliminó el cliente de la lista
        assertEquals(0, mapaClientes.size()); // Verificar que se eliminó el cliente del mapa
    }


    @Test
    public void testDescuento() {
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", LocalDate.now(), 123456789);
        Venta venta = new Venta();
        venta.setPrecio(100);
        cliente.setTipoCliente(1); // Cliente regular

        Tienda.Descuento(cliente, venta);

        assertEquals(50, venta.getPrecio()); // Verificar que se aplicó el descuento para el cliente regular
    }

}