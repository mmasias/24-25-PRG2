public class Asignaturas {
    private int idAsignatura;
    private String nombreAsignatura;
    private String abreviatura;
    private int creditos;
    private Profesores profesorAsignado;

    public Asignaturas(int idAsignatura, String nombreAsignatura, String abreviatura, int creditos, Profesores profesorAsignado) {
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.abreviatura = abreviatura;
        this.creditos = creditos;
        this.profesorAsignado = profesorAsignado;
    }

    public void verAsignaturas() {
        System.out.println(this);
    }

    public void asignarProfesor(int idAsignatura, int idProfesor, Profesores[] profesores) {
        if (this.idAsignatura != idAsignatura) {
            System.out.println("La asignatura no coincide con el ID proporcionado.");
            return;
        }

        for (int i = 0; i < profesores.length; i++) {
            if (profesores[i] != null && profesores[i].getIdProfesor() == idProfesor) {
                this.profesorAsignado = profesores[i];
                System.out.println("Profesor asignado exitosamente.");
                return;
            }
        }

        System.out.println("Profesor no encontrado.");
    }

    @Override
    public String toString() {
        return "Asignaturas{" +
                "idAsignatura=" + idAsignatura +
                ", nombreAsignatura='" + nombreAsignatura + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                ", creditos=" + creditos +
                ", profesorAsignado=" + (profesorAsignado != null ? profesorAsignado.getNombreProfesor() : "Ninguno") +
                '}';
    }
}