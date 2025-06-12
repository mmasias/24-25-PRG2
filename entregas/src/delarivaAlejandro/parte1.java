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

public class Profesor {
    public Profesor(String nombre);
    public void impartirAsignatura(Asignatura asignatura);
    public Examen crearExamen();
    public void vigilarExamen(Examen examen);
    public void entregarExamenA(Examen examen, Profesor vigilante);
    public String getNombre();
    public Asignatura getAsignatura();
    public List<Examen> getExamenesVigilados();
}

public class Examen {
    public Examen(Asignatura asignatura, List<String> preguntas);
    public void asignarVigilante(Profesor vigilante);
    public List<String> getPreguntas();
    public Asignatura getAsignatura();
    public Profesor getVigilante();
}
