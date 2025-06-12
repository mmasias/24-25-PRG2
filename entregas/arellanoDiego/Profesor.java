public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private Examen examen;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignatura = null;
        this.examen = null;
    }

    public void impartir(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Examen crearExamen(String titulo) {
        if (this.asignatura != null) {
            this.examen = new Examen(titulo, this.asignatura);
            return this.examen;
        }
        return null;
    }

    public void entregarExamen(Profesor vigilante, Examen examen) {
        if (vigilante.asignatura == null) {
            examen.asignarVigilante(vigilante);
        }
    }

    public String mostrar() {
        String texto = "\tProfesor: " + this.nombre + " / dni " + this.dni + "\n";
        if (this.asignatura != null) {
            texto += "\t\t" + this.asignatura.mostrar();
            if (this.examen != null) {
                texto += this.examen.mostrar();
            }
        }
        return texto;
    }
}
