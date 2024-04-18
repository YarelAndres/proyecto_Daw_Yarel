import java.time.LocalDate;
import java.util.*;

public class Tienda {
    public static void CrearCliente(ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes, Scanner sc) {
        System.out.println("Ingrese el nombre del cliente:");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el número de teléfono del cliente:");
        int numTelefono = sc.nextInt();
        System.out.println("Ingrese el email del cliente:");
        sc.nextLine();
        String email = sc.nextLine();

        LocalDate fechaRegistro = LocalDate.now();//Utiliza la fecha actual y la guarda como fecha de registro
        Cliente nuevoCliente = new Cliente(nombre, direccion, email, fechaRegistro, numTelefono);//Guarda parametros introducidos en el constructor de la clase Cliente
        GuardarCliente(nuevoCliente, listaClientes, mapaClientes);
        System.out.println("Cliente agregado exitosamente.\n"+"Con el ID: "+nuevoCliente.getIdCliente());
    }

    public static void GuardarCliente(Cliente cliente, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        listaClientes.add(cliente);//Guardamos el cliente creado previamente en el Arraylist
        int id;
        Random random = new Random();
        do {
            id = random.nextInt(10000); // Número aleatorio entre 0 y 9999
        } while (mapaClientes.containsKey(id)); // Verificar que el identificador generado no esté en uso
        cliente.setIdCliente(id); //Guarda el id creado en el objeto de la clase Cliente
        mapaClientes.put(id, cliente); //Vincula el id creado con el objeto cliente creado previamente
    }

    public static void BuscarCliente(Scanner sc, ArrayList<Cliente> listaClientes, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("""
                Seleccione el tipo de busqueda:\s
                 1. Buscar por nombre
                 2. Buscar por telefono
                 3. Buscar por direccion
                 4. Buscar por ID""");
        int op = sc.nextInt();
        switch (op) {
            case 1 -> {
                System.out.println("Ingresa el nombre del cliente que quieres buscar");
                sc.nextLine();
                Cliente clienteBuscadoPorNombre = Cliente.buscarClientePorNombre(sc.nextLine(), listaClientes);
                if (clienteBuscadoPorNombre != null) {
                    System.out.println("Cliente encontrado!!");
                    System.out.println("Nombre: " + clienteBuscadoPorNombre.getNombre()
                            + " con el ID: " + clienteBuscadoPorNombre.getIdCliente());
                    System.out.println("Direccion: " + clienteBuscadoPorNombre.getDireccion());
                    System.out.println("Telefono: " + clienteBuscadoPorNombre.getNumTelefono());
                } else {
                    System.out.println("Cliente no encontrado ");
                }
            }
            case 2 -> {
                System.out.println("Ingresa el número de teléfono del cliente que quieres buscar");
                Cliente clienteBuscadoPorTelefono = Cliente.buscarClientePorTelefono(sc.nextInt(), listaClientes);
                if (clienteBuscadoPorTelefono != null) {
                    System.out.println("Cliente encontrado!!");
                    System.out.println("Nombre: " + clienteBuscadoPorTelefono.getNombre()
                            + " con el ID: " + clienteBuscadoPorTelefono.getIdCliente());
                    System.out.println("Direccion: " + clienteBuscadoPorTelefono.getDireccion());
                    System.out.println("Telefono: " + clienteBuscadoPorTelefono.getNumTelefono());
                    System.out.println("Correo elecrónico: " + clienteBuscadoPorTelefono.getEmail());
                    sc.nextLine();
                } else {
                    System.out.println("Cliente no encontrado");
                }
            }
            case 3 -> {
                System.out.println("Ingresa la dirección del cliente que quieres buscar");
                sc.nextLine();
                Cliente clienteBuscadoPorDireccion = Cliente.clienteBuscadoPorDireccion(sc.nextLine(), listaClientes, mapaClientes);
                if (clienteBuscadoPorDireccion != null) {
                    System.out.println("Cliente encontrado!!");
                    System.out.println("Nombre: " + clienteBuscadoPorDireccion.getNombre()
                            + " con el ID: " + clienteBuscadoPorDireccion.getIdCliente());
                    System.out.println("Direccion: " + clienteBuscadoPorDireccion.getDireccion());
                    System.out.println("Telefono: " + clienteBuscadoPorDireccion.getNumTelefono());
                    sc.nextLine();
                } else {
                    System.out.println("Cliente no encontrado ");
                }
            }
            case 4 -> Cliente.buscarClientePorID(sc, listaClientes, mapaClientes);
            default -> System.out.println("Opcion no valida");
        }
    }

