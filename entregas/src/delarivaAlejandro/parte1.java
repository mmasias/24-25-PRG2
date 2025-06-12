public class Universidad {
    public Universidad(String nombre);
    public Asignatura crearAsignatura(String nombre);
    public Profesor contratarProfesor(String nombre);
    public List<Profesor> getProfesores();
    public List<Asignatura> getAsignaturas();
    public String getNombre();
}
