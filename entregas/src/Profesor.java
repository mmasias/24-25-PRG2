// Profesor.java
import java.util.Arrays;

public class Profesor {
    String nombre;
    String asignatura;  // sin setter/getter

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public Examen crearExamen() {
        Examen e = new Examen(asignatura);
        // 3 preguntas fijas con 3 opciones cada una
        e.addPregunta("¿Cuánto es 2+2?",
                      Arrays.asList("3","4","5"), 1);
        e.addPregunta("¿Derivada de x^2?",
                      Arrays.asList("x","2x","x^2"), 1);
        e.addPregunta("Integral de 1 dx?",
                      Arrays.asList("x + C","1/x","0"), 0);
        System.out.println("Examen de " + asignatura +
                           " creado con 3 preguntas.");
        return e;
    }

    public void supervisarExamen(Examen e) {
        e.simularRespuestas();
        System.out.println("Examen supervisado: respuestas registradas.\n");
        e.imprimirPreguntasYRespuestas();
    }
}
