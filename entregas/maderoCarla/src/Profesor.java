public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private Examen examenVigilado;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarPuesto(Asignatura asignatura) {
        if (examenVigilado == null) {
            this.asignatura = asignatura;
        } else {
            System.out.println(nombre + " no puede impartir asignaturas y vigilar exámenes a la vez.");
        }
    }

    public boolean puedeVigilar() {
        return asignatura == null;
    }

    public Examen crearExamen(String titulo) {
        if (asignatura != null) {
            Examen examen = new Examen(titulo, asignatura);
            examen.setPreguntas("Vista publica clases", "Vista publica objetos", "Vista privada clases");
            asignatura.setExamen(examen);
            return examen;
        } else {
            System.out.println(nombre + " no imparte ninguna asignatura y no puede crear examen.");
            return null;
        }
    }

    public void vigilarExamen(Examen examen) {
        if (puedeVigilar()) {
            this.examenVigilado = examen;
            examen.setVigilante(this);
        } else {
            System.out.println(nombre + " no puede vigilar exámenes porque imparte una asignatura.");
        }
    }

    public String getNombreCompleto() {
        return nombre + " / DNI " + dni;
    }
}
