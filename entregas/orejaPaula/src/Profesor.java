
public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private Examen examen;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public static void crearExamen() {
        Profesor profesor = Universidad.getProfesor();
        if (profesor.asignatura != null) {
            profesor.examen = new Examen("Examen Final");
            profesor.examen.agregarPregunta("Vista pública de clases");
            profesor.examen.agregarPregunta("Vista pública de objetos");
            profesor.examen.agregarPregunta("Vista privada de clases");
        } else {
            System.out.println("El profesor no tiene asignatura. No puede crear examen.");
        }
    }

    public static void entregarExamen(Profesor otroProfesor) {
        Profesor profesor = Universidad.getProfesor();
        if (profesor.examen != null && otroProfesor.asignatura == null) {
            System.out.println("El profesor " + profesor.nombre + " entrega el examen al profesor " + otroProfesor.nombre);
        } else {
            System.out.println("No se puede entregar el examen.");
        }
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void mostrar() {
        System.out.println("Profesor: " + nombre + " / DNI: " + dni);
        if (asignatura != null) {
            System.out.println("Imparte: " + asignatura.getNombre());
        } else {
            System.out.println("No imparte asignatura.");
        }
    }
}
