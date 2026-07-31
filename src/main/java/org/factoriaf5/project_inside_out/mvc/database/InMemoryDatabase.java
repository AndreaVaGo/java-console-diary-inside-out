package org.factoriaf5.project_inside_out.mvc.database;

import java.util.Collection;
import java.util.HashMap;
import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceDatabase;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class InMemoryDatabase implements InterfaceDatabase {
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

    @Override
    public Collection<Moment> getAll() {
        return moments.values();

    }

    @Override
    public void put(Integer id, Moment moment) {
        moments.put(id, moment);
    }

    @Override
    public void remove(Integer id) {
        moments.remove(id);
    }

}
