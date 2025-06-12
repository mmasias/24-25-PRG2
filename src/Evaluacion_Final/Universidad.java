package Evaluacion_Final;

public class Universidad {
    String nombre;
    Profesor profesor;
    Vigilante vigilante;

    public Universidad(String nombre, Profesor profesor, Vigilante vigilante) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.vigilante = vigilante;
    }

    public void mostrarInformacion() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor.nombre + "   / DNI " + profesor.dni);
        System.out.println("Asignatura: " + profesor.asignatura.nombre + " - " + profesor.asignatura.creditos + " creditos");
        System.out.println("Examen: Examen Final");
        System.out.println("Vigilado por : " + vigilante.nombre + "   / DNI " + vigilante.dni);
        System.out.println("Pregunta 1 : \"" + profesor.examen.preguntas.pregunta_1() + "\"");
        System.out.println("Pregunta 2 : \"" + profesor.examen.preguntas.pregunta_2() + "\"");
        System.out.println("Pregunta 3 : \"" + profesor.examen.preguntas.pregunta_3() + "\"");
    }
}