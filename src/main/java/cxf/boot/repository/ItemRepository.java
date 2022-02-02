package cxf.boot.repository;

import cxf.boot.model.Item;
import cxf.boot.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByStatus(Status status);

    List<Item> findAllBySellerIdAndStatus(Long id, Status status);
}
