package cxf.boot.controller;

import cxf.boot.model.Client;
import cxf.boot.model.Item;
import cxf.boot.model.Order;
import cxf.boot.model.Status;
import cxf.boot.service.ClientService;
import cxf.boot.service.ItemService;
import cxf.boot.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class StartController {
    private final ClientService clientService;
    private final OrderService orderService;
    private final ItemService itemService;

    @GetMapping
    public String welcome() {
        return "Hello! To add data enter '/inject'";
    }

    @GetMapping("/inject")
    public String inject() {
        Client roma = new Client();
        roma.setEmail("roma@gmail.com");
        roma.setFirstname("Roman");
        roma.setLastname("Romanovich");

        Client petro = new Client();
        petro.setEmail("petro@gmail.com");
        petro.setFirstname("Petro");
        petro.setLastname("Petrovich");

        Client ivan = new Client();
        ivan.setEmail("ivan@gmail.com");
        ivan.setFirstname("Ivan");
        ivan.setLastname("Ivanovich");

        clientService.save(roma);
        clientService.save(petro);
        clientService.save(ivan);

        Item item1 = new Item();
        item1.setName("item1");
        item1.setSeller(roma);
        item1.setStatus(Status.SELLING);
        item1.setPrice(BigDecimal.valueOf(100));

        Item item2 = new Item();
        item2.setName("item2");
        item2.setSeller(petro);
        item2.setStatus(Status.SELLING);
        item2.setPrice(BigDecimal.valueOf(200));

        Item item3 = new Item();
        item3.setName("item3");
        item3.setSeller(ivan);
        item3.setStatus(Status.SOLD);
        item3.setPrice(BigDecimal.valueOf(300));

        itemService.save(item1);
        itemService.save(item2);
        itemService.save(item3);

        Order order1 = new Order();
        order1.setData(LocalDate.of(2022, 1, 25));
        order1.setPaymentMethod("Card");
        order1.setClient(roma);
        order1.setItems(List.of(item1, item2));

        Order order2 = new Order();
        order2.setData(LocalDate.of(2022, 1, 20));
        order2.setPaymentMethod("Cash");
        order2.setClient(petro);
        order2.setItems(List.of(item1, item3));

        Order order3 = new Order();
        order3.setData(LocalDate.of(2022, 1, 29));
        order3.setPaymentMethod("Card");
        order3.setClient(ivan);
        order3.setItems(List.of(item2));

        orderService.save(order1);
        orderService.save(order2);
        orderService.save(order3);

        return "Test data was added!";
    }
}
