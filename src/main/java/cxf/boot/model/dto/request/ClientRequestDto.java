package cxf.boot.model.dto.request;

import lombok.Data;

@Data
public class ClientRequestDto {
    private String firstname;
    private String lastname;
    private String email;
}
