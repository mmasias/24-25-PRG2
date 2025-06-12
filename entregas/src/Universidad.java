public class Universidad {
    Profesor profesor1; 
    Profesor profesor2; 

    public void contratar() {
        System.out.println("Contratando profesores...");

        profesor1 = new Profesor("Profesor 1");
        profesor1.asignarAsignatura("Programacion");
        System.out.println("Profesor 1 ha sido contratado con la asignatura: Programacion.");

        profesor2 = new Profesor("Profesor 2");
        System.out.println("Profesor 2 ha sido contratado sin asignatura.");
    }

    public void entregar() {
        System.out.println("Profesor 1 intentará entregar el examen...");
        profesor1.entregar();
    }

    public void vigilar() {
        System.out.println("Profesor 2 vigilará durante el examen...");
        profesor2.vigilar();
    }

    public static void main(String[] args) {
        Universidad universidad = new Universidad();

        universidad.contratar();

        System.out.println("\nProfesor 1 intentará crear un examen...");
        Examen examen = new Examen();
        universidad.profesor1.crearExamen(examen);

        System.out.println("\nUniversidad gestiona la entrega del examen:");
        universidad.entregar();

        System.out.println("\nUniversidad asigna vigilancia al Profesor 2:");
        universidad.vigilar();
    }
}
