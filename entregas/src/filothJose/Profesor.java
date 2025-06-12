package filothJose;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private boolean esVigilante = false;
    private Examen examenVigilado;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        if (esVigilante) {
            System.out.println("Este profesor ya está asignado como vigilante y no puede impartir asignaturas.");
        } else {
            this.asignatura = asignatura;
        }
    }

    public boolean puedeVigilar() {
        return asignatura == null && !esVigilante;
    }

    public void vigilarExamen(Examen examen) {
        if (puedeVigilar()) {
            this.examenVigilado = examen;
            this.esVigilante = true;
        } else {
            System.out.println("Este profesor no puede vigilar exámenes.");
        }
    }

    public Examen crearExamen(String tipo) {
        if (asignatura != null && !esVigilante) {
            return new Examen(tipo, asignatura);
        } else {
            System.out.println("Este profesor no puede crear un examen.");
            return null;
        }
    }

    public void entregarExamen(Examen examen, Profesor vigilante) {
        if (this.asignatura == null) {
            System.out.println("Este profesor no puede entregar un examen porque no tiene asignatura asignada.");
            return;
        }

        if (!vigilante.puedeVigilar()) {
            System.out.println("El profesor " + vigilante.getNombre() + " no puede vigilar el examen.");
            return;
        }

        examen.profesorVigilante = vigilante;
        vigilante.vigilarExamen(examen);
        System.out.println("Examen entregado correctamente a " + vigilante.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public boolean isVigilante() {
        return esVigilante;
    }

    public Examen getExamenVigilado() {
        return examenVigilado;
    }
}
