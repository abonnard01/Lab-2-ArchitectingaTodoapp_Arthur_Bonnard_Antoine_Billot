package org.isep.cleancode.domain.port;

import org.isep.cleancode.domain.model.Todo;
import java.util.List;

/**
 * Port pour la persistance des tâches.
 */
public interface TodoRepository {
    Todo save(Todo todo);
    List<Todo> findAll();
    Todo findById(int id);
    int getNextId();
}