    public static void ActualizarCliente(Scanner sc, HashMap<Integer, Cliente> mapaClientes) {
        System.out.println("Ingrese el ID del cliente a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero

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
                sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
                switch (opcionModificar) {
                    case 1 -> {
                        System.out.println("Ingresa la nueva dirección");
                        String nuevaDireccion = sc.nextLine();
                        sc.nextLine();
                        clienteactualizado.setDireccion(nuevaDireccion);
                        System.out.println("Dirección actualizada exitosamente");
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Ingresa el nuevo email");
                        String nuevoEmail = sc.nextLine();
                        sc.nextLine();
                        clienteactualizado.setEmail(nuevoEmail);
                        System.out.println("Email actualizado exitosamente");
                        salir = true;
                    }
                    case 3 -> {
                        System.out.println("Ingresa el nuevo nombre");
                        String nuevoNombre = sc.nextLine();
                        sc.nextLine();
                        clienteactualizado.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado exitosamente");
                        salir = true;
                    }
                    case 4 -> {
                        System.out.println("Ingresa el nuevo teléfono");
                        int nuevoTelefono = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
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
        Cliente clientedelete = mapaClientes.get(id); // Obtener el cliente del mapa directamente por su ID

        if (clientedelete != null) {
            listaClientes.remove(clientedelete);
            mapaClientes.remove(id);
            System.out.println("Cliente eliminado exitosamente.\n");
        } else {
            System.out.println("Cliente no encontrado.\n");
        }
    }


    // Otros métodos para manejar la lista de clientes
    public static void GuardarVenta(Scanner sc, ArrayList<Venta> listaVentas, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        Venta venta = new Venta();
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int idCliente = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
        Cliente cliente = mapaClientes.get(idCliente);
        if (cliente != null) {
            int idVenta;
            Random random = new Random();
            do {
                idVenta = random.nextInt(10000); // Número aleatorio entre 0 y 9999
            } while (mapaVentas.containsValue(idVenta));
            venta.setIdVenta(idVenta);
            mapaVentas.put(venta, idCliente);

            System.out.println("Venta guardada con idCliente de: " + cliente.idCliente +
                    "\nIdVenta de: " + venta.getIdVenta());

            System.out.println("Ingrese el precio de la venta : ");
            int precioVenta = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
            venta.setPrecio(precioVenta);
            listaVentas.add(venta);

            if (venta.getPrecio() < 200) {
                cliente.setTipoCliente(1); // Cliente regular
            } else {
                cliente.setTipoCliente(3); // Cliente Mayorista
            }
            System.out.println(cliente.getTipoCliente());

            if (cliente.getTipoCliente() == 1) {
                precioVenta = ClienteRegular.VerificarBonificacion(venta);
                venta.setPrecio(precioVenta); // Actualizar el precio de la venta con la bonificación aplicada
                System.out.println("Bonificación de Cliente Regular aplicada exitosamente.\n" +
                        "El nuevo precio es: " + precioVenta);

            } else if (cliente.getTipoCliente() == 3) {
                System.out.println(precioVenta);
                precioVenta = ClienteMayorista.VerificarBonificacion(venta);
                int envio=ClienteMayorista.gestionarPedido(cliente);
                venta.setPrecio(precioVenta); // Actualizar el precio de la venta con la bonificación aplicada
                System.out.println("Bonificación de Cliente Mayorista aplicada exitosamente.\n" +
                        "El nuevo precio es: " + precioVenta +
                        "\nEl precio de envio es: "+envio+
                        "\nDando un total de "+(precioVenta+envio));
            }
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    //    public static void GuardarVentaDos(HashMap<Venta, Integer> ventas, Scanner sc, String[]estadoVenta) {
//        int randomIndex = (int) (Math.random() * estadoVenta.length);
//        System.out.println("Estado de la venta: " + estadoVenta[randomIndex]);
//        Venta venta = new Venta();
//        Venta venta1 = new Venta(5, 123, 100, estadoVenta);
//        int x = sc.nextInt();
//        ventas.put(venta1, x);
//
//        for (Venta key : ventas.keySet()) {
//            if (ventas.get(key) == x) {
//                System.out.println("La llave correspondiente a x es: " + key.toString());
//            }
//        }
//    }
    public static void BuscarVentas(Scanner sc, HashMap<Integer, Cliente> mapaClientes, HashMap<Venta, Integer> mapaVentas) {
        System.out.println("Ingrese el ID del cliente a buscar: ");
        int idCliente = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner después de leer un entero
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
}
