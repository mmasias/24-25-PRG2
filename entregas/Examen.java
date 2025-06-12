public class Examen {
    private String[] preguntas = new String[3];
    private int index = 0;


    public void agregarPregunta(String pregunta) {
        if (index < preguntas.length) {
            preguntas[index++] = pregunta;
        }
    }


    public void mostrarPreguntas() {
        System.out.println("Preguntas del examen:");
        for (int i = 0; i < index; i++) {
            System.out.println((i + 1) + ". " + preguntas[i]);
        }
    }
}

