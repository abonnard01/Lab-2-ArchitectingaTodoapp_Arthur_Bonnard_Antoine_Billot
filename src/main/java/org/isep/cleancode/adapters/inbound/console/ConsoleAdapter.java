package org.isep.cleancode.adapters.inbound.console;

import org.isep.cleancode.application.service.TodoService;
import org.isep.cleancode.domain.model.Todo;

import java.util.Scanner;

/**
 * Adapter console pour interagir avec l’utilisateur.
 */
public class ConsoleAdapter {
    private final TodoService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleAdapter(TodoService service) {
        this.service = service;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> createTodo();
                case "2" -> listTodos();
                case "3" -> markTodo();
                case "0" -> running = false;
                default -> System.out.println("Choix invalide.");
            }
        }
        System.out.println("Fin du programme.");
    }

    private void showMenu() {
        System.out.println("\n--- TODO MENU ---");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Voir toutes les tâches");
        System.out.println("3. Marquer comme faite");
        System.out.println("0. Quitter");
        System.out.print("> ");
    }

    private void createTodo() {
        System.out.print("Description : ");
        String desc = scanner.nextLine();
        service.createTodo(desc);
    }

    private void listTodos() {
        for (Todo todo : service.getAllTodos()) {
            System.out.println(todo);
        }
    }

    private void markTodo() {
        System.out.print("ID : ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (!service.markAsDone(id)) {
                System.out.println("Tâche non trouvée.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID invalide.");
        }
    }
}