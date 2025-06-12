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

        contratarProfesor("Manuel Masias");
        asignarAsignatura(profesorAsignado, asignatura.getNombre());

        profesorAsignado.crearExamen(asignatura, "Examen Final");

        contratarVigilante("Jorge Crespo");
        profesorAsignado.entregarExamen(profesorVigilante, asignatura);

        mostrarEscenario();
    }
}
