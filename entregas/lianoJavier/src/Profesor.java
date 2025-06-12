
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
        if (tieneExamen() && !profesor.imparte()) profesor.recibir(examen);
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
        final String[] PREGUNTAS = {
                "Vista pública clases",
                "Vista pública de objetos",
                "Vista privada de clases"
        };
        examen = new Examen(PREGUNTAS);
    }

    public void asignar(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void mostrarNombre() {
        mensaje(nombre);
    }

    private void mensaje(String string) {
        System.out.print(string);
    }

    public Examen getExamen() {
        return examen;
    }

}
