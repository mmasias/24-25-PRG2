public class RecursosHumanos {
    private Limitaciones reglasDeLimitacion = new Limitaciones();

    public ProfesorAsignatura contratarProfesorParaImpartir(String nombreProfesor) {
        return new ProfesorAsignatura(nombreProfesor);
    }

    public ProfesorSupervisor contratarProfesorParaSupervision(String nombreProfesor) {
        return new ProfesorSupervisor(nombreProfesor);
    }

    public void asignarAsignaturaAProfesor(ProfesorAsignatura profesorAsignatura, Asignatura asignatura) {
        profesorAsignatura.impartirAsignatura(asignatura);
    }

    public void solicitarCreacionDeExamen(ProfesorAsignatura profesorAsignatura) {
        profesorAsignatura.crearExamen();
    }

    public boolean profesorPuedeSupervisar(ProfesorSupervisor profesorSupervisor) {
        return reglasDeLimitacion.verificar(profesorSupervisor);
    }

    public void asignarSupervisionDeExamen(ProfesorAsignatura profesorCreador, ProfesorSupervisor profesorSupervisor) {
        if (profesorPuedeSupervisar(profesorSupervisor)) {
            Examen examen = profesorCreador.getExamen();
            profesorCreador.enviarExamenA(profesorSupervisor);
            profesorSupervisor.recibirExamen(examen);
        } else {
            System.out.println("Error: El profesor supervisor no cumple las condiciones para supervisar este examen.");
        }
    }
}
