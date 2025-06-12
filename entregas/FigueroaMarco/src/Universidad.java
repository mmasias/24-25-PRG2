public class Universidad {
    private String nombreUniversidad;
    private Asignaturas[] asignaturas;
    private Profesores[] profesores;
    private Examenes[] examenes;
    private int nextIdAsignatura;
    private int nextIdProfesor;
    private int asignaturaCount;
    private int profesorCount;
    private int examenCount;

    public Universidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
        this.asignaturas = new Asignaturas[100];
        this.profesores = new Profesores[100]; 
        this.examenes = new Examenes[100];
        this.nextIdAsignatura = 1;
        this.nextIdProfesor = 1;
        this.asignaturaCount = 0;
        this.profesorCount = 0;
        this.examenCount = 0;
    }

    public Asignaturas crearAsignatura(String nombreAsignatura, String abreviatura, int creditos) {
        Asignaturas asignatura = new Asignaturas(nextIdAsignatura++, nombreAsignatura, abreviatura, creditos, null);
        asignaturas[asignaturaCount++] = asignatura;
        return asignatura;
    }

    public Profesores crearProfesor(String nombreProfesor, String dni, String tipoProfesor) {
        Profesores profesor = new Profesores(nextIdProfesor++, nombreProfesor, dni, tipoProfesor);
        profesores[profesorCount++] = profesor;
        return profesor;
    }

    public void verProfesores() {
        for (int i = 0; i < profesorCount; i++) {
            System.out.println(profesores[i]);
        }
    }

    public void profesorVigilarExamen(int idExamen, int idAsignaturaAVigilar) {
        Profesores profesorVigilante = null;
        for (int i = 0; i < profesorCount; i++) {
            if (profesores[i].getTipoProfesor().equalsIgnoreCase("vigilante")) {
                profesorVigilante = profesores[i];
            }
        }

        if (profesorVigilante == null) {
            System.out.println("No hay profesores vigilantes disponibles.");
            return;
        }

        Examenes examen = null;
        for (int i = 0; i < examenCount; i++) {
            if (examenes[i].getIdExamen() == idExamen && examenes[i].getIdAsignatura() == idAsignaturaAVigilar) {
                examen = examenes[i];
                break;
            }
        }

        if (examen == null) {
            System.out.println("Examen no encontrado.");
            return;
        }

        System.out.println("El profesor " + profesorVigilante.getNombreProfesor() + " estará vigilando el examen " + examen.getNombreExamen());
    }

    // Ver Pensum
    public void verPensum() {
        for (int i = 0; i < asignaturaCount; i++) {
            System.out.println(asignaturas[i]);
            for (int j = 0; j < examenCount; j++) {
                if (examenes[j].getIdAsignatura() == asignaturas[i].getIdAsignatura()) {
                    System.out.println("  " + examenes[j]);
                }
            }
        }
    }

}