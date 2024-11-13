package ec.edu.espe.crud.application.usecase;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.domain.model.Pedido;
import ec.edu.espe.crud.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getPedidosByClienteId(int clienteId) {
        return pedidoRepository.findByCliente_Id(clienteId);
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(int idPedido) {
        pedidoRepository.deleteById(idPedido);
    }

}
