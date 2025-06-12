package valdesCarlos;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Examen crearExamen() {
        return new Examen(this);
    }

    public void entregarExamen(Examen examen, ProfesorVigilante vigilante) {
        if (asignatura != null) {
            vigilante.vigilarExamen(examen);
        }
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public String getNombre() {
        return nombre;
    }
}
