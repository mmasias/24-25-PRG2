public class Asignatura {
    private String nombre;
    private String codigo;
    private int creditos;

    public Asignatura(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public String mostrar() {
        return "Asignatura: " + this.nombre + " " + this.codigo + " " + this.creditos + " CREDITOS \n";
    }
    
}
