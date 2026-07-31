package org.factoriaf5.project_inside_out.mvc.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.factoriaf5.project_inside_out.mvc.controllers.MomentController;
import org.factoriaf5.project_inside_out.mvc.mappers.MomentMapper;
import org.factoriaf5.project_inside_out.mvc.repositories.MomentRepository;
import org.factoriaf5.project_inside_out.mvc.services.MomentService;
import org.junit.jupiter.api.Test;

public class MomentViewTest {

    @Test
    void shouldAddAndListMomentThenExit() {
        String simulatedInput = "1\n"
                + "Título de prueba\n"
                + "Descripción de prueba\n"
                + "01/05/2024\n"
                + "1\n"
                + "2\n"
                + "5\n";
        Scanner scanner = new Scanner(simulatedInput);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        MomentRepository repository = new MomentRepository();
        MomentMapper mapper = new MomentMapper();
        MomentService service = new MomentService(repository, mapper);
        MomentController controller = new MomentController(service);
        MomentView view = new MomentView(controller, scanner);
        view.start();

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Momento vivido añadido correctamente."));
        assertTrue(output.contains("Título de prueba"));
        assertTrue(output.contains("Hasta la próxima!!!"));
    }
}
