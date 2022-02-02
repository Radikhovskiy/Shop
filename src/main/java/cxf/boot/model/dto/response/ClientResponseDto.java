package cxf.boot.model.dto.response;

import lombok.Data;

@Data
public class ClientResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
