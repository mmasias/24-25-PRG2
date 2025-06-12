package src.gonzalezMarcos;

public class Main {
    public static void main(String[] args) {
        Universidad uneat = new Universidad("Universidad Europea del Atlántico");

        Asignatura prg2 = new Asignatura("Programación 2", "PRG2", 6);

        Profesor prof1 = new Profesor("Jesús Fernández", "244455555X");
        prof1.asignarAsignatura(prg2);
        
        Examen examen = prof1.crearExamen("Examen final de Programación 2");
        examen.setCreador(prof1);

        Profesor prof2 = new Profesor("Ana Gómez", "666456665X");
        examen.asignarVigilante(prof2);

        prof1.entregarExamenA(examen, prof2);

        imprimirResultados(uneat, prof1, prof2, examen);

    }

    public static void imprimirResultados(Universidad universidad, Profesor prof1, Profesor prof2, Examen examen) {
        System.out.println("Universidad: " + universidad.getNombre());
        System.out.println("Profesor: " + prof1.getNombre() + " (DNI: " + prof1.getDni() + ")");
        System.out.println("Examen: " + examen.getTitulo() + ", creado por:" + examen.getCreador(prof1).getNombre());
        System.out.println("Vigilado por: " + prof2.getNombre() + " (DNI: " + prof2.getDni() + ")");
        int i = 1;
        for (String pregunta : examen.getPreguntas()) {
            System.out.println("Pregunta " + i + ": " + pregunta);
            i++;
        }
    }
}
