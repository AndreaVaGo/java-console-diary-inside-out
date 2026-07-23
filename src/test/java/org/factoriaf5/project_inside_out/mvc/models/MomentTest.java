package org.factoriaf5.project_inside_out.mvc.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class MomentTest {

    @Test
    void shouldReturnTitleWhenMomentIsCreated() {
        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", null, null);
        assertEquals("Un día en el parque", moment.getTitle());
    }

    @Test
    void shouldReturnEmotionWhenMomentIsCreated() {
        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", Emotion.JOY, null);
        assertEquals(Emotion.JOY, moment.getEmotion());
    }

    @Test
    void shouldReturnMomentDateWhenMomentIsCreated() {
        LocalDate momentDate = LocalDate.of(2024, 5, 1);
        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", Emotion.JOY, momentDate);
        assertEquals(momentDate, moment.getMomentDate());
    }

    @Test
    void shouldReturnCreationDateWhenMomentIsCreated() {
        LocalDate momentDate = LocalDate.of(2024, 5, 1);
        Moment moment = new Moment("Un día en el parque", "Lorem ipsum dolor sit amet", Emotion.JOY, momentDate);
        assertEquals(LocalDate.now(), moment.getCreationDate());
    }
}
