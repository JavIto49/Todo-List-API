package com.example.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Application configuration for initializing the database.
 * Seeds a couple of Todo entries on startup if the repository is empty.
 */
@Configuration
public class TodoConfig {
    @Bean
    CommandLineRunner seedTodos(TodoRepository repo){
        return args -> {
            if(repo.count() == 0){
                Todo t1 = new Todo();
                t1.setTitle("Finish Todo API");
                t1.setStatus(Status.PENDING);
                t1.setCreatedAt(LocalDateTime.now());

                t1.setDueDate(LocalDate.from(LocalDateTime.now().plusDays(3)));
                t1.setPriority(Priority.HIGH);

                Todo t2 = new Todo();
                t2.setTitle("Prepare for the career fair");
                t2.setStatus(Status.PENDING);
                t2.setCreatedAt(LocalDateTime.now());

                t2.setDueDate(LocalDate.from(LocalDateTime.now().plusWeeks(1)));
                t2.setPriority(Priority.LOW);

                repo.save(t1);
                repo.save(t2);
            }
        };
    }
}