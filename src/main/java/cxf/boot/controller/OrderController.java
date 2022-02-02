package cxf.boot.controller;

import cxf.boot.model.Order;
import cxf.boot.model.dto.request.OrderRequestDto;
import cxf.boot.model.dto.response.OrderResponseDto;
import cxf.boot.service.OrderService;
import cxf.boot.service.mapper.OrderDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderDtoMapper mapper;

    @GetMapping()
    public List<OrderResponseDto> getAll() {
        return orderService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public OrderResponseDto save(@RequestBody OrderRequestDto dto) {
        Order order = mapper.toModel(dto);
        return mapper.toDto(orderService.save(order));
    }

    @GetMapping("/client")
    public List<OrderResponseDto> getAllByClientId(@RequestParam Long id) {
        return orderService.findAllByClientId(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return mapper.toDto(orderService.getById(id));
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id, @RequestBody OrderRequestDto dto) {
        Order order = mapper.toModel(dto);
        order.setId(id);
        return mapper.toDto(orderService.save(order));
    }
}
