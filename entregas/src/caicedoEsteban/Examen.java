public class Examen {

    private String titulo;
    private Asignatura asignatura;
    private String[] preguntas = new String[3];
    private int contadorPreguntas = 0;

    public Examen(String titulo, Asignatura asignatura) {
        this.titulo = titulo;
        this.asignatura = asignatura;
    }

    public void agregarPregunta(String pregunta) {
        if (contadorPreguntas < 3) {
            preguntas[contadorPreguntas] = pregunta;
            contadorPreguntas++;
        } else {
            System.out.println("No se pueden agregar más de 3 preguntas al examen.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public int getCantidadPreguntas() {
        return contadorPreguntas;
    }
}
