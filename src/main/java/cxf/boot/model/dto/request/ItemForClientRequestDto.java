package cxf.boot.model.dto.request;

import cxf.boot.model.Status;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ItemForClientRequestDto {
    private String name;
    private BigDecimal price;
    private String description;
    private Status status;
}
