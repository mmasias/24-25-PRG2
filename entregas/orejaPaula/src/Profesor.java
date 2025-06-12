public class Profesor extends Persona {

    public static void crearExamen(Asignatura asignatura) {
        if (asignatura == null) {
            System.out.println("No puede crear examen sin asignatura");
            return;
        }

        Examen examen = new Examen();
        examen.agregarPregunta("¿Qué es la vista pública de clases?");
        examen.agregarPregunta("¿Qué es la herencia?");
        examen.agregarPregunta("Explica qué es HOOD");
        examen.mostrar();
    }

    public static void entregarExamen(Asignatura asignaturaOtro) {
        if (asignaturaOtro == null) {
            System.out.println("Examen entregado por otro profesor (vigilante).");
        } else {
            System.out.println("El otro profesor imparte asignatura. No puede vigilar.");
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Profesor: sin atributos internos, usando herencia.");
    }
}

