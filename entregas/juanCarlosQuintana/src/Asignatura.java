import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private Examen examen;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Examen crearExamen() {
        this.examen = new Examen();
        examen.agregarPregunta("¿Qué es la herencia en Java?");
        examen.agregarPregunta("¿Qué diferencia hay entre clase abstracta e interfaz?");
        examen.agregarPregunta("¿Qué es el encapsulamiento y por qué es útil?");
        return examen;
    }

    public void calificarExamen() {
        System.out.println("El examen de " + nombre + " ha sido calificado.");
    }

    public Examen getExamen() {
        return examen;
    }

    public static class Pregunta {
        private String enunciado;

        public Pregunta(String enunciado) {
            this.enunciado = enunciado;
        }

        public String getEnunciado() {
            return enunciado;
        }
    }

    public static class Examen {
        private ArrayList<Pregunta> preguntas;

        public Examen() {
            preguntas = new ArrayList<>();
        }

        public void agregarPregunta(String enunciado) {
            if (preguntas.size() < 3) {
                preguntas.add(new Pregunta(enunciado));
            }
        }

        public void mostrarExamen() {
            System.out.println("Contenido del examen:");
            for (int i = 0; i < preguntas.size(); i++) {
                System.out.println("Pregunta " + (i + 1) + ": " + preguntas.get(i).getEnunciado());
            }
        }
    }
}
