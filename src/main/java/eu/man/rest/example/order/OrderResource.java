package eu.man.rest.example.order;

import eu.man.rest.example.order.Order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResource {

    private Long id;

    private String title;

    private String description;

    private OrderStatus status;

    private Instant CreatedDate;

    private Instant lastModifiedDate;
}
