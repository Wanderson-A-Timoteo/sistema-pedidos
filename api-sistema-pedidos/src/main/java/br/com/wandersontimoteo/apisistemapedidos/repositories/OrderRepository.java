package br.com.wandersontimoteo.apisistemapedidos.repositories;

import br.com.wandersontimoteo.apisistemapedidos.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
