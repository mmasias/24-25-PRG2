public class Alumno {
    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String nuevoDni) {
        dni = nuevoDni;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " / DNI: " + dni;
    }
}
