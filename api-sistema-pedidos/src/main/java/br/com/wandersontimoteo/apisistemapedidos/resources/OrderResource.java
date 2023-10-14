package br.com.wandersontimoteo.apisistemapedidos.resources;

import br.com.wandersontimoteo.apisistemapedidos.entities.Order;
import br.com.wandersontimoteo.apisistemapedidos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAllOrders();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable UUID id) {
        Order obj = orderService.findByIdOrder(id);
        return ResponseEntity.ok().body(obj);
    }
}
