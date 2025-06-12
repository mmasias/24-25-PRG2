public class Asignaturas {
    private String nombre;
    private String abreviacion;
    private int creditos;

    private Asignaturas(String nombre, String abreviacion, int creditos) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.creditos = creditos;
    }

    public static Asignaturas crearAsignaturaDeProgramacion() {
        return new Asignaturas("Programacion II", "PRG2", 6);
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviacion() {
        return this.abreviacion;
    }

    public int getCreditos() {
        return creditos;
    }
}