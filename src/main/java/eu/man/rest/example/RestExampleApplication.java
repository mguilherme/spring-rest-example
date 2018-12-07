package eu.man.rest.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
                    .build();

            var order2 = Order.builder()
                    .title("My title 2")
                    .description("My description 2")
                    .build();

            var order3 = Order.builder()
                    .title("My title 3")
                    .description("My description 3")
                    .build();

            orderRepository.saveAll(List.of(order1, order2, order3));

            orderRepository.findAll()
                    .forEach(System.out::println);
        };
    }
}
