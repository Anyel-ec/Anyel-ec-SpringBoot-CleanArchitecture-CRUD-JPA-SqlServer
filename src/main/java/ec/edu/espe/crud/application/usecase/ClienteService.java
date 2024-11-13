package ec.edu.espe.crud.application.usecase;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.domain.model.Cliente;
import ec.edu.espe.crud.domain.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    public Cliente createOrUpdateCliente(Cliente cliente) {
        cliente.getPedidos().forEach(pedido -> pedido.setCliente(cliente));
        return clienteRepository.save(cliente);
    }


    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
