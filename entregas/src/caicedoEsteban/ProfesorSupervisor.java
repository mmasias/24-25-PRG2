public class ProfesorSupervisor {

    private String nombreProfesor;
    private boolean impartiendo = false;
    private Examen examenRecibido;

    public ProfesorSupervisor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public void recibirExamen(Examen examen) {
        this.examenRecibido = examen;
    }

    public boolean estaImpartiendo() {
        return impartiendo;
    }

    public Examen getExamen() {
        return examenRecibido;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }
}
