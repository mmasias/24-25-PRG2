public class Examen {
    private String titulo;
    private Asignatura asignatura;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private Profesor vigilante;

    public Examen(String titulo, Asignatura asignatura) {
        this.titulo = titulo;
        this.asignatura = asignatura;
    }

    public void setPreguntas(String p1, String p2, String p3) {
        this.pregunta1 = p1;
        this.pregunta2 = p2;
        this.pregunta3 = p3;
    }

    public void setVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public String getDescripcionExamen() {
        String resultado = "\t\tExamen: " + titulo + "\n";

        if (vigilante != null) {
            resultado += "\t\t\tVigilado por: " + vigilante.getNombreCompleto() + "\n";
        }

        resultado += "\t\t\tPregunta 1: \"" + pregunta1 + "\"\n";
        resultado += "\t\t\tPregunta 2: \"" + pregunta2 + "\"\n";
        resultado += "\t\t\tPregunta 3: \"" + pregunta3 + "\"\n";

        return resultado;
    }
}
