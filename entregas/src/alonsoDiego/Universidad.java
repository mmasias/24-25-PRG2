public class Universidad {
    private String nombre;
    private Asignatura asignatura;
    private Profesor profesor;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura creaAsignatura(String nombre, String codigo, String creditos) {
        asignatura = new Asignatura(nombre, codigo, creditos);
        return asignatura;
    }

    public Profesor contrataProfesor(String nombre, String dni) {
        profesor = new Profesor(nombre, dni);
        return profesor;
    }

    public String mostrar() {
        return "Universidad: " + nombre;
    }
}
