package eu.man.rest.example;

import eu.man.rest.example.order.Order;
import eu.man.rest.example.order.Order.OrderDetail;
import eu.man.rest.example.order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class RestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return args -> {

            var items = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
            var orderDetails = List.of(new OrderDetail("My content 1", 1), new OrderDetail("My content 2", 2));
            var values = Map.of("key 1", "Value 1", "key 2", "Value 2");

            var order1 = Order.builder()
                    .title("My title 1")
                    .description("My description 1")
                    .sensitiveData(UUID.randomUUID().toString())
                    .numbers(items)
                    .orderDetails(orderDetails)
                    .values(values)
                    .action(new Order.Add("Add operation", Instant.now()))
//                    .actions(List.of(
//                            new Order.Add("Add operation 1"),
//                            new Order.Add("Add operation 2"),
//                            new Order.Remove("Remove operation 1", "other 1"),
//                            new Order.Remove("Remove operation 2", "other 2")
//                    ))
                    .status(Order.OrderStatus.CREATED)
                    .build();

            var order2 = Order.builder()
                    .title("My title 2")
                    .description("My description 2")
                    .sensitiveData(UUID.randomUUID().toString())
                    .numbers(items)
                    .orderDetails(orderDetails)
                    .values(values)
                    .action(new Order.Remove("Remove operation", "first", Instant.now()))
                    .status(Order.OrderStatus.CREATED)
                    .build();

            var order3 = Order.builder()
                    .title("My title 3")
                    .description("My description 3")
                    .sensitiveData(UUID.randomUUID().toString())
                    .numbers(items)
                    .orderDetails(orderDetails)
                    .values(values)
                    .action(new Order.Add("Add operation", Instant.now()))
                    .status(Order.OrderStatus.COMPLETED)
                    .build();

            var order4 = Order.builder()
                    .title("My title 4")
                    .description("My description 4")
                    .sensitiveData(UUID.randomUUID().toString())
                    .numbers(items)
                    .action(new Order.Remove("Remove operation", "second", Instant.now()))
                    .status(Order.OrderStatus.FAILED)
                    .build();

            var order5 = Order.builder()
                    .title("My title 5")
                    .description("My description 5")
                    .sensitiveData(UUID.randomUUID().toString())
                    .orderDetails(orderDetails)
                    .values(values)
                    .status(Order.OrderStatus.RUNNING)
                    .build();


            orderRepository.saveAll(List.of(order1, order2, order3, order4, order5));

            orderRepository.findAll()
                    .forEach(System.out::println);
        };
    }
}
