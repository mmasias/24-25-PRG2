package gonzalezMarcos.src;

public class Examen {
    private Asignatura asignatura;
    private String[] preguntas;
    private int numPreguntas; 
    private Profesor vigilante;

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new String[10]; 
        this.numPreguntas = 0;
    }

    public void agregarPregunta(String pregunta) {
        if (numPreguntas < preguntas.length) {
            preguntas[numPreguntas] = pregunta;
            numPreguntas++;
        } else {
            System.out.println("No se pueden agregar más preguntas al examen.");
        }
    }

    public void asignarVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
        System.out.println(vigilante.getNombre() + " ha sido asignado como vigilante.");
    }

    public String[] getPreguntas() {
        String[] preguntasValidas = new String[numPreguntas];
        for (int i = 0; i < numPreguntas; i++) {
            preguntasValidas[i] = preguntas[i];
        }
        return preguntasValidas;
    }

    public Profesor getVigilante() {
        return vigilante;
    }

    public String getTitulo() {
        return "Examen de " + asignatura.getNombre() + " (" + asignatura.getCodigo() + ") - Créditos: " + asignatura.getCreditos();
    }
}


