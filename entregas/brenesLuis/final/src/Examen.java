import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examen {
    private Asignatura asignatura;
    private Profesor vigilante;
    private List<String> preguntas;

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new ArrayList<>();
    }

    public void setVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public void disennarExamen(Scanner scanner) {
        System.out.println("Disennando el examen para " + asignatura.getNombre());
        System.out.print("¿Cuántas preguntas desea ingresar?: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Pregunta " + i + ": ");
            preguntas.add(scanner.nextLine());
        }
    }

    public void mostrar() {
        System.out.println("\n--- Examen de " + asignatura.getNombre() + " ---");
        System.out.println("Vigilante: " + (vigilante != null ? vigilante.getNombre() : "No asignado"));
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println((i + 1) + ". " + preguntas.get(i));
        }
    }
}