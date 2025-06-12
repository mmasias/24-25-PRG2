
public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Examen crearExamen() {
        if (asignatura == null) {
            System.out.println("El profesor no tiene asignatura asignada.");
            return null;
        }
        Examen examen = new Examen(asignatura);
        examen.montarPreguntas();
        return examen;
    }

    public String getDni() {
        return dni;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public String getNombre() {
        return nombre;
    }
    
}

