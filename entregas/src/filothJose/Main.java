package filothJose;

public class Main {
    public static void main(String[] args) {

        Universidad uni = new Universidad("Universidad Europea del Atlántico");
        System.out.println("Universidad: " + uni.getNombre());

        Asignatura asignatura = new Asignatura("Programación", 6);

        Profesor profImparte = new Profesor("Juan Pérez", "12345678A");
        profImparte.asignarAsignatura(asignatura);

        Profesor profVigila = new Profesor("Ana López", "87654321B");

        Examen examen = profImparte.crearExamen("Examen Final");

        if (examen != null) {
            profImparte.entregarExamen(examen, profVigila);
        }

        System.out.println("Universidad: " + uni.getNombre());
        System.out.println("Profesor que imparte: " + profImparte.getNombre() + " - DNI: " + profImparte.getDni());
        System.out.println("Asignatura: " + asignatura.getNombre() + " - Créditos: " + asignatura.getCreditos());
        System.out.println("Tipo de examen: " + examen.getTipo());
        System.out.println("Profesor que vigila: " + profVigila.getNombre() + " - DNI: " + profVigila.getDni());
        System.out.println("Preguntas del examen:");
        for (String pregunta : examen.getPreguntas()) {
            System.out.println("- " + pregunta);
        }
    }
}
