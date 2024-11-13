package ec.edu.espe.crud.infrastructure.controllers;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.application.usecase.PedidoService;
import ec.edu.espe.crud.domain.model.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> getPedidosByClienteId(@PathVariable int clienteId) {
        return pedidoService.getPedidosByClienteId(clienteId);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    @DeleteMapping("/{idPedido}")
    public void deletePedido(@PathVariable int idPedido) {
        pedidoService.deletePedido(idPedido);
    }
}
