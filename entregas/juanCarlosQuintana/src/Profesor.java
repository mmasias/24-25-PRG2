public class Profesor {
    private String nombre;
    private Asignatura asignatura;

    private Profesor(String nombre) {
        this.nombre = nombre;
    }

    public static Profesor contratarProfesor(String nombre, Asignatura asignatura) {
        Profesor profesor = new Profesor(nombre);
        System.out.println("Contratando al profesor: " + nombre);
        if (asignatura != null) {
            profesor.asignatura = asignatura;
            System.out.println(nombre + " ha sido asignado a la asignatura: " + asignatura.getNombre());
        }
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneAsignatura() {
        return asignatura != null;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Asignatura.Examen crearExamen() {
        if (tieneAsignatura()) {
            System.out.println(nombre + " está creando el examen de " + asignatura.getNombre());
            return asignatura.crearExamen();
        } else {
            System.out.println(nombre + " no puede crear examen porque no tiene asignatura asignada.");
            return null;
        }
    }

    public void vigilarExamen(Asignatura.Examen examen) {
        if (tieneAsignatura()) {
            System.out.println("Error: " + nombre + " no puede vigilar porque tiene una asignatura asignada.");
        } else {
            System.out.println(nombre + " está vigilando el examen.");
        }
    }
}
