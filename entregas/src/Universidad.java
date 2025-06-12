
public class Universidad {
    public void crearUniversidad() {
        SecretariaAcademica uni = new SecretariaAcademica("Tech University");
        System.out.println("\n=== Universidad creada: " + uni.nombre + " ===\n");

        String materia = uni.crearAsignatura("Matemáticas");
        System.out.println();

        Profesor profA = uni.contratarProfesor("Ana Pérez");
        Profesor profB = uni.contratarProfesor("Luis Gómez");
        System.out.println();

        uni.asignarAsignatura(profA, materia);
        System.out.println();

        Examen ex = uni.comunicarExamen(profA);
        System.out.println();

        uni.vigilarExamen(profB, ex);
        System.out.println();

        // 6) ProfA evalúa y muestra aciertos
        uni.evaluarResultados(ex);
        System.out.println("\n=== Fin del escenario ===");
    }
}
