package pl.slusarski.top10listappbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.slusarski.top10listappbackend.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
