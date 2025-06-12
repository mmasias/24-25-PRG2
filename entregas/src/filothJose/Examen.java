package filothJose;
import java.util.ArrayList;
import java.util.List;

public class Examen {
    private String tipo; 
    private Asignatura asignatura;
    private List<String> preguntas;
    Profesor profesorVigilante; 
    public Examen(String tipo, Asignatura asignatura) {
        this.tipo = tipo;
        this.asignatura = asignatura;
        this.preguntas = new ArrayList<>();
        crearPreguntas();
    }

    private void crearPreguntas() {
        preguntas.add("¿Qué es una clase en Java?");
        preguntas.add("¿Cómo se implementa la herencia?");
        preguntas.add("¿Qué es el polimorfismo?");
    }

    public String getTipo() {
        return tipo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public Profesor getProfesorVigilante() {
        return profesorVigilante;
    }
}
