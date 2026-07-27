package org.factoriaf5.project_inside_out.mvc.repositories;

import java.time.LocalDate;
import java.util.List;

import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.database.InMemoryDatabase;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public class MomentRepository implements InterfaceRepository {

    private InMemoryDatabase database;
    private Integer nextId = 1;

    public MomentRepository() {
        this.database = InMemoryDatabase.getInstance();
    }

    @Override
    public void save(Moment moment) {
        database.put(nextId, moment);
        nextId++;
    }

    @Override
    public List<Moment> findAll() {
        return List.copyOf(database.getAll());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Moment> findByEmotion(Emotion emotion) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmotion'");
    }

    @Override
    public List<Moment> findByMonth(LocalDate date) {
        throw new UnsupportedOperationException("Unimplemented method 'findByMonth'");
    }

}
