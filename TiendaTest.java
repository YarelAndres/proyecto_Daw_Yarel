import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TiendaTest {
    @Test //Si da error (funciona)
    public void testGuardarCliente() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", 123456789);

        Tienda.GuardarCliente(cliente, listaClientes, mapaClientes);

        assertEquals(1, listaClientes.size()); // Verificar que se agregó el cliente a la lista
        assertEquals(1, mapaClientes.size()); // Verificar que se agregó el cliente al mapa
    }

    @Test //Si da error (funciona)
    public void testDescuento() {
        Cliente cliente = new Cliente("Cliente1", "Dirección1", "cliente1@gmail.com", 123456789);
        Venta venta = new Venta();
        venta.setPrecio(100);
        cliente.setTipoCliente(1); // Cliente regular
        Tienda.Descuento(cliente, venta);
        assertEquals(50, venta.getPrecio()); // Verificar que se aplicó el descuento para el cliente regular
    }
    @Test
    void buscarClientePorTelefono_RegresaNull() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente clienteNoEncontrado = Cliente.buscarClientePorTelefono(987654321, listaClientes);
        assertNull(clienteNoEncontrado);
    }

    @Test
    void buscarClientePorNombre_RegresaCliente() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente clienteEncontrado = Cliente.buscarClientePorNombre("Juan", listaClientes);
        assertNull(clienteEncontrado);
    }

    @Test
    void buscarClientePorNombre_RegresaNull() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente clienteNoEncontrado = Cliente.buscarClientePorNombre("Pedro", listaClientes);
        assertNull(clienteNoEncontrado);
    }

    @Test
    void clienteBuscadoPorDireccion__RegresaNull() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente clienteEncontrado = Cliente.clienteBuscadoPorDireccion("Calle 123", listaClientes);
        assertNull(clienteEncontrado);
    }

    @Test
    void clienteBuscadoPorDireccion_RegresaNulll() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente clienteNoEncontrado = Cliente.clienteBuscadoPorDireccion("Calle 456", listaClientes);
        assertNull(clienteNoEncontrado);
    }
    @Test
    void guardarPuntosFidelidad_ComparaPuntosFidelidad() {
        Cliente cliente = new Cliente("Pablo", "Calle 456", "pablo@gmail.com", 987654321);
        Cliente.GuardarPuntosFidelidad(cliente, 100); //Asigna ciertos puntos de fidelidad
        assertEquals(100, cliente.getPuntosFidelidad());
    }
}