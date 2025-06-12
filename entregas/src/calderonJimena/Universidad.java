package entregas.src.calderonJimena;

import java.util.Scanner;

public class Universidad {
    private static final int NUMERO_PREGUNTAS = 3;

    private String nombre;
    private Profesor profesorImparte;
    private Profesor profesorVigilante;
    private Asignatura asignatura;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public static Universidad crearUniversidadCompleta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre de la universidad: ");
        String nombreUniversidad = scanner.nextLine();
        Universidad universidad = new Universidad(nombreUniversidad);

        universidad.profesorImparte = Profesor.crearProfesorPorDatos("que imparte la asignatura");
        universidad.asignatura = Asignatura.crearAsignatura(universidad.profesorImparte);

        do {
            universidad.profesorVigilante = Profesor.crearProfesorPorDatos("vigilante");
            if (universidad.profesorVigilante.getDni().equals(universidad.profesorImparte.getDni())) {
                System.out.println(
                        "El profesor vigilante no puede ser el mismo que el que imparte la asignatura. Intente otra vez.");
            }
        } while (universidad.profesorVigilante.getDni().equals(universidad.profesorImparte.getDni()));

        universidad.examen = Examen.crearExamen(universidad.asignatura, universidad.profesorVigilante,
                NUMERO_PREGUNTAS);

        return universidad;
    }

    public void mostrarTodo() {
        System.out.println("=========================================");
        System.out.println("\nResumen: ");
        System.out.println("=========================================");
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesorImparte.getNombre() + " | DNI: " + profesorImparte.getDni());
        System.out.println(" Asignatura: " + asignatura.getNombre() + " - " + asignatura.getAbreviatura() + " - "
                + asignatura.getCreditos() + " créditos ");
        System.out.println("  Examen: " + examen.getTipo().toLowerCase());
        System.out
                .println("   Vigilado por: " + profesorVigilante.getNombre() + " | DNI: " + profesorVigilante.getDni());

        String[] preguntas = examen.getPreguntas();
        for (int numeroPregunta = 0; numeroPregunta < preguntas.length; numeroPregunta++) {
            System.out.println("   Pregunta " + (numeroPregunta + 1) + ": " + preguntas[numeroPregunta]);
        }
    }

}
