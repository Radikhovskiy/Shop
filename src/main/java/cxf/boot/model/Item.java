package cxf.boot.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne
    private Client seller;
}


