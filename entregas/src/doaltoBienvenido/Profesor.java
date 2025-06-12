package doaltoBienvenido;

public class Profesor {
    String nombre;
    Asignatura asignatura;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public void crearExamen(Asignatura asignaturaObjetivo, String titulo) {
        if (asignatura != null && asignatura == asignaturaObjetivo) {
            asignaturaObjetivo.examenTitulo = titulo;
            asignaturaObjetivo.preguntas = new String[3];
            asignaturaObjetivo.preguntas[0] = "Vista Publica Clases";
            asignaturaObjetivo.preguntas[1] = "Vista Privada Objetos";
            asignaturaObjetivo.preguntas[2] = "Vista Privada Clases";
        }
    }

    public void entregarExamen(Profesor vigilante, Asignatura asignaturaExamen) {
        if (vigilante.asignatura == null) {
        }
    }
}
