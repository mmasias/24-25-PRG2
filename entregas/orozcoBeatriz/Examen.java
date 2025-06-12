package entregas.orozcoBeatriz;

public class Examen {
    private String asignatura;
    private Pregunta[] preguntas = new Pregunta[10];
    private int totalPreguntas = 0;

    public Examen(String asignatura) {
        this.asignatura = asignatura;
    }

    public void agregarPregunta(String texto) {
        if (totalPreguntas < preguntas.length) {
            preguntas[totalPreguntas] = new Pregunta(texto);
            totalPreguntas++;
        }
    }

    public void mostrarExamen() {
        for (int i = 0; i < totalPreguntas; i++) {
            preguntas[i].mostrar();
        }
    }

    public String getAsignatura() {
        return asignatura;
    }
}
