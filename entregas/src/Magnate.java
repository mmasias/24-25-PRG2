public class Magnate {
    public void crearUniversidad() {
        Universidad universidad = new Universidad("Tech University");
        System.out.println("\n=== Universidad creada: " + universidad.nombre + " ===\n");

        String materia = universidad.crearAsignatura("Matemáticas");
        System.out.println();

        Profesor profA = universidad.contratarProfesor("Ana Pérez");
        Profesor profB = universidad.contratarProfesor("Luis Gómez");
        System.out.println();

        System.out.println("\n=== Inicio del examen ===");
        universidad.asignarAsignatura(profA, materia);
        System.out.println();

        Examen ex = universidad.comunicarExamen(profA);
        System.out.println();

        universidad.vigilarExamen(profB, ex);
        System.out.println();
        
        universidad.evaluarResultados(ex);
        System.out.println("\n=== Fin del examen ===");
    }
}
