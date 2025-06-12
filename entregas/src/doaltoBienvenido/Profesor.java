package doaltoBienvenido;

public class Profesor {
    private String nombre;
    private Asignatura asignatura;
    private boolean tieneAsignatura = false;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void crearExamen(Asignatura asignaturaObjetivo, String titulo) {
        if (asignatura != null && asignatura == asignaturaObjetivo) {
            asignaturaObjetivo.setExamenTitulo(titulo);
            String[] preguntas = new String[3];
            preguntas[0] = "Vista Publica Clases";
            preguntas[1] = "Vista Privada Objetos";
            preguntas[2] = "Vista Privada Clases";
            asignaturaObjetivo.setPreguntas(preguntas);
        }
    }

    public void entregarExamen(Profesor vigilante, Asignatura asignaturaExamen) {
        if (vigilante.tieneAsignatura) {
        }
    }
}
