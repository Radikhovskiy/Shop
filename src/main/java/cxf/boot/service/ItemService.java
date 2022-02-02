package cxf.boot.service;

import cxf.boot.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item save(Item item);

    Item getById(Long id);

    void delete(Item item);

    List<Item> findAllForSale();

    List<Item> findAllForSaleByOwnerId(Long id);
}
