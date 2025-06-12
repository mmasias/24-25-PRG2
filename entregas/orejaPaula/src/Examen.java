
public class Examen {
    private String titulo;
    private String[] preguntas;
    private int contador;

    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new String[3];
        this.contador = 0;
    }

    public void agregarPregunta(String pregunta) {
        if (contador < 3) {
            preguntas[contador] = pregunta;
            contador++;
        }
    }

    public void mostrar() {
        System.out.println("Examen: " + titulo);
        for (int i = 0; i < contador; i++) {
            System.out.println("- Pregunta " + (i + 1) + ": " + preguntas[i]);
        }
    }
}
