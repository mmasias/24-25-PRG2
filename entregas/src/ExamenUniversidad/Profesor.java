package 24-25-PRG2.entregas.src.ExamenUniversidad;

public class Profesor {
    String nombre;
    String[] preguntas;

    public Profesor(String nombre) {
        this.nombre = nombre;
        preguntas = new String[3];
        preguntas[0] = "¿Cuánto es 1+1?";
        preguntas[1] = "¿Cuánto es 2+2?";
        preguntas[2] = "¿Cuánto es 3+3?";
    }

    public void creaExamen() {
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + (i + 1) + ": " + preguntas[i]);
        }
    }

    public void entregaExamen(Profesor otroProfesor) {
        System.out.println(nombre + " entrega el examen a " + otroProfesor.nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}