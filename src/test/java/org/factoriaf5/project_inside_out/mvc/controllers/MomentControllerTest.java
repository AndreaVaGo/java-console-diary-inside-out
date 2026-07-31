package org.factoriaf5.project_inside_out.mvc.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.factoriaf5.project_inside_out.mvc.contracts.InterfaceRepository;
import org.factoriaf5.project_inside_out.mvc.dtos.MomentDto;
import org.factoriaf5.project_inside_out.mvc.mappers.MomentMapper;
import org.factoriaf5.project_inside_out.mvc.models.Emotion;

import org.factoriaf5.project_inside_out.mvc.repositories.MomentRepository;
import org.factoriaf5.project_inside_out.mvc.services.MomentService;
import org.junit.jupiter.api.Test;

public class MomentControllerTest {

    @Test
    void shouldAddMoment() {
        MomentService service = new MomentService(new MomentRepository(), new MomentMapper());
        MomentController controller = new MomentController(service);
        int sizeBefore = controller.listMoments().size();

        MomentDto moment = new MomentDto(null, "Título A", "Descripción A", Emotion.JOY, LocalDate.of(2024, 5, 1), null, null);
        controller.addMoment(moment);

        assertEquals(sizeBefore + 1, controller.listMoments().size());
    }

    @Test
    void shouldListMoments() {
        MomentService service = new MomentService(new MomentRepository(), new MomentMapper());
        MomentController controller = new MomentController(service);

        assertTrue(controller.listMoments().size() >= 0);
    }

    @Test
    void shouldDeleteMoment() {
        MomentService service = new MomentService(new MomentRepository(), new MomentMapper());
        MomentController controller = new MomentController(service);

        MomentDto moment = new MomentDto(null, "Título B", "Descripción B", Emotion.SADNESS, LocalDate.of(2024, 6, 1), null, null);
        controller.addMoment(moment);
        int sizeBefore = controller.listMoments().size();
        Integer lastId = controller.listMoments().get(controller.listMoments().size() - 1).getId();

        controller.deleteMoment(lastId);

        assertEquals(sizeBefore - 1, controller.listMoments().size());
    }

    @Test
    void shouldFilterByEmotion() {
        MomentService service = new MomentService(new MomentRepository(), new MomentMapper());
        MomentController controller = new MomentController(service);

        MomentDto moment = new MomentDto(null, "Título C", "Descripción C", Emotion.ANGER, LocalDate.of(2024, 7, 1), null, null);
        controller.addMoment(moment);

        assertTrue(controller.filterByEmotion(Emotion.ANGER).size() >= 1);
    }

    @Test
    void shouldFilterByMonth() {
        MomentService service = new MomentService(new MomentRepository(), new MomentMapper());
        MomentController controller = new MomentController(service);

        LocalDate date = LocalDate.of(2024, 8, 1);
        MomentDto moment = new MomentDto(null, "Título D", "Descripción D", Emotion.FEAR, date, null, null);
        controller.addMoment(moment);

        assertTrue(controller.filterByMonth(date).size() >= 1);
    }

    @Test
    void shouldCallSaveWhenAddingMomentWithMock() {
        InterfaceRepository mockRepository = mock(InterfaceRepository.class);
        MomentService service = new MomentService(mockRepository, new MomentMapper());
        MomentController controller = new MomentController(service);

        MomentDto moment = new MomentDto(null, "Título Mock", "Descripción Mock", Emotion.JOY, LocalDate.of(2024, 5, 1), null, null);
        controller.addMoment(moment);

        verify(mockRepository).save(org.mockito.ArgumentMatchers.any());
    }
}
