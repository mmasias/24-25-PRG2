package entregas.src.fernandezPablo;

public class Examen {
    private String[] preguntas;
    private int contador; 

    public void asignar(String pregunta) {
        if (contador < preguntas.length) {
            preguntas[contador] = pregunta;
            contador++;
        } else {
            System.out.println("No se pueden añadir más preguntas. El examen ya tiene 3.");
        }
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public void mostrarPreguntas() {
        System.out.println("Preguntas del examen:");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + preguntas[i]);
        }
    }

}