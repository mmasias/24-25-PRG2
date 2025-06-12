import java.util.Arrays;

public class Profesor {
    String nombre;
    String asignatura; 

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public Examen crearExamen() {
        Examen examen = new Examen(asignatura);
        examen.addPregunta("¿Cuánto es 2+2?",
                      Arrays.asList("3","4","5"), 1);
        examen.addPregunta("¿Derivada de x^2?",
                      Arrays.asList("x","2x","x^2"), 1);
        examen.addPregunta("Integral de 1 dx?",
                      Arrays.asList("x + C","1/x","0"), 0);
        System.out.println("Examen de " + asignatura +
                           " creado con 3 preguntas.");
        return examen;
    }

    public void supervisarExamen(Examen examen) {
        examen.simularRespuestas();
        System.out.println("Examen supervisado: respuestas registradas.\n");
        examen.imprimirPreguntasYRespuestas();
    }
}
