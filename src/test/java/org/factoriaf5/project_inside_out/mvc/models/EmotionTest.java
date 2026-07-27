package org.factoriaf5.project_inside_out.mvc.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EmotionTest {

    @Test
    void shouldReturnLabelWhenEmotionIsJoy() {
        assertEquals("Alegría", Emotion.JOY.getLabel());
    }

    @ParameterizedTest
    @MethodSource("provideEmotions")
    void shouldReturnLabelForEachEmotion(Emotion emotion, String expectedLabel) {
        assertEquals(expectedLabel, emotion.getLabel());
    }

    static Stream<Arguments> provideEmotions() {
        return Stream.of(
                Arguments.of(Emotion.JOY, "Alegría"),
                Arguments.of(Emotion.SADNESS, "Tristeza"),
                Arguments.of(Emotion.ANGER, "Ira"),
                Arguments.of(Emotion.DISGUST, "Asco"),
                Arguments.of(Emotion.FEAR, "Miedo"),
                Arguments.of(Emotion.ANXIETY, "Ansiedad"),
                Arguments.of(Emotion.ENVY, "Envidia"),
                Arguments.of(Emotion.SHAME, "Vergüenza"),
                Arguments.of(Emotion.BOREDOM, "Aburrimiento"),
                Arguments.of(Emotion.NOSTALGIA, "Nostalgia"));
    }
}
