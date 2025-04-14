public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
    }

    public Persona(String nombre, String apellidos, int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad debe ser positiva");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
}