package martinezDiego.Final;

public class Profesor {

    private String nombre;
    private int dni;
    private String asignatura;

    Examen examen1 = new Examen("final", "Pregunta 1: vista publica || pregunta 2: vista privada");

    

    public void asignarExamen(Examen examen1) {

    }

    public Profesor(String nombre, int dni, String asignatura) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}
