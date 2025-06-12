package entregas.orozcoBeatriz;

public class Profesor {
    protected String nombre;
    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public Examen crearExamen(String nombreAsignatura) {
        return new Examen(nombreAsignatura);
    }
}
