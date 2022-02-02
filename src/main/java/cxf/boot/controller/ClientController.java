package cxf.boot.controller;

import cxf.boot.model.Client;
import cxf.boot.model.dto.request.ClientRequestDto;
import cxf.boot.model.dto.response.ClientResponseDto;
import cxf.boot.service.ClientService;
import cxf.boot.service.mapper.ClientDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientDtoMapper mapper;

    @GetMapping
    public List<ClientResponseDto> getAll() {
        return clientService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientResponseDto getById(@PathVariable Long id) {
        return mapper.toDto(clientService.getById(id));
    }

    @PostMapping
    public ClientResponseDto save(@RequestBody ClientRequestDto dto) {
        Client client = mapper.toModel(dto);
        return mapper.toDto(clientService.save(client));
    }

    @PutMapping("/{id}")
    public ClientResponseDto update(@PathVariable Long id, @RequestBody ClientRequestDto dto) {
        Client client = mapper.toModel(dto);
        client.setId(id);
        return mapper.toDto(clientService.save(client));
    }
}


