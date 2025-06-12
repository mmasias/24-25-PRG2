public class Examen {
    String titulo;
    Asignatura asignatura;
    String pregunta1;
    String pregunta2;
    String pregunta3;

    public Examen(String titulo, Asignatura asignatura) {
        this.titulo = titulo;
        this.asignatura = asignatura;
    }

    public void agregarPreguntas(String p1, String p2, String p3) {
        this.pregunta1 = p1;
        this.pregunta2 = p2;
        this.pregunta3 = p3;
    }
}
