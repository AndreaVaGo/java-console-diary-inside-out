package org.factoriaf5.project_inside_out;

import java.util.Scanner;

import org.factoriaf5.project_inside_out.mvc.controllers.MomentController;
import org.factoriaf5.project_inside_out.mvc.repositories.MomentRepository;
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
        MomentController controller = new MomentController(repository);
        MomentView view = new MomentView(controller, scanner);
        view.start();
    }
}
