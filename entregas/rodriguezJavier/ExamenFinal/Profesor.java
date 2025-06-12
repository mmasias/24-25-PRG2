public class Profesor extends Profesores {
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        super(nombre, dni);
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean tieneAsignatura(Asignatura asignatura) {
        return this.asignatura != null && this.asignatura.equals(asignatura);
    }
}