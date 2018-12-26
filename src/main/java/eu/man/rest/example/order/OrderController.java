package eu.man.rest.example.order;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "orders")
public class OrderController {

    private final OrderRepository orderRepository; // Create a OrderService.

    private final OrderResourceAssembler orderResourceAssembler;

    @GetMapping
    public ResponseEntity<List<Resource>> all() {
        var resources = orderResourceAssembler.toResources(orderRepository.findAll());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource<OrderResource>> one(@PathVariable Long id) {

        return orderRepository.findById(id)
                .map(orderResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

}
