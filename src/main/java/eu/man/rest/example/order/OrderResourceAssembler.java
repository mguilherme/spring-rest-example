package eu.man.rest.example.order;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, Resource> {

    public OrderResourceAssembler() {
        super(OrderController.class, Resource.class);
    }

    @Override
    public Resource<OrderResource> toResource(Order entity) {
        var resource = new Resource<>(OrderMapper.INSTANCE.orderToOrderResource(entity));

        resource.add(linkTo(methodOn(OrderController.class)
                .one(entity.getId())).withSelfRel());

        return resource;
    }

//    @Override
//    public List<Resource> toResources(Iterable<? extends Order> entities) {
//
//        return StreamSupport.stream(entities.spliterator(), false)
//                .map(this::toResource)
//                .collect(Collectors.toList());
//
//    }

}
