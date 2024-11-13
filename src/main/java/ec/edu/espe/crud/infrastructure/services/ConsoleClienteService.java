package ec.edu.espe.crud.infrastructure.services;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.domain.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ConsoleClienteService {

    private static final Logger log = LoggerFactory.getLogger(ConsoleClienteService.class);
    private static final String BASE_URL = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public ConsoleClienteService() {
        this.restTemplate = new RestTemplate();
    }

    public void printAllClientes() {
        String url = BASE_URL + "/api/clientes";
        try {
            Cliente[] clientes = restTemplate.getForObject(url, Cliente[].class);
            List<Cliente> clienteList = Arrays.asList(clientes);

            if (clienteList.isEmpty()) {
                log.info("\n🔍 No se encontraron clientes en el sistema. ¡Es hora de agregar algunos!\n");
            } else {
                log.info("\n================= 📋 Lista de Clientes 📋 =================");
                clienteList.forEach(cliente ->
                        log.info("🔹 ID: {} | Nombre: {} | Email: {}", cliente.getId(), cliente.getNombre(), cliente.getEmail()));
                log.info("===========================================================\n");
            }
        } catch (Exception e) {
            log.error("\n❌ Error al intentar obtener la lista de clientes: {}\n", e.getMessage());
            log.error("🔧 Verifica que el servidor esté en ejecución y que la URL '{}' sea accesible.\n", url);
        }
    }

    public static void main(String[] args) {
        ConsoleClienteService service = new ConsoleClienteService();
        log.info("\n🌐 Iniciando el servicio de consulta de clientes...");
        service.printAllClientes();
        log.info("✅ Servicio finalizado. ¡Gracias por usar el sistema de clientes!\n");
    }
}
