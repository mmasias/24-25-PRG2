import java.util.ArrayList;
import java.util.List;

public class Examen {
    private List<String> preguntas;
    private List<String> respuestas;

    public Examen() {
        this.preguntas = new ArrayList<>();
        this.respuestas = new ArrayList<>();
    }

    public void agregarPregunta(String pregunta) {
        this.preguntas.add(pregunta);
    }

    public void agregarRespuesta(String respuesta) {
        this.respuestas.add(respuesta);
    }

    public List<String> getPreguntas() {
        return new ArrayList<>(this.preguntas);
    }

    public List<String> getRespuestas() {
        return new ArrayList<>(this.respuestas);
    }
}
