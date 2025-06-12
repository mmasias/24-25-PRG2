
public class Profesor {

    private String nombre;
    private String dni;

    private Examen examen;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void darExamen(Profesor profesor) {
        assert !tieneExamen() : "El profesor no tiene un examen para dar.";
        assert profesor.imparte() : "El profesor imparte una asignatura, no puede recibir un examen.";

        profesor.recibir(examen);
    }

    private void recibir(Examen examen) {
        this.examen = examen;
    }

    private boolean imparte() {
        return asignatura != null ? true : false;
    }

    private boolean tieneExamen() {
        return examen != null ? true : false;
    }

    public void crearExamen() {
        assert imparte() : "El profesor no imparte ninguna asignatura, no puede crear un examen.";

        final String[] PREGUNTAS = {
                "Vista pública clases",
                "Vista pública de objetos",
                "Vista privada de clases"
        };

        examen = new Examen("Examen Final", PREGUNTAS, asignatura);
    }

    public void asignar(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void mostrarNombre() {
        Utilidades.mensaje(nombre);
    }

    public Examen getExamen() {
        return examen;
    }

    public void mostrarDNI() {
        Utilidades.mensaje(dni);
    }

}
