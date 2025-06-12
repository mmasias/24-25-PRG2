package martinezDiego.Final;

public class Asignatura {

    private String nombre;
    private int creditos;
    private String nombreCorto;

    public void asignarProfesor() {

    }

    public Asignatura(String nombre, int creditos, String nombreCorto) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.nombreCorto = nombreCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

}
