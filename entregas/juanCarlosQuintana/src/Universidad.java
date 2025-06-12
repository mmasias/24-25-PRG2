public class Universidad {
    public static void main(String[] args) {
        Asignatura poo = new Asignatura("Programación Orientada a Objetos");

        Profesor profesor1 = Profesor.contratarProfesor("Dra. García", poo);
        Profesor profesor2 = Profesor.contratarProfesor("Sr. López", null); 

        Asignatura.Examen examen = profesor1.crearExamen();

        profesor2.vigilarExamen(examen);

        System.out.println("\n--- Universidad: UNEAT ---");
        System.out.println("Asignatura: " + poo.getNombre());
        System.out.println("Profesor de la asignatura: " + profesor1.getNombre());
        System.out.println("Profesor que vigila: " + profesor2.getNombre());
        System.out.println();
        System.out.println("Examen: Examen Final");
        examen.mostrarExamen();
    }
}
