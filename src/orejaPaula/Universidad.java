
public class Universidad {
    private Asignatura asignatura;
    private Profesor profesor;
    private Profesor otroProfesor;

    public static Universidad universidad = new Universidad();

    public static void crearAsignatura() {
        universidad.asignatura = new Asignatura("Programacion 2", 6);
    }

    public static void contratarProfesor() {
        universidad.profesor = new Profesor("Dr. Jesus Fernández", "244455555X");
    }

    public static void ContratarOtroProfesor() {
        universidad.otroProfesor = new Profesor("Daisy Piedad", "666456665X");
    }

    public static void mostrar() {
        System.out.println("Universidad Europea del Atlántico");
        universidad.asignatura.mostrar();
        universidad.profesor.mostrar();
        universidad.otroProfesor.mostrar();
    }

    public static Profesor getProfesor() {
        return universidad.profesor;
    }

    public static Profesor getOtroProfesor() {
        return universidad.otroProfesor;
    }

    public static Asignatura getAsignatura() {
        return universidad.asignatura;
    }
}
