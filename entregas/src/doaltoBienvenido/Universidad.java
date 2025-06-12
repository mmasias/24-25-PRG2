package doaltoBienvenido;

public class Universidad {
    Asignatura asignatura;
    Profesor profesorAsignado;
    Profesor profesorVigilante;
    Mensaje mensaje;
    String nombreUniversidad;

    public Universidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
        this.asignatura = new Asignatura();
        this.mensaje = new Mensaje();
    }

    public void iniciarExamenes() {
        crearAsignatura("Programacion 2");

        profesorAsignado = contratarProfesor("Manuel Masias");
        asignarAsignatura(profesorAsignado, asignatura.nombre);

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

    public void asignarAsignatura(Profesor profesor, String nombreAsignatura) {
        if (asignatura.nombre.equals(nombreAsignatura)) {
            profesor.asignatura = asignatura;
        }
    }

    private void mostrarEscenario() {
        mensaje.mensajeLn("Universidad: " + nombreUniversidad);
        mensaje.mensajeLn("Profesor: " + profesorAsignado.nombre);
        mensaje.mensajeLn("Asignatura: " + asignatura.nombre);
        mensaje.mensajeLn("Examen: " + asignatura.examenTitulo);
        mensaje.mensajeLn("Vigilado por: " + profesorVigilante.nombre);
        mensaje.mensajeLn("Preguntas:");
        for (String pregunta : asignatura.preguntas) {
            mensaje.mensajeLn("- " + pregunta);
        }
    }
}
