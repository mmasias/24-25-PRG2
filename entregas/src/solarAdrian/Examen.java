package solarAdrian;

public class Examen {
    private Asignatura asignatura;
    private Profesor creador;
    private Supervisor supervisor;
    

    public Examen(Asignatura asignatura, Profesor creador, int cantidadPreguntas) {
        this.asignatura = asignatura;
        this.creador = creador;
        
    }

    public void asignarSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Asignatura getAsignatura() { return asignatura; }
    public Profesor getCreador() { return creador; }
    public Supervisor getSupervisor() { return supervisor; }
}
