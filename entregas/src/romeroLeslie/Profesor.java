public class Profesor {
    public String nombre;
    public String dni;
    public Universidad asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Universidad asignatura) {
        this.asignatura = asignatura;
    }
}
