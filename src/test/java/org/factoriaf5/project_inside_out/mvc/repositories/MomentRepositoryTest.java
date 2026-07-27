package org.factoriaf5.project_inside_out.mvc.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;
import org.junit.jupiter.api.Test;

public class MomentRepositoryTest {

    @Test
    void shouldSaveMoment() {
        MomentRepository repository = new MomentRepository();
        int sizeBefore = repository.findAll().size();
        LocalDate momentDate = LocalDate.of(2024, 5, 1);
        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", Emotion.JOY, momentDate);
        repository.save(moment);
        assertEquals(sizeBefore + 1, repository.findAll().size());
    }
}
