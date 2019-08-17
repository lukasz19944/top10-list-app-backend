package pl.slusarski.top10listappbackend.service;

import org.springframework.stereotype.Service;
import pl.slusarski.top10listappbackend.domain.Item;
import pl.slusarski.top10listappbackend.domain.List;
import pl.slusarski.top10listappbackend.repository.ItemRepository;
import pl.slusarski.top10listappbackend.repository.ListRepository;

import java.util.Optional;

@Service
public class ListService {

    private final ListRepository listRepository;
    private final ItemRepository itemRepository;

    public ListService(ListRepository listRepository, ItemRepository itemRepository) {
        this.listRepository = listRepository;
        this.itemRepository = itemRepository;
    }

    public Iterable<List> findAllLists() {
        return listRepository.findAll();
    }

    public List findListById(Long id) {
        Optional<List> listOptional = listRepository.findById(id);

        return listOptional.get();
    }

    public List saveOrUpdateList(List list) {
        for (Item item : list.getItems()) {
            item.setList(list);
            itemRepository.save(item);
        }

        return listRepository.save(list);
    }

    public void deleteListById(Long listId) {
        List list = findListById(listId);
        listRepository.delete(list);
    }
}
