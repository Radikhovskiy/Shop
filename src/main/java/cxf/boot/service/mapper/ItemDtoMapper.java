package cxf.boot.service.mapper;

import cxf.boot.model.Item;
import cxf.boot.model.dto.request.ItemRequestDto;
import cxf.boot.model.dto.response.ItemResponseDto;
import cxf.boot.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemDtoMapper {
    private final ClientService clientService;

    public ItemResponseDto toDto(Item item) {
        ItemResponseDto dto = new ItemResponseDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setDescription(item.getDescription());
        dto.setStatus(item.getStatus());
        dto.setSellerId(item.getSeller().getId());
        return dto;
    }

    public Item toModel(ItemRequestDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setDescription(dto.getDescription());
        item.setStatus(dto.getStatus());
        item.setSeller(clientService.getById(dto.getSellerId()));
        return item;
    }
}
