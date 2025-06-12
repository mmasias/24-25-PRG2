import java.util.*;

public class Pregunta {
    private String enunciado;
    private List<String> opciones;
    private int indiceCorrecta;

    public Pregunta(String enunciado,
                    List<String> opciones,
                    int indiceCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.indiceCorrecta = indiceCorrecta;
    }

    public boolean isCorrecta(int respuestaIdx) {
        return respuestaIdx == indiceCorrecta;
    }
}
