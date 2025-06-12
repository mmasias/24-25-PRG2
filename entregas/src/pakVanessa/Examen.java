package pakVanessa;
public class Examen {
    private String[] preguntas = new String[3];
    private int contador = 0;

    public void agregarPregunta(String pregunta) {
        if (contador < 3) {
            preguntas[contador] = pregunta;
            System.out.println("Pregunta agregada: " + pregunta);
            contador++;
        } else {
            System.out.println("El examen ya contiene 3 preguntas.");
        }
    }
}
