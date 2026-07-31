package org.factoriaf5.project_inside_out;

import java.util.Scanner;

import org.factoriaf5.project_inside_out.mvc.controllers.MomentController;
import org.factoriaf5.project_inside_out.mvc.mappers.MomentMapper;
import org.factoriaf5.project_inside_out.mvc.repositories.MomentRepository;
import org.factoriaf5.project_inside_out.mvc.services.MomentService;
import org.factoriaf5.project_inside_out.mvc.views.MomentView;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Arranca la aplicación Mi Diario.
     *
     * @param args Argumentos del programa.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MomentRepository repository = new MomentRepository();
        MomentMapper mapper = new MomentMapper();
        MomentService service = new MomentService(repository, mapper);
        MomentController controller = new MomentController(service);
        MomentView view = new MomentView(controller, scanner);
        view.start();
    }
}
