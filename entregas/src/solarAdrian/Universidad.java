package solarAdrian;

public class Universidad {
    private String nombre;
    private Asignatura asignatura;
    private Profesor profesorPrincipal;
    private Profesor profesorVigilante;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void crearAsignatura(String nombre, String codigo, int creditos) {
        asignatura = new Asignatura(nombre, codigo, creditos);
    }

    public void contratarProfesorPrincipal(String nombre, String dni) {
        profesorPrincipal = new Profesor(nombre, dni);
    }

    public void contratarProfesorVigilante(String nombre, String dni) {
        profesorVigilante = new Profesor(nombre, dni); // este no tiene asignatura
    }

    public void asignarAsignaturaAlProfesor() {
        profesorPrincipal.asignarAsignatura(asignatura);
    }

    public void profesorCreaExamen() {
        profesorPrincipal.crearExamen();
        examen = profesorPrincipal.getExamenCreado();
    }

    public void asignarVigilante() {
        profesorPrincipal.entregarExamen(profesorVigilante);
    }

    public void mostrarEscenarioCompleto() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor : " + profesorPrincipal.getNombre());
        System.out.println("Asignatura: " + asignatura.getNombre() + " - " + asignatura.getCodigo() + " - " + asignatura.getCreditos() + " créditos");
        System.out.println("Examen: Examen Final");
        System.out.println("Vigilado por: " + examen.getVigilante().getNombre());
        System.out.println("Pregunta 1: \"Vista pública clases\"");
        System.out.println("Pregunta 2: \"Vista pública de objetos\"");
        System.out.println("Pregunta 3: \"Vista privada de clases\"");
        System.out.println();
        System.out.println("Datos de ejemplo");
    }
}
