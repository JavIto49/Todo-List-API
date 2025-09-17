package com.example.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * JPA repository for managing Todo entities.
 * Extends JpaRepository to inherit standard CRUD operations.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
}