package cxf.boot.service.impl;

import cxf.boot.model.Order;
import cxf.boot.repository.OrderRepository;
import cxf.boot.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAllByClientId(Long id) {
        return orderRepository.findAllByClientId(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
