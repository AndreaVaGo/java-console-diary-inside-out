package org.factoriaf5.project_inside_out.mvc.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.database.InMemoryDatabase;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentRepository implements InterfaceRepository {

    private InMemoryDatabase database;

    public MomentRepository() {
        this.database = InMemoryDatabase.getInstance();
    }

    private int nextId() {
        int max = 0;
        for (Moment moment : database.getAll()) {
            if (moment.getId() != null && moment.getId() > max) {
                max = moment.getId();
            }
        }
        return max + 1;
    }

    @Override
    public void save(Moment moment) {
        int id = nextId();
        moment.setId(id);
        database.put(id, moment);
    }

    @Override
    public List<Moment> findAll() {
        return List.copyOf(database.getAll());
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    @Override
    public List<Moment> findByEmotion(Emotion emotion) {
        List<Moment> result = new ArrayList<>();
        for (Moment moment : findAll()) {
            if (moment.getEmotion() == emotion) {
                result.add(moment);
            }
        }
        return result;
    }

    @Override
    public List<Moment> findByMonth(LocalDate date) {
        List<Moment> result = new ArrayList<>();
        for (Moment moment : findAll()) {
            if (moment.getMomentDate().getMonthValue() == date.getMonthValue()
                    && moment.getMomentDate().getYear() == date.getYear()) {
                result.add(moment);
            }
        }
        return result;
    }
}
