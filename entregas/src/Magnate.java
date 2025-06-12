// Magnate.java
public class Magnate {
    public void financiarUniversidad() {
        Universidad uni = new Universidad("Tech University");
        System.out.println("\n=== Universidad creada: " + uni.nombre + " ===\n");

        // 1) Crear asignatura
        String materia = uni.crearAsignatura("Matemáticas");
        System.out.println();

        // 2) Contratar profesores
        Profesor profA = uni.contratarProfesor("Ana Pérez");
        Profesor profB = uni.contratarProfesor("Luis Gómez");
        System.out.println();

        // 3) Asignar materia a profA
        uni.asignarAsignatura(profA, materia);
        System.out.println();

        // 4) Encargar examen a profA
        Examen ex = uni.comunicarExamen(profA);
        System.out.println();

        // 5) ProfB (sin materia) vigila el examen
        uni.vigilarExamen(profB, ex);
        System.out.println();

        // 6) ProfA evalúa y muestra aciertos
        uni.evaluarResultados(ex);
        System.out.println("\n=== Fin del escenario ===");
    }
}
