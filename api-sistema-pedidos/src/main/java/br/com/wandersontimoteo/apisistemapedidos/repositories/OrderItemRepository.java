package br.com.wandersontimoteo.apisistemapedidos.repositories;

import br.com.wandersontimoteo.apisistemapedidos.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
