public class Asignatura {
    private String nombre;
    private int creditos;
    private Examenes examen;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void setExamen(Examenes examen) {
        this.examen = examen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public Examenes getExamen() {
        return examen;
    }
}
