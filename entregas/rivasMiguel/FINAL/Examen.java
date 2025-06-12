package rivasMiguel;

public class Examen {
    private String nombre;
    private Asignatura asignatura;
    private String[] preguntas;
    private Profesor creador;

    public Examen(String nombre, Asignatura asignatura, String[] preguntas, Profesor creador) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.preguntas = preguntas;
        this.creador = creador;
    }

    public String getNombre() { return nombre; }
    public Asignatura getAsignatura() { return asignatura; }
    public Profesor getProfesor() { return creador; }

    @Override
    public String toString() {
        return "Examen '" + nombre + "' de " + asignatura.getNombreCorto();
    }
}