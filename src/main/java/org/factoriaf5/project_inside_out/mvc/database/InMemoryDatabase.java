package org.factoriaf5.project_inside_out.mvc.database;

public class InMemoryDatabase {
    // Guarda la única instancia de InMemoryDatabase que existe en todo el programa
    // (patrón Singleton)
    private static InMemoryDatabase instance;

    private InMemoryDatabase() {
    }

    public static InMemoryDatabase getInstance() {
        if (instance == null) {
            instance = new InMemoryDatabase();
        }
        return instance;
    }
}
