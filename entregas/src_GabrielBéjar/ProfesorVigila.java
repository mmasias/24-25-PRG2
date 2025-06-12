package entregas.src_GabrielBéjar;

public class ProfesorVigila extends Profesor {
    private Examen examenVigilado;
    private int advertenciasEmitidas;
    private int expulsionesEmitidas;

    public ProfesorVigila(String nombreCompleto, String dni) {
        super(nombreCompleto, dni);
    }

    public boolean puedeVigilar() {
        return examenVigilado != null;
    }

    public void recibirExamen(Examen examen) {
        this.examenVigilado = examen;
    }

    public Examen getExamenVigilado() {
        return examenVigilado;
    }

    public String advertirAlumno(Alumno alumno) {
        if (detectarCopia()) {
            advertenciasEmitidas++;
            return "Advertencia para " + alumno.getNombre();
        }
        return "Sin incidentes para " + alumno.getNombre();
    }

    public String expulsarAlumno(Alumno alumno) {
        if (detectarCopia()) {
            expulsionesEmitidas++;
            return "Expulsión para " + alumno.getNombre();
        }
        return "Sin incidentes para " + alumno.getNombre();
    }

    private boolean detectarCopia() {
        return Math.random() < 0.5;
    }

    public String getEstadisticas() {
        return "Advertencias: " + advertenciasEmitidas + " | Expulsiones: " + expulsionesEmitidas;
    }

    public String noPuedeCrearExamen() {
        return "Este profesor no puede crear exámenes porque no imparte asignaturas.";
    }
}
