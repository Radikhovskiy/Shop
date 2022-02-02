package cxf.boot.model.dto.response;

import cxf.boot.model.Status;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ItemResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Status status;
    private Long sellerId;
}
