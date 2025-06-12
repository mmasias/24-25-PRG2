public class Asignatura {
    private String nombre;
    private int creditos;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int nuevosCreditos) {
        creditos = nuevosCreditos;
    }

    @Override
    public String toString() {
        return nombre + " - " + creditos + " créditos";
    }
}
