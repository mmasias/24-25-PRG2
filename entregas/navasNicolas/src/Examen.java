import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Examen {
    String materia;
    List<String> enunciados = new ArrayList<>();
    List<List<String>> opciones  = new ArrayList<>();
    List<Integer> idxCorrectas   = new ArrayList<>();
    List<Integer> respuestasAlumno = new ArrayList<>();

    public Examen(String materia) {
        this.materia = materia;
    }

    public void addPregunta(String texto, List<String> opts, int idxCorrecta) {
        enunciados.add(texto);
        opciones.add(opts);
        idxCorrectas.add(idxCorrecta);
    }

    public void simularRespuestas() {
        Random r = new Random();
        respuestasAlumno.clear();
        for (int i = 0; i < enunciados.size(); i++) {
            respuestasAlumno.add(r.nextInt(3));
        }
    }

    public void imprimirPreguntasYRespuestas() {
        System.out.println("Preguntas y respuestas del alumno:");
        for (int i = 0; i < enunciados.size(); i++) {
            System.out.println((i+1) + ". " + enunciados.get(i));
            for (int j = 0; j < opciones.get(i).size(); j++) {
                System.out.println("   " + (char)('A'+j) + ") " + opciones.get(i).get(j));
            }
            System.out.println("=> Alumno respondió: " +
                (char)('A' + respuestasAlumno.get(i)) + "\n");
        }
    }

    public void evaluar() {
        int aciertos = 0;
        for (int i = 0; i < idxCorrectas.size(); i++) {
            if (respuestasAlumno.get(i).equals(idxCorrectas.get(i))) {
                aciertos++;
            }
        }
        System.out.println("Resultado: " + aciertos + " de " +
                           enunciados.size() + " correctas.");
    }
}
