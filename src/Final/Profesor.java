package Final;

class Profesor {
    String nombre;
    int dni = 2123213;
    Asignatura asignatura;
    Examen examen;

    public Profesor(String nombre, Asignatura asignatura) {
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.examen = new Examen(asignatura);
    }
}