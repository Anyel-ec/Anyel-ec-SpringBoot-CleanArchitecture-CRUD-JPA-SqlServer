package ec.edu.espe.crud.infrastructure.configuration;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.application.usecase.ClienteService;
import ec.edu.espe.crud.application.usecase.PedidoService;
import ec.edu.espe.crud.domain.repository.ClienteRepository;
import ec.edu.espe.crud.domain.repository.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    public ApplicationConfig(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Bean
    public ClienteService clienteService() {
        return new ClienteService(clienteRepository);
    }

    @Bean
    public PedidoService pedidoService() {
        return new PedidoService(pedidoRepository);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
