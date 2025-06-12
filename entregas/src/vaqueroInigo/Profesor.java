package vaqueroInigo;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignacionAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Examen creacionExamen(String nombre) {
        return new Examen(nombre);
    }

    public void creacionPreguntas(Examen examen, String p1, String p2, String p3) {
        examen.agregarPreguntas(p1, p2, p3);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
