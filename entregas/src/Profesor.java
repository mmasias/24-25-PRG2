package entregas.src;

public class Profesor {
    private String nombre;
    private boolean programacion; 
    private String asignatura;

    public Profesor(String nombre, boolean programacion) {
        this.nombre = nombre;
        this.programacion = programacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void asignar(String asignatura) {
        this.asignatura = asignatura;
    }
}
