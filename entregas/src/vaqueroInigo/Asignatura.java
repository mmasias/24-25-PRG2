package vaqueroInigo;

public class Asignatura {
    private String nombre;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public void asignacionProfesor(Profesor profesor) {
        // Relación ya gestionada externamente
    }

    public String getNombre() {
        return nombre;
    }
}

