package solarAdrian;

public class Examen {
    private Asignatura asignatura;
    private Profesor creador;
    private Profesor vigilante;
    private int cantidadPreguntas;

    public Examen(Asignatura asignatura, Profesor creador, int cantidadPreguntas) {
        this.asignatura = asignatura;
        this.creador = creador;
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public void asignarVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public Asignatura getAsignatura() { return asignatura; }
    public Profesor getCreador() { return creador; }
    public Profesor getVigilante() { return vigilante; }
    public int getCantidadPreguntas() { return cantidadPreguntas; }
}
