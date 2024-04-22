import java.time.LocalDate;
import java.util.*;

public class Tienda {
    public static void CrearCliente(ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes, Scanner sc) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el número de teléfono del cliente:");
        int numTelefono = sc.nextInt();
        System.out.println("Ingrese el email del cliente:");
        sc.nextLine();
        String email = sc.nextLine();

        LocalDate fechaRegistro = LocalDate.now();
        Cliente nuevoCliente = new Cliente(nombre, direccion, email, fechaRegistro, numTelefono);
        GuardarCliente(nuevoCliente, listaClientes, mapaClientes);
        System.out.println("Cliente agregado exitosamente.\n" + "Con el ID: " + nuevoCliente.getIdCliente());
    }

    public static void GuardarCliente(Cliente cliente, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        listaClientes.add(cliente);
        int id;
        Random random = new Random();
        do {
            id = random.nextInt(10000);
        } while (mapaClientes.containsKey(id));
        cliente.setIdCliente(id);
        mapaClientes.put(id, cliente);
    }

    public static void BuscarCliente(Scanner sc, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("""
                Seleccione el tipo de busqueda:\s
                 1. Buscar por nombre
                 2. Buscar por telefono
                 3. Buscar por direccion
                 4. Buscar por ID""");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1 -> {
                System.out.println("Ingresa el nombre del cliente que quieres buscar");
                Cliente clienteBuscadoPorNombre = Cliente.buscarClientePorNombre(sc.nextLine(), listaClientes);
                imprimirDetallesCliente(clienteBuscadoPorNombre);
            }
            case 2 -> {
                System.out.println("Ingresa el número de teléfono del cliente que quieres buscar");
                Cliente clienteBuscadoPorTelefono = Cliente.buscarClientePorTelefono(sc.nextInt(), listaClientes);
                imprimirDetallesCliente(clienteBuscadoPorTelefono);
                sc.nextLine();
            }
            case 3 -> {
                System.out.println("Ingresa la dirección del cliente que quieres buscar");
                Cliente clienteBuscadoPorDireccion = Cliente.clienteBuscadoPorDireccion(sc.nextLine(), listaClientes);
                imprimirDetallesCliente(clienteBuscadoPorDireccion);
                sc.nextLine();
            }
            case 4 -> Cliente.buscarClientePorID(sc, mapaClientes);
            default -> System.out.println("Opcion no valida");
        }
    }

    public static void imprimirDetallesCliente(Cliente cliente) {
        if (cliente != null) {
            System.out.println("¡Cliente encontrado!");
            System.out.println("Nombre: " + cliente.getNombre()
                    + " con el ID: " + cliente.getIdCliente());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("Telefono: " + cliente.getNumTelefono());
            System.out.println("Correo elecrónico: " + cliente.getEmail());
            System.out.println("Fecha de registro: " + cliente.getFechaRegistro());
            System.out.println("Puntos de fidelidad: " + cliente.getPuntosFidelidad());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void ActualizarCliente(Scanner sc, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Cliente clienteactualizado = mapaClientes.get(id);
        if (clienteactualizado != null) {
            System.out.println("¿Qué dato quieres modificar?");
            System.out.println("1. Dirección");
            System.out.println("2. Email");
            System.out.println("3. Nombre");
            System.out.println("4. Teléfono");
            System.out.println("5. Salir");

            boolean salir = false;
            while (!salir) {
                int opcionModificar = sc.nextInt();
                sc.nextLine();
                switch (opcionModificar) {
                    case 1 -> {
                        System.out.println("Ingresa la nueva dirección");
                        String nuevaDireccion = sc.nextLine();
                        clienteactualizado.setDireccion(nuevaDireccion);
                        System.out.println("Dirección actualizada exitosamente");
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Ingresa el nuevo email");
                        String nuevoEmail = sc.nextLine();
                        clienteactualizado.setEmail(nuevoEmail);
                        System.out.println("Email actualizado exitosamente");
                        salir = true;
                    }
                    case 3 -> {
                        System.out.println("Ingresa el nuevo nombre");
                        String nuevoNombre = sc.nextLine();
                        clienteactualizado.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado exitosamente");
                        salir = true;
                    }
                    case 4 -> {
                        System.out.println("Ingresa el nuevo teléfono");
                        int nuevoTelefono = sc.nextInt();
                        sc.nextLine();
                        clienteactualizado.setNumTelefono(nuevoTelefono);
                        System.out.println("Teléfono actualizado exitosamente");
                        salir = true;
                    }
                    case 5 -> {
                        System.out.println("Saliendo del sistema...");
                        salir = true;
                    }
                    default -> System.out.println("Opción no válida, por favor seleccione una opción válida.");
                }
            }
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void EliminarCliente(Scanner sc, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a eliminar: ");
        int id = sc.nextInt();
        Cliente clientedelete = mapaClientes.get(id);

        if (clientedelete != null) {
            listaClientes.remove(clientedelete);
            mapaClientes.remove(id);
            System.out.println("Cliente eliminado exitosamente.\n");
        } else {
            System.out.println("Cliente no encontrado.\n");
        }
    }

    public static void GuardarVenta(Scanner sc, ArrayList<Venta> listaVentas, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        Venta venta = new Venta();
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        Cliente cliente = mapaClientes.get(idCliente);
        if (cliente != null) {
            int idVenta;
            Random random = new Random();
            do {
                idVenta = random.nextInt(10000);
            } while (mapaVentas.containsValue(idVenta));
            venta.setIdVenta(idVenta);
            mapaVentas.put(venta, idCliente);

            System.out.println("Venta guardada con idCliente de: " + cliente.getIdCliente() +
                    "\nIdVenta de: " + venta.getIdVenta());

            System.out.println("Ingrese el precio de la venta : ");
            int precioVenta = sc.nextInt();
            sc.nextLine();
            venta.setPrecio(precioVenta);
            listaVentas.add(venta);
            LocalDate fechaRegistro = LocalDate.now();
            venta.setFechaRegistro(fechaRegistro);
            System.out.println("Indique el tipo de Cliente: " +
                    "\n1)Regular" +
                    "\n2)Mayorista" +
                    "\n3)Online" +
                    "\n4)Internacional" +
                    "\n5)VIP");
            cliente.setTipoCliente(sc.nextInt());
            Cliente.GuardarPuntosFidelidad(cliente,precioVenta);//Guarda puntos en funcion del precio total de la venta sin descuento
            Descuento(cliente,venta);
            System.out.println("El precio de la compra despues de descuentos pasa de "+precioVenta+" a "+venta.getPrecio());

            System.out.println("¿Desea utilizar sus punto de Fidelidad?" +
                    "\n1)SI" +
                    "\n2)NO");
            switch (sc.nextInt()){
                case 1:
                    Cliente.CanjearPuntosFidelidad(cliente,venta);
                    System.out.println("El nuevo precio de la venta es: "+venta.getPrecio());
                    break;
                default:System.out.println("Punto de fidelidad no canjeados");
            }
            Seguimiento(cliente,venta);

            CalcularEnvio(sc,venta,cliente);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void BuscarVentas(Scanner sc, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        Cliente cliente = mapaClientes.get(idCliente);

        if (cliente != null) {
            boolean ventasEncontradas = false;
            for (Map.Entry<Venta, Integer> entry : mapaVentas.entrySet()) {
                if (entry.getValue() == idCliente) {
                    System.out.println(entry.getKey());
                    ventasEncontradas = true;
                }
            }
            if (!ventasEncontradas) {
                System.out.println("El cliente no tiene ventas registradas.");
            }
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    public static void Descuento(Cliente cliente,Venta venta) {
        switch (cliente.getTipoCliente()){
            case 1 ->{
                ClienteRegular.VerificarBonificacionRegular(venta);
            }
            case 2 ->{
                ClienteMayorista.VerificarBonificacionMayorista(venta);
            }
            case 3 ->{
                //lo que sea
            }
            case 4 ->{}
            case 5 ->{
                ClienteVIP.VerificarBonificacionVIP(venta);
            }
        }
    }
    public static void CalcularEnvio(Scanner sc,Venta venta,Cliente cliente){
        System.out.println("Indique la region del envio:"+
                "1)Africa"+
                "2)America" +
                "3)España" +
                "4)Europa" +
                "5)Oceania" +
                "6)Asia");
        switch (sc.nextInt()){
            case 1 ->{
                venta.setPrecio(venta.getPrecio()+5);
                cliente.setTipoCliente(4);
            }
            case 2 ->{
                venta.setPrecio(venta.getPrecio()+4);
                cliente.setTipoCliente(4);
            }
            case 3 ->{
                venta.setPrecio(venta.getPrecio());
            }
            case 4 ->{
                venta.setPrecio(venta.getPrecio()+2);
                cliente.setTipoCliente(4);
            }
            case 5 ->{
                venta.setPrecio(venta.getPrecio()+10);
                cliente.setTipoCliente(4);
            }
            case 6 ->{
                cliente.setTipoCliente(4);
                venta.setPrecio(venta.getPrecio()+6);
            }
        }
    }
    public static void Seguimiento(Cliente cliente,Venta venta){
        if(cliente.getTipoCliente()==4){
            ClienteOnline.seguimientoEnvio(venta);
        }
    }
}

//Método CrearCliente: Este método permite al usuario ingresar los datos de un nuevo cliente, como nombre, dirección, número de teléfono y correo electrónico. Luego crea una instancia de la clase Cliente con estos datos y la agrega tanto a la lista de clientes como al mapa de clientes, asignándole un ID único en el proceso.
//Método GuardarCliente: Este método recibe un cliente como argumento y lo agrega tanto a la lista de clientes como al mapa de clientes. Además, asigna un ID único al cliente antes de agregarlo al mapa.
//Método BuscarCliente: Este método permite al usuario buscar un cliente por diferentes criterios, como nombre, teléfono, dirección o ID. Dependiendo de la opción elegida por el usuario, se realiza la búsqueda y se muestran los detalles del cliente encontrado utilizando el método imprimirDetallesCliente.
//Método imprimirDetallesCliente: Este método recibe un objeto Cliente como argumento y muestra sus detalles, como nombre, dirección, teléfono, correo electrónico, fecha de registro y puntos de fidelidad.
//Método ActualizarCliente: Este método permite al usuario actualizar los datos de un cliente existente, como dirección, correo electrónico, nombre o número de teléfono. Se solicita al usuario que elija qué dato desea modificar y se realiza la actualización correspondiente en el cliente.
//Método EliminarCliente: Este método permite al usuario eliminar un cliente existente proporcionando su ID. Se elimina el cliente tanto de la lista de clientes como del mapa de clientes.
//Método GuardarVenta: Este método permite al usuario registrar una nueva venta asociada a un cliente existente. Se solicita al usuario que ingrese el ID del cliente y el precio de la venta. Luego se crea una instancia de la clase Venta, se asigna un ID único y se guarda en la lista de ventas. Además, se actualiza el tipo de cliente (regular o mayorista) y se aplican bonificaciones y descuentos según corresponda.
//Método BuscarVentas: Este método permite al usuario buscar todas las ventas asociadas a un cliente específico. Se solicita al usuario que ingrese el ID del cliente y se muestran todas las ventas correspondientes a ese cliente.
//Métodos asignarPuntosFidelidad y canjearPuntosFidelidad: Estos métodos se encargan de asignar y canjear puntos de fidelidad a un cliente, respectivamente. Se calcula el número de puntos a asignar o canjear según el precio de la venta y se actualizan los puntos de fidelidad del cliente en consecuencia. Además, se aplican descuentos en función de los puntos canjeados.