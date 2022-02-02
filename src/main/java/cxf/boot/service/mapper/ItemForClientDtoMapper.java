package cxf.boot.service.mapper;

import cxf.boot.model.Item;
import cxf.boot.model.dto.request.ItemForClientRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ItemForClientDtoMapper {
    public Item toModel(ItemForClientRequestDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setDescription(dto.getDescription());
        item.setStatus(dto.getStatus());
        return item;
    }
}
