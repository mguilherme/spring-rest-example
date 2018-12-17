package eu.man.rest.example.order;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, Resource> {

    public OrderResourceAssembler() {
        super(OrderController.class, Resource.class);
    }

    @Override
    public Resource<OrderResource> toResource(Order entity) {

//        OrderResource orderResource = OrderMapper.INSTANCE.orderToOrderResource(entity);

        var resource = new Resource<>(OrderMapper.INSTANCE.orderToOrderResource(entity));

        resource.add(linkTo(methodOn(OrderController.class)
                .one(entity.getId())).withSelfRel());

        return resource;
    }

}
