package com.example.todo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

/**
 * Service layer for managing Todo entities.
 * Handles business logic, validation, and persistence.
 */
@Service
public class TodoService {
    private final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }

    /**
     * Return a paginated list of todos.
     */
    public Page<Todo> list(Pageable pageable){
        return repo.findAll(pageable);
    }

    /**
     * Create a new todo with default values if needed.
     * - Title must not be null/blank
     * - Status defaults to PENDING
     * - createdAt defaults to current time
     */
    public Todo create(Todo input){
        if(input.getTitle() == null || input.getTitle().isBlank()){
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if(input.getStatus() == null){
            input.setStatus(Status.PENDING);
        }

        if(input.getCreatedAt() == null){
            input.setCreatedAt(java.time.LocalDateTime.now());
        }
        return repo.save(input);
    }

    /**
     * Update an existing todo by ID.
     * Only updates fields provided in the request.
     */
    @Transactional
    public Todo update(UUID id, Todo changes){
        Todo existing = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"todo not found"));

        if(changes.getTitle() != null && !changes.getTitle().isBlank()){
            existing.setTitle(changes.getTitle());
        }

        if(changes.getStatus() != null){
            existing.setStatus(changes.getStatus());
        }

        existing.setUpdatedAt(java.time.LocalDateTime.now());

        return existing;
    }

    /**
     * Delete a todo by ID.
     */
    public void delete(UUID id){
        if(!repo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"todo not found");
        }
        repo.deleteById(id);
    }

    /**
     * Retrieve a single todo by ID.
     */
    public Todo getById(UUID id){
        return repo.findById(id).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"todo not found"));
    }
}
