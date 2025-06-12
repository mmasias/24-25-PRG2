public class Universidad {
    private String nombre_universidad;
    private Asignaturas datos_asignatura;
    private Profesores profesor_examen;
    private Profesores profesor_vigilante;
    private Examen datos_examen;

    public Universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    public void configurarEscenarioExamen() {
        this.datos_asignatura = Asignaturas.crearAsignaturaDeProgramacion();
        this.profesor_examen = Profesores.crearProfesorParaExamen();
        this.profesor_vigilante = Profesores.crearProfesorVigilante();
    }

    public void generarExamen() {
        if (this.profesor_examen != null) {
            this.datos_examen = this.profesor_examen.crearExamen();
        }
    }

    public void mostrarEscenarioCompleto() {
        System.out.println("\n========================================");
        System.out.println("--- RESULTADO FINAL ---");
        System.out.println("Universidad: " + this.nombre_universidad);
        System.out.println("Profesor: " + this.profesor_examen.getNombre_profesor() + " / DNI: " + this.profesor_examen.getDni_profesor());
        System.out.println("Asignatura: " + this.datos_asignatura.getNombre_asignatura() + " - " + this.datos_asignatura.getAbreviacion_asignatura() + "DS - " + this.datos_asignatura.getCreditos_asignatura() + " creditos");

        if (this.datos_examen != null && this.profesor_vigilante != null) {
            System.out.println("Examen: Examen Final");
            System.out.println("        Vigilado por: " + this.profesor_vigilante.getNombre_profesor() + " / DNI: " + this.profesor_vigilante.getDni_profesor());
            System.out.println("        " + this.datos_examen.getPreguntas());
        }
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Europea del Atlantico");
        
        universidad.configurarEscenarioExamen();
        universidad.generarExamen();
        universidad.mostrarEscenarioCompleto();
    }
}