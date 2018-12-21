package eu.man.rest.example.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderDetails", target = "orderDetails")
    @Mapping(source = "values", target = "values")
    @Mapping(source = "action", target = "action")
    OrderResource orderToOrderResource(Order order);
}
