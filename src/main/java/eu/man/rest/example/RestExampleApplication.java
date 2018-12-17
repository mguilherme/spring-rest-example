package eu.man.rest.example;

import eu.man.rest.example.order.Order;
import eu.man.rest.example.order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class RestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return args -> {

            var order1 = Order.builder()
                    .title("My title 1")
                    .description("My description 1")
                    .sensitiveData(UUID.randomUUID().toString())
                    .status(Order.OrderStatus.CREATED)
                    .build();

            var order2 = Order.builder()
                    .title("My title 2")
                    .description("My description 2")
                    .sensitiveData(UUID.randomUUID().toString())
                    .status(Order.OrderStatus.CREATED)
                    .build();

            var order3 = Order.builder()
                    .title("My title 3")
                    .description("My description 3")
                    .sensitiveData(UUID.randomUUID().toString())
                    .status(Order.OrderStatus.COMPLETED)
                    .build();

            var order4 = Order.builder()
                    .title("My title 4")
                    .description("My description 4")
                    .sensitiveData(UUID.randomUUID().toString())
                    .status(Order.OrderStatus.FAILED)
                    .build();

            var order5 = Order.builder()
                    .title("My title 5")
                    .description("My description 5")
                    .sensitiveData(UUID.randomUUID().toString())
                    .status(Order.OrderStatus.RUNNING)
                    .build();


            orderRepository.saveAll(List.of(order1, order2, order3, order4, order5));

            orderRepository.findAll()
                    .forEach(System.out::println);
        };
    }
}
