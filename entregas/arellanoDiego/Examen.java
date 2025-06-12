public class Examen {
    private String titulo;
    private Asignatura asignatura;
    private Profesor vigilante;
    private Pregunta[] preguntas;
    private int contadorPreguntas;

    public Examen(String titulo, Asignatura asignatura) {
        this.titulo = titulo;
        this.asignatura = asignatura;
        this.vigilante = null;
        this.preguntas = new Pregunta[3];
        this.contadorPreguntas = 0;
    }

    public void agregarPregunta(String enunciado) {
        if (contadorPreguntas < preguntas.length) {
            this.preguntas[this.contadorPreguntas] = new Pregunta(enunciado);
            this.contadorPreguntas++;
        }
    }

    public void asignarVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public String mostrar() {
        String texto = "\t\t\tExamen: " + this.titulo + "\n";
        if (this.vigilante != null) {
            texto += "\t\t\t\tVigilado por: " + this.vigilante.nombre + " / dni " + this.vigilante.dni + "\n";
        }
        for (int i = 0; i < this.contadorPreguntas; i++) {
            texto += "\t\t\t\tPregunta " + (i + 1) + ": " + this.preguntas[i].mostrar() + "\n";
        }
        return texto;
    }

    private static class Pregunta {

        public Pregunta(String enunciado) {
        }

        private String mostrar() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
