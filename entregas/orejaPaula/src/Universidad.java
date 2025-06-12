public class Universidad {
    private Asignatura asignatura;
    private Profesor profesor;
    private Profesor otroProfesor;

    private static Universidad instancia = new Universidad();

    private Universidad() {}

    public static void crearAsignatura() {
        instancia.asignatura = new Asignatura("Programación 2", 6);
    }

    public static void contratarProfesor() {
        instancia.profesor = new Profesor("Dr. Jesús Fernández", "244455555X");
    }

    public static void contratarOtroProfesor() {
        instancia.otroProfesor = new Profesor("Daisy Piedad", "666456665X");
    }

    public static void asignarAsignatura() {
        instancia.profesor.asignarAsignatura(instancia.asignatura);
    }

    public static void crearExamen() {
        instancia.profesor.crearExamen();
    }

    public static void entregarExamen() {
        instancia.profesor.entregarExamen(instancia.otroProfesor);
    }

    public static void mostrar() {
        System.out.println("📚 Universidad Europea del Atlántico");
        if (instancia.asignatura != null) {
            instancia.asignatura.mostrar();
        }
        instancia.profesor.mostrar();
        instancia.otroProfesor.mostrar();
    }
}
