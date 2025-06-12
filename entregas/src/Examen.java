import java.util.*;

public class Examen {
    private Asignatura asignatura;
    private List<Pregunta> preguntas = new ArrayList<>();
    private List<Integer> respuestasAlumno = new ArrayList<>();

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void addPregunta(String enunciado,
                            List<String> opciones,
                            int idxCorrecta) {
        preguntas.add(new Pregunta(enunciado, opciones, idxCorrecta));
    }

    public int getNumeroPreguntas() {
        return preguntas.size();
    }

    public void simularRespuestas() {
        Random rnd = new Random();
        respuestasAlumno.clear();
        for (Pregunta p : preguntas) {
            respuestasAlumno.add(rnd.nextInt(3));  
        }
    }

    public int contarAciertos() {
        int aciertos = 0;
        for (int i = 0; i < preguntas.size(); i++) {
            if (preguntas.get(i).isCorrecta(respuestasAlumno.get(i))) {
                aciertos++;
            }
        }
        return aciertos;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    public List<Integer> getRespuestasAlumno() {
        return respuestasAlumno;
    }
    
}
