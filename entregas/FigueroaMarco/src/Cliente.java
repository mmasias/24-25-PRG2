public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Nacional");

        Asignaturas asignatura1 = universidad.crearAsignatura("Matemáticas", "MAT", 5);
        Asignaturas asignatura2 = universidad.crearAsignatura("Física", "FIS", 4);

        universidad.crearProfesor("Dr. Juan Pérez", "12345678A", "titular");
        universidad.crearProfesor("Lic. Ana Gómez", "87654321B", "vigilante");
        universidad.verProfesores();

        universidad.verProfesores();

        universidad.profesorVigilarExamen(1, asignatura1);

        // Ver pensum
        universidad.verPensum();
    }
}