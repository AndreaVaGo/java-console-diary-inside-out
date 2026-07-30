package org.factoriaf5.project_inside_out.mvc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;
import org.factoriaf5.project_inside_out.mvc.models.Moment;
import org.factoriaf5.project_inside_out.mvc.repositories.MomentRepository;
import org.junit.jupiter.api.Test;

public class MomentControllerTest {

    @Test
    void shouldAddMoment() {
        MomentRepository repository = new MomentRepository();
        MomentController controller = new MomentController(repository);
        int sizeBefore = controller.listMoments().size();

        Moment moment = new Moment("Título A", "Descripción A", Emotion.JOY, LocalDate.of(2024, 5, 1));
        controller.addMoment(moment);

        assertEquals(sizeBefore + 1, controller.listMoments().size());
    }

    @Test
    void shouldListMoments() {
        MomentRepository repository = new MomentRepository();
        MomentController controller = new MomentController(repository);

        assertTrue(controller.listMoments().size() >= 0);
    }

    @Test
    void shouldDeleteMoment() {
        MomentRepository repository = new MomentRepository();
        MomentController controller = new MomentController(repository);

        Moment moment = new Moment("Título B", "Descripción B", Emotion.SADNESS, LocalDate.of(2024, 6, 1));
        controller.addMoment(moment);
        int sizeBefore = controller.listMoments().size();

        controller.deleteMoment(moment.getId());

        assertEquals(sizeBefore - 1, controller.listMoments().size());
    }

    @Test
    void shouldFilterByEmotion() {
        MomentRepository repository = new MomentRepository();
        MomentController controller = new MomentController(repository);

        Moment moment = new Moment("Título C", "Descripción C", Emotion.ANGER, LocalDate.of(2024, 7, 1));
        controller.addMoment(moment);

        assertTrue(controller.filterByEmotion(Emotion.ANGER).size() >= 1);
    }

    @Test
    void shouldFilterByMonth() {
        MomentRepository repository = new MomentRepository();
        MomentController controller = new MomentController(repository);

        LocalDate date = LocalDate.of(2024, 8, 1);
        Moment moment = new Moment("Título D", "Descripción D", Emotion.FEAR, date);
        controller.addMoment(moment);

        assertTrue(controller.filterByMonth(date).size() >= 1);
    }

    @Test
    void shouldCallSaveWhenAddingMomentWithMock() {
        InterfaceRepository mockRepository = mock(InterfaceRepository.class);
        MomentController controller = new MomentController(mockRepository);

        Moment moment = new Moment("Título Mock", "Descripción Mock", Emotion.JOY, LocalDate.of(2024, 5, 1));
        controller.addMoment(moment);

        verify(mockRepository).save(moment);
    }
}
