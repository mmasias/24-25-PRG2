package valdesCarlos;

public class Examen {
    private Profesor creador;
    private String[] preguntas = new String[10];
    private int totalPreguntas = 0;

    public Examen(Profesor creador) {
        this.creador = creador;
    }

    public void crearPregunta(String pregunta) {
        if (totalPreguntas < preguntas.length) {
            preguntas[totalPreguntas] = pregunta;
            totalPreguntas++;
        } else {
            System.out.println("No se pueden añadir más preguntas.");
        }
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public int getTotalPreguntas() {
        return totalPreguntas;
    }
}
