package cxf.boot.service.mapper;

import cxf.boot.model.Item;
import cxf.boot.model.Order;
import cxf.boot.model.dto.request.OrderRequestDto;
import cxf.boot.model.dto.response.OrderResponseDto;
import cxf.boot.service.ClientService;
import cxf.boot.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderDtoMapper {
    private final ClientService clientService;
    private final ItemService itemService;

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setData(order.getData());
        dto.setClientId(order.getClient().getId());
        dto.setItemsId(order.getItems().stream()
                .map(Item::getId)
                .collect(Collectors.toList()));
        return dto;
    }

    public Order toModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setData(dto.getData());
        order.setClient(clientService.getById(dto.getClientId()));
        order.setItems(dto.getItemsId().stream()
                .map(itemService::getById)
                .collect(Collectors.toList()));
        return order;
    }
}
