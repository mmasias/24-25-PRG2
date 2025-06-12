public class Universidad {
    private String nombre;
    private Asignaturas asignatura;
    private Profesores profesorExamen;
    private Profesores profesorVigilante;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void configurarEscenarioExamen() {
        this.asignatura = Asignaturas.crearAsignaturaDeProgramacion();
        this.profesorExamen = Profesores.crearProfesorParaExamen();
        this.profesorVigilante = Profesores.crearProfesorVigilante();
    }

    public void generarExamen() {
        if (this.profesorExamen != null) {
            this.examen = this.profesorExamen.crearExamen();
        }
    }

    public void mostrarEscenarioCompleto() {
        System.out.println("\n========================================");
        System.out.println("--- RESULTADO FINAL ---");
        System.out.println("Universidad: " + this.nombre);
        System.out.println("Profesor: " + this.profesorExamen.getNombre() + " / DNI: " + this.profesorExamen.getDni());
        System.out.println("Asignatura: " + this.asignatura.getNombre() + " - " + this.asignatura.getAbreviacion() + " - " + this.asignatura.getCreditos() + " creditos");

        if (this.examen != null && this.profesorVigilante != null) {
            System.out.println("Examen: Examen Final");
            System.out.println("        Vigilado por: " + this.profesorVigilante.getNombre() + " / DNI: " + this.profesorVigilante.getDni());
            System.out.println("        " + this.examen.getPreguntas());
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