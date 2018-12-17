package eu.man.rest.example.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String sensitiveData;

    @CreatedDate
    private Instant CreatedDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    public enum OrderStatus {
        CREATED,
        RUNNING,
        FAILED,
        COMPLETED
    }

}

