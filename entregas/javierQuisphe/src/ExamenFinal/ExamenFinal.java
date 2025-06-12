import java.util.Scanner;

class Asignatura {
    String nombre

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }
}

class Examen {
    Asignatura asignatura;
    Profesor creador;
    Profesor vigilante;

    public Examen(Asignatura asignatura, Profesor creador, Profesor vigilante) {
        this.asignatura = asignatura;
        this.creador = creador;
        this.vigilante = vigilante;
    }

    public void infoExamen() {
        System.out.println("Profesor: " + creador.getNombre());
        System.out.println("Asignatura: " + asignatura.nombre)
        System.out.println("Vigilado por : " + vigilante.getNombre())
    }
}