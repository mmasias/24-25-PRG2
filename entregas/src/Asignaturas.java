public class Asignaturas {
    private String nombreAsignatura;
    private String abreviatura;
    private int creditos;
    private Profesores profesorAsignado;

     public Asignaturas(String nombreAsignatura, String abreviatura, int creditos, Profesores profesorAsignado) {
        this.nombreAsignatura = nombreAsignatura;
        this.abreviatura = abreviatura;
        this.creditos = creditos;
        this.profesorAsignado = profesorAsignado;
    }
}