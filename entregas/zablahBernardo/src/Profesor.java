public abstract class Profesor {
    protected String nombre;
    protected String dni;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String entregarDatosProfesor() {
        return "Profesor: " + nombre + " | DNI: " + dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
