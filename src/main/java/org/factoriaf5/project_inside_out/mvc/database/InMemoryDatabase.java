package org.factoriaf5.project_inside_out.mvc.database;

import java.util.Collection;
import java.util.HashMap;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class InMemoryDatabase {
    // Guarda la única instancia de InMemoryDatabase que existe en todo el programa
    // (patrón Singleton)
    private static InMemoryDatabase instance;
    private HashMap<Integer, Moment> moments = new HashMap<>();

    private InMemoryDatabase() {
    }

    public static InMemoryDatabase getInstance() {
        if (instance == null) {
            instance = new InMemoryDatabase();
        }
        return instance;
    }

    public Collection<Moment> getAll() {
        return moments.values();

    }
}
