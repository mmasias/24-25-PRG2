public class Main {
    public static void main(String[] args) {
        Universidad uneat = new Universidad("Universidad Europea del Atlántico");
        Asignatura prg2 = new Asignatura("Programación 2", "PRG2", 6);
        Profesor prof1 = new Profesor("Jesús Fernández", "244455555X");
        prof1.asignarAsignatura(prg2);
        Examen examen = prof1.crearExamen();
        Profesor prof2 = new Profesor("Ana Gómez", "666456665X");
        examen.asignarVigilante(prof2);
        prof1.entregarExamenA(examen, prof2);

    }
}
