package org.factoriaf5.project_inside_out.mvc.contracts;

import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

import java.time.LocalDate;
import java.util.List;

public interface InterfaceRepository {
    public void save(Moment moment);

    public List<Moment> findAll();

    public void delete(Integer id);

    public List<Moment> findByEmotion(Emotion emotion);

    public List<Moment> findByMonth(LocalDate date);

}
