package solarAdrian;

public class Supervisor {
    private String nombre;
    private String dni;

    public Supervisor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}
