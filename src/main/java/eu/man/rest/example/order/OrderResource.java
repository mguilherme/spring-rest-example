package eu.man.rest.example.order;

import eu.man.rest.example.order.Order.Action;
import eu.man.rest.example.order.Order.OrderDetail;
import eu.man.rest.example.order.Order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResource {

    private Long id;

    private String title;

    private String description;

    private OrderStatus status;

    private List<String> numbers;

    private List<OrderDetail> orderDetails;

    private Map<String, String> values;

    private Action action;

    private Instant CreatedDate;

    private Instant lastModifiedDate;
}
