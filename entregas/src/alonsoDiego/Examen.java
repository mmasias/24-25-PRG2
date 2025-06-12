public class Examen {
    private Asignatura asignatura;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private int contadorPreguntas = 0;

    public Examen(Asignatura a) {
        this.asignatura = a;
    }

    public void agregarPreguntas(String pregunta) {
        contadorPreguntas++;
        if (contadorPreguntas == 1) {
            pregunta1 = pregunta;
        } else if (contadorPreguntas == 2) {
            pregunta2 = pregunta;
        } else if (contadorPreguntas == 3) {
            pregunta3 = pregunta;
        } else {
            System.out.println("No se pueden agregar más preguntas.");
        }
    }

    public String toString() {
        String s = "Examen: Examen Final\n";
        s += "Asignatura: " + asignatura.getNombre() + "\n";
        s += "Pregunta 1: " + pregunta1 + "\n";
        s += "Pregunta 2: " + pregunta2 + "\n";
        s += "Pregunta 3: " + pregunta3 + "\n";
        return s;
    }
}

