public class ProfesorAsignatura extends Profesor {
    private Asignatura asignatura;

    public ProfesorAsignatura(String nombre, String dni) {
        super(nombre, dni);
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void crearExamen(Asignatura asignatura) {
        asignarAsignatura(asignatura);
        asignatura.crearExamen();
    }

    public void entregaExamenAProfesorVigilante(ProfesorVigilante vigilante) {
        if (asignatura == null) {
            System.out.println("No hay asignatura asignada.");
            return;
        }
        String examen = asignatura.entregarExamen();
        if (examen == null) {
            System.out.println("No hay examen creado en la asignatura.");
        } else {
            vigilante.recibirExamen(examen);
            System.out.println(nombre + " entregó el examen al profesor vigilante.");
        }
    }
}
