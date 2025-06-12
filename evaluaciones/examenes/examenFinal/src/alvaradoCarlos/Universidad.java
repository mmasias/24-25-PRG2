package alvaradoCarlos;
import java.util.Scanner;

public class Universidad {

    private String nombre;
    private Profesor[] profesores;
    private int cantidadProfesores;
    private Asignatura asignatura;
    private Examen examen;
    private Scanner scanner;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new Profesor[10];
        this.cantidadProfesores = 0;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            menu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    contratarProfesor();
                case 2:
                    crearAsignatura();
                case 3:
                    asignarAsignatura();
                case 4:

                case 7:
                    System.out.println("Saliendo del programa...");
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    private void menu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Contratar Profesores");
        System.out.println("2. Crear Asignatura");
        System.out.println("3. Asignar Asignatura a Profesor");
        System.out.println("4. Crear Examen");
        System.out.println("5. Entregar Examen");
        System.out.println("6. Vigilar Examen");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void contratarProfesor() {
        if (cantidadProfesores >= profesores.length) {
            System.out.println("No se pueden contratar más profesores.");
            return;
        }

        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del profesor: ");
        String dni = scanner.nextLine();

        Profesor nuevoProfesor = new Profesor(nombre, dni);
        profesores[cantidadProfesores] = nuevoProfesor;
        cantidadProfesores++;

        System.out.println("Profesor contratado: " + nuevoProfesor.nombre());
    }

    public void crearAsignatura() {
        System.out.print("Ingrese el nombre de la asignatura: ");
        String nombreAsignatura = scanner.nextLine();
        System.out.print("Ingrese el número de créditos de la asignatura: ");
        int creditos = scanner.nextInt();
        scanner.nextLine();
        this.asignatura = new Asignatura(nombreAsignatura, creditos);
        System.out.println("Asignatura creada: " + asignatura);
    }

    public void asignarAsignatura() {
        if (asignatura == null) {
            System.out.println("No hay asignaturas disponibles.");
            crearAsignatura();
        }

        if (cantidadProfesores == 0) {
            System.out.println("No hay profesores contratados.");
            return;
        }

        System.out.println("Lista de profesores:");
        for (int i = 0; i < cantidadProfesores; i++) {
            System.out.println((i + 1) + ". " + profesores[i].nombre());
        }

        System.out.print("Seleccione el número del profesor: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > cantidadProfesores) {
            System.out.println("Selección inválida.");
            return;
        }

        Profesor seleccionado = profesores[seleccion - 1];
        seleccionado.agregarAsignatura(asignatura);

        System.out.println("Asignatura " + asignatura + " asignada al profesor " + seleccionado.nombre());
    }
}
