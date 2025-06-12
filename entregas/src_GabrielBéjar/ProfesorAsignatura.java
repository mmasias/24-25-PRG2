package entregas.src_GabrielBéjar;

public class ProfesorAsignatura extends Profesor {
    private Asignatura asignatura;
    private Examen examen;

    public ProfesorAsignatura(String nombreCompleto, String dni) {
        super(nombreCompleto, dni);
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public boolean puedeCrearExamen() {
        return asignatura != null;
    }

    public Examen getExamen() {
        if (!puedeCrearExamen()) {
            return null;
        }
        if (examen == null) {
            examen = crearExamen();
        }
        return examen;
    }

    private Examen crearExamen() {
        Examen nuevoExamen = new Examen("Examen Final");
        formularPreguntas(nuevoExamen);
        return nuevoExamen;
    }

    private void formularPreguntas(Examen examen) {
        examen.setPregunta(1, "¿Qué es la programación orientada a objetos?");
        examen.setPregunta(2, "Explique los pilares de la POO.");
        examen.setPregunta(3, "Diferencie entre clase y objeto.");
    }
}
