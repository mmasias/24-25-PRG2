package rivasMiguel;

public class Asignatura {
    private String nombre;
    private String nombreCorto;
    private int creditos;
    private Profesor profesor;

    public Asignatura(String nombre, String nombreCorto, int creditos) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.creditos = creditos;
    }

    public String getNombre() { return nombre; }
    public String getNombreCorto() { return nombreCorto; }
    public int getCreditos() { return creditos; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor p) { this.profesor = p; }
    public void removeProfesor() { this.profesor = null; }

    @Override
    public String toString() {
        return nombre + " (" + nombreCorto + "), " + creditos + "cr" +
               (profesor != null ? ", impartida por " + profesor.getNombre() : ", sin profesor");
    }
}