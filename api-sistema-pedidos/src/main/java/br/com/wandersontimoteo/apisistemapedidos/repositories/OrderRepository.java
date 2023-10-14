package br.com.wandersontimoteo.apisistemapedidos.repositories;

import br.com.wandersontimoteo.apisistemapedidos.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
