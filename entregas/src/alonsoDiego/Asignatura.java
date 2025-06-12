public class Asignatura {
    private String nombre;
    private String codigo;
    private String creditos;

    public Asignatura(String nombre, String codigo, String creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrar() {
        return "Asignatura: " + nombre + " - " + codigo + " - " + creditos;
    }
}

