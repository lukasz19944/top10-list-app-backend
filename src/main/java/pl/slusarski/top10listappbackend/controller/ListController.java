package pl.slusarski.top10listappbackend.controller;

import org.springframework.web.bind.annotation.*;
import pl.slusarski.top10listappbackend.domain.List;
import pl.slusarski.top10listappbackend.service.ListService;

@RestController
@RequestMapping("/api/list")
@CrossOrigin
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("")
    public Iterable<List> getAllLists() {
        return listService.findAllLists();
    }

    @GetMapping("/{listId}")
    public List getListById(@PathVariable String listId) {
        return listService.findListById(Long.parseLong(listId));
    }

    @PostMapping("")
    public List createNewList(@RequestBody List list) {
        return listService.saveOrUpdateList(list);
    }

    @DeleteMapping("/{listId}")
    public String deleteList(@PathVariable String listId) {
        listService.deleteListById(Long.parseLong(listId));

        return "List " + listId + " deleted";
    }
}
