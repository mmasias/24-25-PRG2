package entregas.orozcoBeatriz;

class ProfesorImparte extends Profesor {

    private Examen examenCreado;

    public ProfesorImparte(String nombre) {
        super(nombre);
    }

    public void crearExamenConPreguntas(String asignatura) {
        examenCreado = new Examen(asignatura);
        examenCreado.agregarPregunta("Pregunta 1");
        examenCreado.agregarPregunta("Pregunta 2");
        examenCreado.agregarPregunta("Pregunta 3");
    }

    public void entregarExamenA(ProfesorVigila vigilante) {
        if (examenCreado != null) {
            vigilante.recibirExamen(examenCreado);
        }
    }
}

