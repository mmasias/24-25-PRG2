package rivasMiguel;

import java.util.Scanner;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura[] asignaturas;
    private Examen[] examenes;
    private int numAsignaturas;
    private int numExamenes;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignaturas = new Asignatura[10];
        this.examenes = new Examen[10];
        this.numAsignaturas = 0;
        this.numExamenes = 0;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }

    public int getNumAsignaturas() { return numAsignaturas; }
    public Asignatura getAsignatura(int i) { return asignaturas[i]; }
    public boolean tieneAsignatura(Asignatura a) {
        for (int i = 0; i < numAsignaturas; i++) if (asignaturas[i] == a) return true;
        return false;
    }

    public void asignarAsignatura(Asignatura a) {
        if (!tieneAsignatura(a)) {
            asignaturas[numAsignaturas++] = a;
            a.setProfesor(this);
        }
    }

    public void quitarAsignatura(Asignatura a) {
        for (int i = 0; i < numAsignaturas; i++) {
            if (asignaturas[i] == a) {
                asignaturas[i] = asignaturas[--numAsignaturas];
                a.removeProfesor();
                return;
            }
        }
    }

    public Examen crearExamen(String nombreEx, Asignatura a, Scanner sc) {
        System.out.println("Creando examen '" + nombreEx + "' para " + a.getNombre());
        String[] preguntas = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Pregunta " + (i+1) + ": ");
            preguntas[i] = sc.nextLine();
        }
        Examen e = new Examen(nombreEx, a, preguntas, this);
        examenes[numExamenes++] = e;
        return e;
    }

    public void darExamen(Profesor vigilante, Examen e) {
        if (vigilante.getNumAsignaturas() != 0) {
            System.out.println("Error: el profesor vigilante debe no tener asignaturas asignadas.");
            return;
        }
        System.out.println("El profesor " + nombre + " da el examen '" + e.getNombre() + "' al vigilante " + vigilante.getNombre());
    }

    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + "), asigna " + numAsignaturas + " asignatura(s)";
    }
}
