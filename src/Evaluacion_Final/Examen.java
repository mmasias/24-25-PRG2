package Evaluacion_Final;

class Examen {
    Asignatura asignatura;
    Preguntas preguntas;

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new Preguntas();
    }
}