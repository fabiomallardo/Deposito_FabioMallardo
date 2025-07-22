package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo nuovo) {
        Todo creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo modificato) {
        return service.update(id, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean rimosso = service.delete(id);
        return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}