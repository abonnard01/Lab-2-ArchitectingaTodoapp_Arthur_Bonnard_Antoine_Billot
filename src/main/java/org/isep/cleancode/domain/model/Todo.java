package org.isep.cleancode.domain.model;

/**
 * Représente une tâche à faire.
 */
public class Todo {
    private final int id;
    private final String description;
    private boolean done;

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void markAsDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return String.format("%d. [%s] %s", id, done ? "X" : " ", description);
    }
}