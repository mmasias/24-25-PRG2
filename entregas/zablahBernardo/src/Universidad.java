
import java.util.Scanner;

public class Universidad {

    private ProfesorAsignatura profesorAsignatura;
    private ProfesorVigilante profesorVigilante;
    private Asignatura asignatura;
    private boolean cursoTerminado = false;

    public Universidad() {
        ProfesorAsignatura profesorAsignatura = null;
        ProfesorVigilante profesorVigilante = null;
    }

    public void iniciarCurso() {

        Scanner scanner = new Scanner(System.in);

        while (!cursoTerminado) {
            System.out.println("\n--- Menú Universidad ---");
            System.out.println("1. Contratar profesor asignatura");
            System.out.println("2. Contratar profesor vigilante");
            System.out.println("3. Crear asignatura");
            System.out.println("4. Asignar asignatura y crear examen");
            System.out.println("5. Iniciar examen");
            System.out.println("6. Terminar curso");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                contratarProfesorAsignatura(scanner);
            } else if (opcion.equals("2")) {
                contratarProfesorVigilante(scanner);
            } else if (opcion.equals("3")) {
                crearAsignatura(scanner);
            } else if (opcion.equals("4")) {
                if (profesorAsignatura != null && asignatura != null) {
                    profesorAsignatura.crearExamen(asignatura);
                    System.out.println("Examen creado y asignatura asignada al profesor asignatura.");
                } else {
                    System.out.println("Debe contratar profesor asignatura y crear asignatura antes.");
                }
            } else if (opcion.equals("5")) {
                if (profesorAsignatura != null && profesorVigilante != null) {
                    profesorAsignatura.entregaExamenAProfesorVigilante(profesorVigilante);
                    iniciarExamen(profesorVigilante);
                } else {
                    System.out.println("Faltan profesor asignatura o vigilante.");
                }
            } else if (opcion.equals("6")) {
                cursoTerminado = true;
                System.out.println("Curso terminado.");
            } else {
                System.out.println("Opción no válida.");
            }

        }

    }

    private void contratarProfesorAsignatura(Scanner scanner) {
        System.out.print("Nombre del profesor asignatura: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI del profesor asignatura: ");
        String dni = scanner.nextLine();
        profesorAsignatura = new ProfesorAsignatura(nombre, dni);
        System.out.println("Profesor asignatura contratado: " + profesorAsignatura.entregarDatosProfesor());
    }

    private void contratarProfesorVigilante(Scanner scanner) {
        System.out.print("Nombre del profesor asignatura: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI del profesor asignatura: ");
        String dni = scanner.nextLine();
        profesorVigilante = new ProfesorVigilante(nombre, dni);
        System.out.println("Profesor asignatura contratado: " + profesorVigilante.entregarDatosProfesor());
    }

    private void crearAsignatura(Scanner scanner) {
        System.out.print("Nombre de la asignatura: ");
        String nombreAsignatura = scanner.nextLine();
        asignatura = new Asignatura(nombreAsignatura);
        System.out.println("Asignatura creada: " + asignatura.getNombre());
    }

    private void iniciarExamen(ProfesorVigilante profesorVigilante) {
        if (profesorVigilante != null) {
            profesorVigilante.vigilarExamen();
        } else {
            System.out.println("No hay profesor vigilante contratado para iniciar el examen.");
        }
    }

}
