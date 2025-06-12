package rubioRicardo;

public class Profesor {
    private String nombre;
    private String identificacion;
    private String rol;
    private boolean imparteAsignatura = false;

    public Profesor(String nombre, String identificacion, String rol) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.rol = rol;
    }

    public Examen crearExamen(Profesor profesor, Asignatura asignatura, String nombreExamen) {
        if (this.equals(profesor) && asignatura.getProfesor().equals(this)) {
            this.imparteAsignatura = true;
            return new Examen(nombreExamen, this, asignatura);
        }
        return null;
    }

    public void entregarExamen(Profesor vigilante, Examen examen) {
        if (examen != null && examen.getCreador().equals(this)) {
            examen.setVigilado(vigilante);
        }
    }

    public void vigilarExamen(Profesor vigilante, Examen examen) {
        if (!this.imparteAsignatura) {
            examen.setVigilado(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getRol() {
        return rol;
    }
}

