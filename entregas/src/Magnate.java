public class Magnate {
    public void ejecutarEscenario() {
        Universidad u = new Universidad("Tech University");
        System.out.println("=== Universidad creada: " + u.getNombre() + " ===\n");

        Asignatura mate = u.crearAsignatura("Matemáticas");
        System.out.println();

        Profesor profA = u.contratarProfesor("Ana Pérez");
        Profesor profB = u.contratarProfesor("Luis Gómez");
        System.out.println();

        u.asignarAsignatura(profA, mate);
        System.out.println();

        Examen examen = u.comunicarExamen(profA);
        System.out.println();

        u.vigilarExamen(profB, examen);
        System.out.println();

        u.evaluarResultados(profA, examen);
        System.out.println("\n=== Fin del escenario ===");
    }
}
