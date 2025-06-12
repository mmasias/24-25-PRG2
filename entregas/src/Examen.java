package entregas.src;

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

}