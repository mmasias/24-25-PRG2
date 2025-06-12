public class Profesores {
    private int idProfesor;
    private String nombreProfesor;
    private String dni;
    private String tipoProfesor;

    public Profesores(int idProfesor, String nombreProfesor, String dni, String tipoProfesor) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.dni = dni;
        this.tipoProfesor = tipoProfesor;
    }

    public Examenes crearExamen(int idAsignatura, Asignaturas[] asignaturas, Universidad universidad) {
        Asignaturas asignatura = null;
        for (int i = 0; i < asignaturas.length; i++) {
            if (asignaturas[i] != null && asignaturas[i].getIdAsignatura() == idAsignatura) {
                asignatura = asignaturas[i];
                break;
            }
        }

        if (asignatura == null) {
            System.out.println("Asignatura no encontrada.");
            return null;
        }

        if (asignatura.getProfesorAsignado() != this) {
            System.out.println("El profesor no está asignado a esta asignatura.");
            return null;
        }

        int idExamen = universidad.getExamenes().length + 1;
        String[] preguntasExamen = {"Pregunta 1", "Pregunta 2", "Pregunta 3"}; // Ejemplo de preguntas
        Examenes examen = new Examenes(idExamen, "Examen de " + asignatura.getNombreAsignatura(), preguntasExamen, idAsignatura);
        universidad.getExamenes()[universidad.getExamenCount()] = examen;
        universidad.setExamenCount(universidad.getExamenCount() + 1);
        System.out.println("Examen creado exitosamente.");
        return examen;
    }


    @Override
    public String toString() {
        return "Profesores{" +
                "idProfesor=" + idProfesor +
                ", nombreProfesor='" + nombreProfesor + '\'' +
                ", dni='" + dni + '\'' +
                ", tipoProfesor='" + tipoProfesor + '\'' +
                '}';
    }
}