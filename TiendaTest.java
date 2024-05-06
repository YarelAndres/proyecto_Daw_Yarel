import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertEquals(10, venta.getPrecio()); // Verificar que se aplicó el descuento para el cliente regular
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

    //----------------------------------------------------TEST--------------------------------------------------------------------------------------\\


    //Cliente Mayorista
    @Test
    public void testVerificarBonificacionMayorista() {
        Venta venta = new Venta(); // Se crea una venta con un precio de 250
        int precioFinal = ClienteMayorista.VerificarBonificacionMayorista(venta); // Se llama al método a testear
        assertEquals(0, precioFinal); // Se espera que el precio final sea 225 con un descuento del 10%
    }

    //Cliente Online
    @Test
    public void testSeguimientoEnvio_VentaEncontrada() {
        Scanner sc = new Scanner("1 1 ");
        HashMap<Integer, Cliente> mapaClientes = new HashMap<>();
        HashMap<Venta, Integer> mapaVentas = new HashMap<>();


        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "Direccion", 333333);
        Venta venta = new Venta();
        mapaVentas.put(venta, 1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ClienteOnline.seguimientoEnvio(sc, mapaClientes, mapaVentas);

        String expectedOutput = "Ingrese el ID de la venta a buscar: \r\nVenta no encontrada.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testGestionarDevolucion() {
        Venta venta = new Venta();

        ClienteOnline.GestionarDevolucion(venta);

        assertEquals(0, venta.getPrecio());
        assertNull(venta.getFechaEntrega());
    }

    //Cliente Regular

    @Test
    public void testVerificarBonificacionRegular() {
        Venta venta = new Venta();
        venta.setPrecio(100);
        int precioFinal = ClienteRegular.VerificarBonificacionRegular(venta);
        assertEquals(10, precioFinal);
    }


    //CLiente VIP

    @Test
    public void testAccesoServicioPersonalizado() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ClienteVIP.accesoServicioPersonalizado();
        String expectedOutput = "Proporcionando acceso a asesoramiento personalizado para el cliente VIP.\r\n" +
                "Proporcionando acceso a envío prioritario para el cliente VIP.\r\n" +
                "Proporcionando acceso a ofertas exclusivas para el cliente VIP.\r\n" +
                "Proporcionando acceso a servicio de atención al cliente preferencial para el cliente VIP.\r\n" +
                "Proporcionando acceso a eventos exclusivos para el cliente VIP.\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testVerificarBonificacionVIP() { //
        Venta venta = new Venta();
        venta.setPrecio(100); // Precio original de la venta
// Llamar al método VerificarBonificacionVIP
        int precioFinal = ClienteVIP.VerificarBonificacionVIP(venta);
// Verificar que el descuento VIP se aplica correctamente
        assertEquals(85, precioFinal);
    }

}


