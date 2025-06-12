public class Examen {
    private String titulo;
    private String[] preguntas;
    private int total;

    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new String[3];
        this.total = 0;
    }

    public void agregarPregunta(String pregunta) {
        if (total < preguntas.length) {
            preguntas[total++] = pregunta;
        }
    }

    public void mostrar() {
        System.out.println("Examen: " + titulo);
        for (int i = 0; i < total; i++) {
            System.out.println("- Pregunta " + (i + 1) + ": " + preguntas[i]);
        }
    }
}
