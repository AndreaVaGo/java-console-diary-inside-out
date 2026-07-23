package org.factoriaf5.project_inside_out.mvc.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MomentTest {

    @Test
    void shouldReturnTitleWhenMomentIsCreated() {
       Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet");
       assertEquals("Un día en el parque", moment.getTitle());
    }
}
