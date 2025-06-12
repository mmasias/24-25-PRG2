public class Universidad {
    public void crearUniversidad() {
        SecretariaAcademica cicloAcademico = new SecretariaAcademica("Tech University");
        System.out.println("\n=== Universidad creada: " + cicloAcademico.nombre + " ===\n");

        String materia = cicloAcademico.crearAsignatura("Matemáticas");
        System.out.println();

        Profesor profA = cicloAcademico.contratarProfesor("Ana Pérez");
        Profesor profB = cicloAcademico.contratarProfesor("Luis Gómez");
        System.out.println();

        cicloAcademico.asignarAsignatura(profA, materia);
        System.out.println();

        Examen ex = cicloAcademico.comunicarExamen(profA);
        System.out.println();

        cicloAcademico.vigilarExamen(profB, ex);
        System.out.println();
        
        cicloAcademico.evaluarResultados(ex);
        System.out.println("\n=== Fin del escenario ===");
    }
}
