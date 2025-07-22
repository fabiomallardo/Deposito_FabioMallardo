package com.example.todolist.service;

import com.example.todolist.repository.*;
import com.example.todolist.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getAll() {
        List<Todo> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
    }

    public Optional<Todo> getById(Long id) {
        return repo.findById(id);
    }

    public Todo create(Todo nuovo) {
        return repo.save(nuovo);
    }

    public Optional<Todo> update(Long id, Todo modificato) {
        return repo.findById(id).map(t -> {
            t.setDescrizione(modificato.getDescrizione());
            t.setCompletato(modificato.isCompletato());
            return repo.save(t);
        });
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
