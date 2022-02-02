package cxf.boot.model.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private String paymentMethod;
    private LocalDate data;
    private Long clientId;
    private List<Long> itemsId;
}
