package com.example.todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public Page<Todo> list(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
        return service.list(PageRequest.of(page, size, Sort.by("createdAt").descending()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo body){
        return service.create(body);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable UUID id, @RequestBody Todo body){
        return service.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable UUID id){
        return service.getById(id);
    }
}
