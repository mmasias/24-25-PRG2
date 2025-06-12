public class Asignatura {
    private String nombre;
    private int creditos;
    private Examen examen;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public Examen getExamen() {
        return examen;
    }
}
