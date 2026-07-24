package org.factoriaf5.project_inside_out.mvc.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InMemoryDatabaseTest {

    @Test
    void shouldGetAllMoments() {
        InMemoryDatabase database = InMemoryDatabase.getInstance();
        assertEquals(true, database.getAll().isEmpty());
    }
}
