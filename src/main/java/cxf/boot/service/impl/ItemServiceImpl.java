package cxf.boot.service.impl;

import cxf.boot.model.Item;
import cxf.boot.model.Status;
import cxf.boot.repository.ItemRepository;
import cxf.boot.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public List<Item> findAllForSale() {
        return itemRepository.findAllByStatus(Status.SELLING);
    }

    @Override
    public List<Item> findAllForSaleByOwnerId(Long id) {
        return itemRepository.findAllBySellerIdAndStatus(id, Status.SELLING);
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.getById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
