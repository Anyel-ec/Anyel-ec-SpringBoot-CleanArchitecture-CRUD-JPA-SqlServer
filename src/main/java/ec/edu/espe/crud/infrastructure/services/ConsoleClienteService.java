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

            log.info("Lista de Clientes:");
            clienteList.forEach(cliente ->
                    log.info("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Email: " + cliente.getEmail()));
        } catch (Exception e) {
            log.error("Error al obtener los clientes: {}", e.getMessage());
        }
    }
    public static void main(String[] args) {
        ConsoleClienteService service = new ConsoleClienteService();
        service.printAllClientes();
    }
}
