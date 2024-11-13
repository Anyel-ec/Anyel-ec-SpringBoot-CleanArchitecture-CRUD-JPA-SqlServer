package ec.edu.espe.crud.domain.repository;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.domain.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    List<Pedido> findByCliente_Id(int id);
    Pedido save(Pedido pedido);
    void deleteById(int id);
}
