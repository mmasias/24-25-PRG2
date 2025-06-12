public class ProfesorExaminador extends Profesor {
    private Asignatura asignatura;

    public ProfesorExaminador(String nombre) {
        super(nombre);
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
}