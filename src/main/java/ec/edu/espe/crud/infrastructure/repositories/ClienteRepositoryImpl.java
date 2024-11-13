package ec.edu.espe.crud.infrastructure.repositories;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import ec.edu.espe.crud.domain.model.Cliente;
import ec.edu.espe.crud.domain.repository.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryImpl extends JpaRepository<Cliente, Integer>, ClienteRepository {

}