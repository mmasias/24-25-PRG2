public class SimuladorUniversidad {

    public void ejecutarSimulacion() {
        Universidad universidad = new Universidad("Universidad Europea Del Atlántico");

        Asignatura asignatura = universidad.definirAsignatura("Programación 2");

        RecursosHumanos rhh = universidad.getRecursosHumanos();

        ProfesorAsignatura profesorImpartidor = rhh.contratarProfesorParaImpartir("Profesor que imparte la asignatura");
        rhh.asignarAsignaturaAProfesor(profesorImpartidor, asignatura);
        rhh.solicitarCreacionDeExamen(profesorImpartidor);

        ProfesorSupervisor profesorSupervisor = rhh.contratarProfesorParaSupervision("Profesor supervisor");
        rhh.asignarSupervisionDeExamen(profesorImpartidor, profesorSupervisor);

        // Mostrar escenario completo
        mostrarEscenario(universidad, profesorImpartidor, asignatura, profesorSupervisor);
    }

    private void mostrarEscenario(Universidad universidad, ProfesorAsignatura profesor, Asignatura asignatura,
            ProfesorSupervisor supervisor) {
        System.out.println("Universidad: " + universidad.getNombre());
        System.out.println("Profesor: " + profesor.getNombreProfesor());
        System.out.println("Asignatura: " + asignatura.getNombre() + " - " + asignatura.getCodigo() + " - "
                + asignatura.getCreditos() + " créditos");

        Examen examen = profesor.getExamen();
        System.out.println("   Examen: " + examen.getTitulo());
        System.out.println("   Vigilado por: " + supervisor.getNombreProfesor());

        String[] preguntas = examen.getPreguntas();
        for (int i = 0; i < examen.getCantidadPreguntas(); i++) {
            System.out.println("   " + preguntas[i]);
        }
    }
}
