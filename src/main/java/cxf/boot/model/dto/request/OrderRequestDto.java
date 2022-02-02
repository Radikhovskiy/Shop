package cxf.boot.model.dto.request;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequestDto {
    private String paymentMethod;
    private LocalDate data;
    private Long clientId;
    private List<Long> itemsId;
}
