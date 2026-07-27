package org.factoriaf5.project_inside_out.mvc.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.factoriaf5.project_inside_out.mvc.controllers.MomentController;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentView {
    private MomentController controller;
    private Scanner scanner;
    private Map<Integer, Runnable> actions;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MomentView(MomentController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
        this.actions = new HashMap<>();
        actions.put(1, this::handleAddMoment);
        actions.put(2, this::handleListMoments);
        actions.put(3, this::handleDeleteMoment);
        actions.put(4, this::handleFilterMoments);
        actions.put(5, () -> System.out.println("Hasta la próxima!!!"));
    }

    private void showMenu() {
        System.out.println(
                """
                        My diario:
                            1. Añadir momento
                            2. Ver todos los momentos disponibles
                            3. Eliminar un momento
                            4. Filtrar los momentos
                            5. Salir
                        Seleccione una opción:
                        """);
    }

    private int readInt() {
        while (true) {
            String text = scanner.nextLine();
            try {
                return Integer.parseInt(text.trim());
            } catch (NumberFormatException e) {
                System.out.print("Debe introducir un número. Inténtelo de nuevo: ");
            }
        }
    }

    private int readIntInRange(String prompt, int min, int max) {
        int value;
        do {
            System.out.print(prompt);
            value = readInt();
            if (value < min || value > max) {
                System.out.println("Opción no válida, inténtelo de nuevo.");
            }
        } while (value < min || value > max);
        return value;
    }

    private int readOption() {
        showMenu();
        return readIntInRange("", 1, 5);
    }

    private Emotion readEmotion() {
        System.out.println("Selecciona una emoción:");
        int i = 1;
        for (Emotion e : Emotion.values()) {
            System.out.println(i + ". " + e.getLabel());
            i++;
        }
        int emotionOption = readIntInRange("Ingrese su opción: ", 1, Emotion.values().length);
        return Emotion.values()[emotionOption - 1];
    }

    private LocalDate readMomentDate() {
        LocalDate date = null;
        do {
            System.out.print("Ingrese la fecha (dd/mm/año): ");
            String text = scanner.nextLine();
            try {
                LocalDate parsed = LocalDate.parse(text, dateFormatter);
                if (parsed.isAfter(LocalDate.now())) {
                    System.out.println("La fecha no puede ser futura, inténtelo de nuevo.");
                } else {
                    date = parsed;
                }
            } catch (Exception e) {
                System.out.println("Fecha inválida, inténtelo de nuevo.");
            }
        } while (date == null);
        return date;
    }

    private void printMoments(List<Moment> moments) {
        if (moments.isEmpty()) {
            System.out.println("No hay momentos disponibles.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : moments) {
                System.out.println("ID: " + m.getId());
                System.out.println("Título: " + m.getTitle());
                System.out.println("Fecha: " + m.getMomentDate().format(dateFormatter));
                System.out.println("Descripción: " + m.getDescription());
                System.out.println("Emoción: " + m.getEmotion().getLabel());
                System.out.println("------------------------");
            }
        }
        System.out.println();
    }

    private boolean existsMomentWithId(int id) {
        for (Moment m : controller.listMoments()) {
            if (m.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void handleAddMoment() {
        System.out.print("Ingrese el título: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String description = scanner.nextLine();
        LocalDate parsedDate = readMomentDate();
        Emotion emotion = readEmotion();

        Moment moment = new Moment(title, description, emotion, parsedDate);
        controller.addMoment(moment);
        System.out.println("Momento vivido añadido correctamente.");
    }

    private void handleListMoments() {
        printMoments(controller.listMoments());
    }

    private void handleDeleteMoment() {
        printMoments(controller.listMoments());
        System.out.print("Ingresa el identificador del momento: ");
        int id = readInt();
        if (existsMomentWithId(id)) {
            controller.deleteMoment(id);
            System.out.println("Momento vivido eliminado correctamente.");
        } else {
            System.out.println("No existe ningún momento con ese identificador.");
        }
    }

    private void handleFilterMoments() {
        System.out.println(
                """
                        Filtrar por ...:
                        1. Emoción
                        2. Fecha
                        """);
        System.out.print("Ingrese una opción: ");
        int filterOption = readInt();

        if (filterOption == 1) {
            Emotion filterEmotion = readEmotion();
            printMoments(controller.filterByEmotion(filterEmotion));
        } else {
            LocalDate filterDate = readMomentDate();
            printMoments(controller.filterByMonth(filterDate));
        }
    }

    public void start() {
        int option;
        do {
            option = readOption();
            actions.get(option).run();
        } while (option != 5);
    }
}
