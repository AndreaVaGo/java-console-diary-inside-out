package org.factoriaf5.project_inside_out.mvc.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideEmotionsWithTitles")
    void shouldFindMomentsByEmotion(Emotion emotion, String title) {
        MomentRepository repository = new MomentRepository();
        Moment moment = new Moment(title, "Descripción de prueba", emotion, LocalDate.of(2024, 9, 1));
        repository.save(moment);

        assertTrue(repository.findByEmotion(emotion).size() >= 1);
    }

    static Stream<Arguments> provideEmotionsWithTitles() {
        return Stream.of(
                Arguments.of(Emotion.SADNESS, "Momento triste"),
                Arguments.of(Emotion.ANXIETY, "Momento ansioso"),
                Arguments.of(Emotion.NOSTALGIA, "Momento nostálgico"));
    }
}
