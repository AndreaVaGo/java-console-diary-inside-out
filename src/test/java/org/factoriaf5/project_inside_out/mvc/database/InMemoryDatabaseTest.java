package org.factoriaf5.project_inside_out.mvc.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;
import org.junit.jupiter.api.Test;

public class InMemoryDatabaseTest {

    @Test
    void shouldGetAllMoments() {
        InMemoryDatabase database = InMemoryDatabase.getInstance();
        assertNotNull(database.getAll());
    }

    @Test
    void shouldPutMoments() {
        InMemoryDatabase database = InMemoryDatabase.getInstance();
        int sizeBefore = database.getAll().size();

        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", Emotion.JOY,
                LocalDate.of(2024, 5, 1));
        Integer id = 1;
        database.put(id, moment);

        assertEquals(sizeBefore + 1, database.getAll().size());
    }
}
