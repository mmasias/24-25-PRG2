public class Asignatura {

    private final String nombre;
    private final String codigo;
    private final int creditos;

    public Asignatura(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public String descripcion() {
        return this.nombre + " - " + this.codigo + " - " + this.creditos + " créditos";
    }
}