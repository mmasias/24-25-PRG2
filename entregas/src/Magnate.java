public class Magnate {
    public void ejecutarEscenario() {
        Universidad universidad = new Universidad("Tech University");
        System.out.println("=== Universidad creada: " + universidad.getNombre() + " ===\n");

        Asignatura mate = universidad.crearAsignatura("Matemáticas");
        System.out.println();

        Profesor profA = universidad.contratarProfesor("Ana Pérez");
        Profesor profB = universidad.contratarProfesor("Luis Gómez");
        System.out.println();

        universidad.asignarAsignatura(profA, mate);
        System.out.println();

        Examen examen = universidad.comunicarExamen(profA);
        System.out.println();

        universidad.vigilarExamen(profB, examen);
        System.out.println();

        universidad.evaluarResultados(profA, examen);
        System.out.println("\n=== Fin del escenario ===");
    }
}
