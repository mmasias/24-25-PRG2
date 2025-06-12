package caicedoFernando;

public class Examen extends Profesor {
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;

    public Examen(String pregunta1, String pregunta2, String pregunta3, Profesor profesor) {
        super(profesor.getNombre(), profesor.getDni());
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
    }

    public void imprimirPreguntas() {
        System.out.println("Pregunta1: \"" + pregunta1 + "\"");
        System.out.println("Pregunta2: \"" + pregunta2 + "\"");
        System.out.println("Pregunta3: \"" + pregunta3 + "\"");
    }
}