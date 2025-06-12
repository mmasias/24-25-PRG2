
public class ProfesorAsignatura {

    private String nombreProfesor;
    private Asignatura asignatura;
    private Examen examen;

    public ProfesorAsignatura(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public void impartirAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void crearExamen() {
        if (asignatura != null) {
            examen = new Examen("Examen final", asignatura);
            examen.agregarPregunta("Pregunta 1 :");
            examen.agregarPregunta("Pregunta 2 :");
            examen.agregarPregunta("Pregunta 3 :");
        }
    }

    public Examen getExamen() {
        return examen;
    }

    public void enviarExamenA(ProfesorSupervisor profesorSupervisor) {
        if (examen != null) {
            profesorSupervisor.recibirExamen(examen);
        }
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

}
