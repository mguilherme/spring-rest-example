package eu.man.rest.example.order;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
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

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<String> numbers;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<OrderDetail> orderDetails;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> values;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Action action;

//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb")
//    private List<Action> actions;

    public enum OrderStatus {
        CREATED,
        RUNNING,
        FAILED,
        COMPLETED
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetail implements Serializable {
        private String content;
        private Integer amount;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public interface Action extends Serializable {
        String getOperation();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add implements Action {
        private String operation;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Remove implements Action {
        private String operation;
        private String other;
    }

}

