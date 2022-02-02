package cxf.boot.service;

import cxf.boot.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order getById(Long id);

    Order save(Order order);

    List<Order> findAllByClientId(Long id);
}
