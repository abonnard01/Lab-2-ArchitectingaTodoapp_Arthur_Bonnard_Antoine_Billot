package org.isep.cleancode;

import org.isep.cleancode.adapters.inbound.console.ConsoleAdapter;
import org.isep.cleancode.adapters.outbound.CsvTodoRepository;
import org.isep.cleancode.application.service.TodoService;

/**
 * Point d’entrée de l’application.
 */
public class Main {
    public static void main(String[] args) {
        var repository = new CsvTodoRepository();
        var service = new TodoService(repository);
        var console = new ConsoleAdapter(service);
        console.run();
    }
}