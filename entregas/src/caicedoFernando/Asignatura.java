package caicedoFernando;

public class Asignatura {
    private String nombre;
    private Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}