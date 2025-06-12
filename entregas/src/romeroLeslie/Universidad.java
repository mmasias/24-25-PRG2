public class Universidad {
    public String nombreAsignatura;

    public Universidad(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public static Universidad crearAsignatura(String nombreAsignatura) {
        return new Universidad(nombreAsignatura);
    }

    public static Profesor crearProfesor(String nombre, String dni) {
        return new Profesor(nombre, dni);
    }
}
