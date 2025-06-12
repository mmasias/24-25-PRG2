public class Asignaturas {
    private String nombre_asignatura;
    private String abreviacion_asignatura;
    private String creditos_asignatura;

    private Asignaturas(String nombre_asignatura, String abreviacion_asignatura, String creditos_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
        this.abreviacion_asignatura = abreviacion_asignatura;
        this.creditos_asignatura = creditos_asignatura;
    }

    public static Asignaturas crearAsignaturaDeProgramacion() {
        return new Asignaturas("Programacion II", "PRG2", "6");
    }

    public String getNombre_asignatura() {
        return this.nombre_asignatura;
    }

    public String getAbreviacion_asignatura() {
        return this.abreviacion_asignatura;
    }

    public String getCreditos_asignatura() {
        return this.creditos_asignatura;
    }
}