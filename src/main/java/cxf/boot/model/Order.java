package cxf.boot.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentMethod;
    private LocalDate data;
    @OneToOne
    private Client client;
    @ManyToMany
    private List<Item> items;
}
