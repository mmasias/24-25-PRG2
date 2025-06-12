public class Profesor extends Persona {

    public static void crearExamen(Asignatura asignatura) {
        if (asignatura == null) {
            System.out.println("No puede crear examen sin asignatura");
            return;
        }

        Examen examen = new Examen();
        examen.agregarPregunta("Vista pública de clases");
        examen.agregarPregunta("Vista pública de objetos");
        examen.agregarPregunta("Vista privada con herencia");

        examen.mostrar();
    }

    public static void entregarExamen(Asignatura asignaturaOtroProfesor) {
        if (asignaturaOtroProfesor == null) {
            System.out.println("Examen entregado al profesor vigilante.");
        } else {
            System.out.println("El otro profesor imparte asignatura. No puede vigilar el examen.");
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Profesor sin estado interno");
    }
}
