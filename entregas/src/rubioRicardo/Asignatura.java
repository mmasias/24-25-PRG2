package rubioRicardo;

public class Asignatura {
    private String nombre;
    private String abreviatura;
    private int creditos;
    private Profesor profesor;

    public Asignatura(String nombre, String abreviatura, int creditos) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.creditos = creditos;
    }

    public void asignarAsignatura(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}
