public class Universidad {
    public Universidad(String nombre);
    public Asignatura crearAsignatura(String nombre);
    public Profesor contratarProfesor(String nombre);
    public List<Profesor> getProfesores();
    public List<Asignatura> getAsignaturas();
    public String getNombre();
}

public class Asignatura {
    public Asignatura(String nombre);
    public void asignarProfesor(Profesor profesor);
    public void asignarExamen(Examen examen);
    public String getNombre();
    public Profesor getProfesor();
    public Examen getExamen();
}
