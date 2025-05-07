package org.isep.cleancode.adapters.outbound;

import org.isep.cleancode.domain.model.Todo;
import org.isep.cleancode.domain.port.TodoRepository;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Adapter de persistance : stocke les tâches dans un fichier CSV.
 */
public class CsvTodoRepository implements TodoRepository {
    private static final String FILE_PATH = "todos.csv";
    private final List<Todo> todos = new ArrayList<>();
    private int nextId = 1;

    public CsvTodoRepository() {
        loadFromFile();
    }

    @Override
    public Todo save(Todo todo) {
        todos.add(todo);
        saveToFile();
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    @Override
    public Todo findById(int id) {
        return todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getNextId() {
        return nextId++;
    }

    private void loadFromFile() {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) return;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", -1);
                if (parts.length < 3) continue;

                int id = Integer.parseInt(parts[0]);
                String desc = parts[1];
                boolean done = Boolean.parseBoolean(parts[2]);

                Todo todo = new Todo(id, desc);
                if (done) todo.markAsDone();
                todos.add(todo);

                if (id >= nextId) nextId = id + 1;
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture CSV : " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (Todo todo : todos) {
                writer.write(todo.getId() + ";" + todo.getDescription() + ";" + todo.isDone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur écriture CSV : " + e.getMessage());
        }
    }
}