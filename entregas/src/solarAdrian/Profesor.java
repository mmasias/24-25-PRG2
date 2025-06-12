package solarAdrian;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura; 
    private Examen examenCreado;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Asignatura getAsignatura() { return asignatura; }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void crearExamen() {
        if (asignatura != null) {
            examenCreado = new Examen(asignatura, this, 3);
        }
    }

    public Examen getExamenCreado() {
        return examenCreado;
    }

    public boolean puedeVigilar() {
        return asignatura == null;
    }

    public void entregarExamen(Profesor vigilante) {
        if (examenCreado != null && vigilante.puedeVigilar()) {
            examenCreado.asignarVigilante(vigilante);
        }
    }
}

