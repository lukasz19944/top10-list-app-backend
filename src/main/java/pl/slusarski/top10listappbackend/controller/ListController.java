package pl.slusarski.top10listappbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.slusarski.top10listappbackend.domain.List;
import pl.slusarski.top10listappbackend.service.ErrorService;
import pl.slusarski.top10listappbackend.service.ListService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/list")
@CrossOrigin
public class ListController {

    private final ListService listService;
    private final ErrorService errorService;

    public ListController(ListService listService, ErrorService errorService) {
        this.listService = listService;
        this.errorService = errorService;
    }

    @GetMapping("")
    public Iterable<List> getAllLists() {
        return listService.findAllLists();
    }

    @GetMapping("/{listId}")
    public ResponseEntity<?> getListById(@PathVariable String listId) {
        List list = listService.findListById(Long.parseLong(listId));

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewList(@Valid @RequestBody List list, BindingResult result) {
        ResponseEntity<?> errorMap = errorService.mapValidationService(result);

        if (errorMap != null) {
            return errorMap;
        }

        List newList = listService.saveOrUpdateList(list);

        return new ResponseEntity<>(newList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity<?> deleteList(@PathVariable String listId) {
        listService.deleteListById(Long.parseLong(listId));

        return new ResponseEntity<>("List " + listId + " deleted", HttpStatus.OK);
    }
}
