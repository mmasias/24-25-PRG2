package entregas.larinAlejandro;

public class Examen {

    private String asignatura;
    private String[] preguntas;
    public Examen(String asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new String[] {
            "Pregunta 1: ¿Qué es la Programación Orientada a Objetos?",
            "Pregunta 2: ¿Cuáles son los principios SOLID?",
            "Pregunta 3: ¿Qué es un patrón de diseño?"
        };
  
    }

    public void mostrarExamen() {
        System.out.println("Examen de la asignatura: " + asignatura + "6 créditos");
        System.out.println("Preguntas:");
        for (String pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }

}
