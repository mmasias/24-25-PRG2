package entregas.src.calderonJimena;

import java.util.Scanner;

public class Examen {
    private String tipo;
    private Profesor profesorVigilante;
    private String[] listaPreguntas;

    public Examen(String tipo, Profesor profesorVigilante, String[] listaPreguntas) {
        this.tipo = tipo;
        this.profesorVigilante = profesorVigilante;
        this.listaPreguntas = listaPreguntas;
    }

    public static Examen crearExamen(Asignatura asignatura, Profesor profesorVigilante, int cantidadPreguntas) {
        Scanner scanner = new Scanner(System.in);

        String tipoExamen;
        while (true) {
            System.out.print("Tipo de examen (final o parcial): ");
            tipoExamen = scanner.nextLine().trim().toLowerCase();

            if (tipoExamen.equals("final") || tipoExamen.equals("parcial")) {
                break;
            } else {
                System.out.println("Por favor, escriba solo 'final' o 'parcial'.");
            }
        }

        String[] preguntasDelExamen = new String[cantidadPreguntas];
        for (int numeroPregunta = 0; numeroPregunta < cantidadPreguntas; numeroPregunta++) {
            System.out.print("Pregunta " + (numeroPregunta + 1) + ": ");
            preguntasDelExamen[numeroPregunta] = scanner.nextLine();
        }

        return new Examen(tipoExamen, profesorVigilante, preguntasDelExamen);
    }

    public String getTipo() {
        return tipo;
    }

    public Profesor getProfesorVigilante() {
        return profesorVigilante;
    }

    public String[] getPreguntas() {
        return listaPreguntas;
    }
}
