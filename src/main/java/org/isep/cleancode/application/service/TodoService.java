package org.isep.cleancode.application.service;

import org.isep.cleancode.domain.model.Todo;
import org.isep.cleancode.domain.port.TodoRepository;

import java.util.List;

/**
 * Cas d’usage principal : gestion des tâches.
 */
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(String description) {
        int id = repository.getNextId();
        Todo todo = new Todo(id, description);
        return repository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public boolean markAsDone(int id) {
        Todo todo = repository.findById(id);
        if (todo == null) return false;
        todo.markAsDone();
        return true;
    }
}