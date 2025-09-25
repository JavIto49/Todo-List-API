package com.example.todo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity class representing a Todo item.
 * Maps to the "Todos" table and includes fields
 * for ID, title, timestamps, and status.
 */
@Entity
@Table(name = "Todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // Primary key

    @Column(nullable = false)
    private String title; // Description of the task

    private LocalDateTime createdAt; // Time of task creation
    private LocalDateTime updatedAt; // Time of task update

    @Enumerated(EnumType.STRING)
    private Status status; // Task state

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate dueDate;

    // --- Getters & setters ---
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
}