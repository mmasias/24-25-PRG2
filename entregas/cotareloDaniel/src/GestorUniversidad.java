public class GestorUniversidad {
    private Profesor profesor;
    private ProfesorVigilante profesorVigilante;
    private Asignatura asignatura;
    private Examen examen;

    public void crearProfesor(String nombre, String dni) {
        profesor = new Profesor(nombre, dni);
    }

    public void crearProfesorVigilante(String nombre, String dni) {
        profesorVigilante = new ProfesorVigilante(nombre, dni);
    }

    public void crearAsignatura(String nombre, int creditos) {
        asignatura = new Asignatura(nombre, creditos);
    }

    public void asignarAsignaturaAProfesor() {
        profesor.asignarAsignatura(asignatura);
    }

    public void crearPreguntasExamen() {
        PreguntasExamen preguntasExamen;
        preguntasExamen = new PreguntasExamen();
        preguntasExamen.crearPreguntas();
    }

    public void crearExamen() {
        examen = profesor.crearExamen();
    }

    public void entregarExamenAProfesorVigilante() {
        if (examen != null && profesorVigilante != null) {
            System.out.println("El profesor " + profesor.getNombre() + " entrega el examen a " + profesorVigilante.getNombre() + ".");
            System.out.println();
        }
    }

    public void mostrarEscenario() {
        System.out.println("Profesor que imparte la asignatura:");
        System.out.println(profesor.toString());
        System.out.println();
        System.out.println("Asignatura asignada:");
        System.out.println(asignatura.toString());
        System.out.println();
        System.out.println("Examen creado:");
        System.out.println(examen.toString());
        System.out.println();
        System.out.println("Profesor que vigila el examen:");
        System.out.println(profesorVigilante.toString());
    }

    @Override
    public String toString() {
        return "Gestor con profesor, vigilante, asignatura y examen disponibles";
    }
}
