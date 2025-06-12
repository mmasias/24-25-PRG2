public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura asignaturaAsignada) {
        asignatura = asignaturaAsignada;
    }

    public Examen crearExamen() {
        if (asignatura == null) {
            return null;
        }

        PreguntasExamen preguntas = new PreguntasExamen();
        preguntas.crearPreguntas();

        return new Examen("Examen Parcial", preguntas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String nuevoDni) {
        dni = nuevoDni;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura nuevaAsignatura) {
        asignatura = nuevaAsignatura;
    }

    @Override
    public String toString() {
        return "Profesor: " + nombre + " / DNI: " + dni;
    }
}
