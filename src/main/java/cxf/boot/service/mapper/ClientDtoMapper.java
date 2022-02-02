package cxf.boot.service.mapper;

import cxf.boot.model.Client;
import cxf.boot.model.dto.request.ClientRequestDto;
import cxf.boot.model.dto.response.ClientResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoMapper {
    public ClientResponseDto toDto(Client client) {
        ClientResponseDto dto = new ClientResponseDto();
        dto.setId(client.getId());
        dto.setFirstname(client.getFirstname());
        dto.setLastname(client.getLastname());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public Client toModel(ClientRequestDto dto) {
        Client client = new Client();
        client.setFirstname(dto.getFirstname());
        client.setLastname(dto.getLastname());
        client.setEmail(dto.getEmail());
        return client;
    }
}
