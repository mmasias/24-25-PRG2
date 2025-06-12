package entregas.src_GabrielBéjar;

public class Examen {
    private String titulo;
    private String[] preguntas;

    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new String[3];
    }

    public void setPregunta(int indice, String contenido) {
        if (indice >= 1 && indice <= 3) {
            preguntas[indice - 1] = contenido;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getPreguntas() {
        return preguntas;
    }
}
