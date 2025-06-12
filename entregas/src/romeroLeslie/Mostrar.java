public class Mostrar {
    public static void mostrarEscenario(
        String universidad, 
        Profesor profesor, 
        Universidad asignatura, 
        CrearExamen examen, 
        ProfesorVigilante vigilante
    ) {
        System.out.println("Universidad: " + universidad);
        System.out.println("Prof. " + profesor.nombre + "/DNI " + profesor.dni);
        System.out.println("Asignatura " + asignatura.nombreAsignatura);
        System.out.println("Examen final");
        System.out.println("Vigilado por " + vigilante.nombre);
        System.out.println("pregunta 1 " + examen.pregunta1);
        System.out.println("pregunta 2 " + examen.pregunta2);
        System.out.println("pregunta 3 " + examen.pregunta3);  
    }
}
