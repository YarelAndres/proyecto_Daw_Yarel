import java.time.LocalDate;

public class ClienteInternacional extends Cliente {
    public ClienteInternacional(String nombre, String direccion, String email, LocalDate fechaRegistro, int numTelefono) {
        super(nombre, direccion, email, fechaRegistro, numTelefono);
    }
    public void calcularCostoEnvioInternacional() {
        System.out.println("Indique la region del envio:"+
                "1)Africa"+
                "2)America" +
                "3)Asia" +
                "4)Europa" +
                "5)Oceania");
        // Calculamos de costo de envío internacional basado en una tarifa plana
        double tarifaBase = 20.0;       // Tarifa base de envío internacional
        double pesoPaquete = 2.5;       // Peso del paquete en kilogramos
        double tarifa_kilogramo = 5;    // Tarifa por kilogramos
        String destino = "Mongolia";    // País de destino del envío

        // Calculamos del costo de envío
        double costoEnvio = tarifaBase + (pesoPaquete * tarifa_kilogramo);

        // Imprimimos el costo de envío calculado
        System.out.println("El costo de envío internacional " + destino +  " es: " + costoEnvio + "€");
    }



    public void gestionarAduanas() {
        // Simulación del proceso de despacho aduanero para el cliente internacional

        // Verificación de documentos aduaneros
        System.out.println("Verificando documentos aduaneros del cliente...");
        if (this.verificarDocumentacionAduanera()) {
            System.out.println("Documentos aduaneros verificados.");
        } else {
            System.out.println("Error: Documentos aduaneros incompletos o incorrectos.");
            return; // Si los documentos no están en orden, se detiene el proceso.
        }

        // Proceso de aduanas completado
        System.out.println("Proceso de aduanas completado para el cliente.");
    }


    private boolean verificarDocumentacionAduanera() {
        // Simulación de la verificación de documentos aduaneros
        return true; // En este ejemplo, siempre se asume que la documentación es válida
    }
}
