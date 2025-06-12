public class PreguntasExamen {
    private String[] preguntas;

    public PreguntasExamen() {
        preguntas = new String[3];
    }

    public void crearPreguntas() {
        preguntas[0] = "1. ¿Qué es una clase pública en Java?";
        preguntas[1] = "2. ¿Cómo se implementa la herencia en programación orientada a objetos?";
        preguntas[2] = "3. ¿Qué diferencia hay entre métodos privados y protegidos?";
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String[] nuevasPreguntas) {
        preguntas = nuevasPreguntas;
    }

    @Override
    public String toString() {
        return preguntas[0] + "\n" + preguntas[1] + "\n" + preguntas[2];
    }
}
