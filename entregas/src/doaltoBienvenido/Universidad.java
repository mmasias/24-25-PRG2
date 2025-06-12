package doaltoBienvenido;

public class Universidad {
    private Asignatura asignatura;
    private Profesor profesorAsignado;
    private Profesor profesorVigilante;
    private Mensaje mensaje;
    private String nombreUniversidad;

    public Universidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
        this.asignatura = new Asignatura();
        this.mensaje = new Mensaje();
    }

    public void iniciarExamenes() {
        crearAsignatura("Programacion 2");

        profesorAsignado = contratarProfesor("Manuel Masias");
        asignarAsignatura(profesorAsignado, asignatura);

        profesorAsignado.crearExamen(asignatura, "Examen Final");

        profesorVigilante = contratarProfesor("Jorge Crespo");

        profesorAsignado.entregarExamen(profesorVigilante, asignatura);

        mostrarEscenario();
    }

    public Profesor contratarProfesor(String nombreProfesor) {
        return new Profesor(nombreProfesor);
    }

    public void crearAsignatura(String nombreAsignatura) {
        asignatura.crearAsignatura(nombreAsignatura);
    }

    public void asignarAsignatura(Profesor profesor, Asignatura asignatura) {
        profesor.setAsignatura(asignatura);
    }

    private void mostrarEscenario() {
        mensaje.mensajeLn("Universidad: " + nombreUniversidad);
        mensaje.mensajeLn("Profesor: " + profesorAsignado.getNombre());
        mensaje.mensajeLn("Asignatura: " + asignatura.getNombre());
        mensaje.mensajeLn("Examen: " + asignatura.getExamenTitulo());
        mensaje.mensajeLn("Vigilado por: " + profesorVigilante.getNombre());
        mensaje.mensajeLn("Preguntas:");
        for (String pregunta : asignatura.getPreguntas()) {
            mensaje.mensajeLn("- " + pregunta);
        }
    }
}
