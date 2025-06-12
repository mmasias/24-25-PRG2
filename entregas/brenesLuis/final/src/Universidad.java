

public class Universidad {
    private String nombre;
    private ProfesorExaminador profesorExaminador;
    private ProfesorVigilante profesorVigilante;
    private Asignatura asignatura;
    private Examen examen;
    private Scanner scanner;

    public Universidad() {
        scanner = new Scanner(System.in);
    }

    public void iniciarCurso() {
        nombrarUniversidad();
        nombrarProfesorExaminador();

        if (profesorExaminador.getAsignatura() == null) {
            System.out.println("El profesor examinador debe tener una asignatura. Cancelando...");
            return;
        }

        designarAsignatura();
        crearExamen();
        nombrarProfesorVigilante();
        mostrar();
    }

    private void nombrarUniversidad() {
        System.out.print("Ingrese el nombre de la universidad: ");
        nombre = scanner.nextLine();
    }

    private void nombrarProfesorExaminador() {
        System.out.print("Nombre del profesor examinador: ");
        String nombre = scanner.nextLine();
        profesorExaminador = new ProfesorExaminador(nombre);

        System.out.print("Nombre de la asignatura que imparte: ");
        String nombreAsignatura = scanner.nextLine();
        profesorExaminador.setAsignatura(new Asignatura(nombreAsignatura));
    }

    private void nombrarProfesorVigilante() {
        System.out.print("Nombre del profesor vigilante: ");
        String nombre = scanner.nextLine();
        profesorVigilante = new ProfesorVigilante(nombre);
        examen.setVigilante(profesorVigilante);
    }

    private void designarAsignatura() {
        asignatura = profesorExaminador.getAsignatura();
        System.out.println("Asignatura designada: " + asignatura.getNombre());
    }

    private void crearExamen() {
        examen = new Examen(asignatura);
        examen.diseñarExamen(scanner);
    }

    private void mostrar() {
        System.out.println("\n--- Universidad: " + nombre + " ---");
        System.out.println("Profesor Examinador: " + profesorExaminador.getNombre());
        System.out.println("Asignatura: " + asignatura.getNombre());
        System.out.println("Profesor Vigilante: " + profesorVigilante.getNombre());
        examen.mostrar();
    }
}