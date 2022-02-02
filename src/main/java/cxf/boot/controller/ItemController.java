package cxf.boot.controller;

import cxf.boot.model.Item;
import cxf.boot.model.dto.request.ItemForClientRequestDto;
import cxf.boot.model.dto.request.ItemRequestDto;
import cxf.boot.model.dto.response.ItemResponseDto;
import cxf.boot.service.ClientService;
import cxf.boot.service.ItemService;
import cxf.boot.service.mapper.ItemDtoMapper;
import cxf.boot.service.mapper.ItemForClientDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    private final ItemForClientDtoMapper itemForClientDtoMapper;
    private final ItemService itemService;
    private final ClientService clientService;
    private final ItemDtoMapper mapper;

    @GetMapping()
    public List<ItemResponseDto> getAll() {
        return itemService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/selling")
    public List<ItemResponseDto> getAllForSale() {
        return itemService.findAllForSale().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/owner")
    public List<ItemResponseDto> getAllItemsByOwnerId(@RequestParam Long id) {
        return itemService.findAllForSaleByOwnerId(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ItemResponseDto save(@RequestBody ItemRequestDto dto) {
        Item item = mapper.toModel(dto);
        return mapper.toDto(itemService.save(item));
    }

    @PostMapping("/{id}")
    public ItemResponseDto saveForClient(@PathVariable Long id, @RequestBody ItemForClientRequestDto dto) {
        Item item = itemForClientDtoMapper.toModel(dto);
        item.setSeller(clientService.getById(id));
        return mapper.toDto(itemService.save(item));
    }

    @PutMapping("/{id}")
    public ItemResponseDto update(@PathVariable Long id, @RequestBody ItemRequestDto dto) {
        Item item = mapper.toModel(dto);
        item.setId(id);
        return mapper.toDto(itemService.save(item));
    }

    @GetMapping("/{id}")
    public ItemResponseDto getById(@PathVariable Long id) {
        return mapper.toDto(itemService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemService.delete(itemService.getById(id));
    }
}
