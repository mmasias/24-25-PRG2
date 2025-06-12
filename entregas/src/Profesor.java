import java.util.*;

public class Profesor {
    private String nombre;
    private Asignatura asignatura;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAsignatura(Asignatura a) {
        this.asignatura = a;
    }

    public Examen crearExamen() {
        Examen e = new Examen(asignatura);
        e.addPregunta("¿Cuánto es 2+2?",
                      Arrays.asList("3", "4", "5"), 1);
        e.addPregunta("¿Derivada de x^2?",
                      Arrays.asList("x", "2x", "x^2"), 1);
        e.addPregunta("Integral de 1 dx?",
                      Arrays.asList("x + C", "1/x", "0"), 0);
        System.out.println("Examen de " + asignatura.getNombre() +
                           " creado con 3 preguntas.");
        return e;
    }

    public void supervisarExamen(Examen e) {
        e.simularRespuestas();
        System.out.println("Examen supervisado: respuestas registradas.\n");
    
        System.out.println("Preguntas del examen:");
        List<Pregunta> preguntas = e.getPreguntas();
        List<Integer> respuestas = e.getRespuestasAlumno();
        
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p = preguntas.get(i);
            System.out.println((i + 1) + ". " + p.getEnunciado());
            List<String> opciones = p.getOpciones();
            for (int j = 0; j < opciones.size(); j++) {
                System.out.println("   " + (char)('A' + j) + ") " + opciones.get(j));
            }
            System.out.println("=> Respuesta del alumno: " +
                (char)('A' + respuestas.get(i)) + "\n");
        }
    }
    

    public void evaluarExamen(Examen e) {
        int correctas = e.contarAciertos();
        System.out.println("Resultado: " + correctas + " de " +
                           e.getNumeroPreguntas() + " correctas.");
    }
}
