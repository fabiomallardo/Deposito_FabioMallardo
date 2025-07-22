package com.example.todolist.repository;

import com.example.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
// Tutti i metodi CRUD già pronti!
}
