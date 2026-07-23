package org.factoriaf5.project_inside_out.mvc.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmotionTest {

    @Test
    void shouldReturnLabelWhenEmotionIsJoy() {
        assertEquals("Alegría", Emotion.JOY.getLabel());
    }
}
