package rivasMiguel;

import java.util.Scanner;

public class Universidad {
    private String nombre;
    private Asignatura[] asignaturas;
    private Profesor[] profesores;
    private Examen[] examenes;
    private int numAsignaturas;
    private int numProfesores;
    private int numExamenes;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new Asignatura[100];
        this.profesores = new Profesor[100];
        this.examenes = new Examen[100];
        this.numAsignaturas = 0;
        this.numProfesores = 0;
        this.numExamenes = 0;
    }

    public void administrarUniversidad() {
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println("\n=== Universidad " + nombre + " ===");
            System.out.println("1. Crear asignatura");
            System.out.println("2. Crear profesor");
            System.out.println("3. Asignar/quitar asignatura a profesor");
            System.out.println("4. Crear examen");
            System.out.println("5. Dar examen a vigilante");
            System.out.println("6. Listar todo");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> crearAsignatura(sc);
                case 2 -> crearProfesor(sc);
                case 3 -> gestionarAsignaturaProfesor(sc);
                case 4 -> crearExamen(sc);
                case 5 -> darExamenVigilante(sc);
                case 6 -> listarTodos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opc != 0);
    }

    private void crearAsignatura(Scanner sc) {
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Nombre corto: ");
        String corto = sc.nextLine();
        System.out.print("Creditos: ");
        int cr = Integer.parseInt(sc.nextLine());
        asignaturas[numAsignaturas++] = new Asignatura(nom, corto, cr);
    }

    private void crearProfesor(Scanner sc) {
        System.out.print("Nombre: ");
        String nomP = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        profesores[numProfesores++] = new Profesor(nomP, dni);
    }

    private void gestionarAsignaturaProfesor(Scanner sc) {
        if (numProfesores == 0 || numAsignaturas == 0) {
            System.out.println("Debe haber al menos un profesor y una asignatura.");
            return;
        }
        System.out.println("Profesores disponibles:");
        for (int i = 0; i < numProfesores; i++) {
            System.out.printf("%d: %s\n", i, profesores[i].getNombre());
        }
        System.out.print("Seleccione indice de profesor: ");
        int ip = Integer.parseInt(sc.nextLine());
        Profesor prof = profesores[ip];

        System.out.println("Asignaturas disponibles:");
        for (int j = 0; j < numAsignaturas; j++) {
            System.out.printf("%d: %s\n", j, asignaturas[j].getNombreCorto());
        }
        System.out.print("Indice de asignatura: ");
        int ia = Integer.parseInt(sc.nextLine());
        Asignatura asig = asignaturas[ia];

        if (prof.tieneAsignatura(asig)) {
            prof.quitarAsignatura(asig);
            System.out.println("Asignatura quitada.");
        } else {
            prof.asignarAsignatura(asig);
            System.out.println("Asignatura asignada.");
        }
    }

    private void crearExamen(Scanner sc) {
        if (numProfesores == 0) {
            System.out.println("No hay profesores.");
            return;
        }
        System.out.println("Seleccione profesor para crear examen:");
        for (int i = 0; i < numProfesores; i++) {
            System.out.printf("%d: %s\n", i, profesores[i].getNombre());
        }
        int ip = Integer.parseInt(sc.nextLine());
        Profesor prof = profesores[ip];

        if (prof.getNumAsignaturas() == 0) {
            System.out.println("El profesor no tiene asignaturas.");
            return;
        }
        System.out.println("Seleccione asignatura:");
        for (int j = 0; j < prof.getNumAsignaturas(); j++) {
            System.out.printf("%d: %s\n", j, prof.getAsignatura(j).getNombreCorto());
        }
        int ia = Integer.parseInt(sc.nextLine());
        Asignatura asig = prof.getAsignatura(ia);

        System.out.print("Nombre del examen: ");
        String ne = sc.nextLine();
        Examen e = prof.crearExamen(ne, asig, sc);
        examenes[numExamenes++] = e;
    }

    private void darExamenVigilante(Scanner sc) {
        if (numExamenes == 0) {
            System.out.println("No hay exámenes creados.");
            return;
        }
        System.out.println("Seleccione examen para dar:");
        for (int i = 0; i < numExamenes; i++) {
            System.out.printf("%d: %s (%s)\n", i, examenes[i].getNombre(), examenes[i].getAsignatura().getNombreCorto());
        }
        int ie = Integer.parseInt(sc.nextLine());
        Examen ex = examenes[ie];

        System.out.println("Seleccione profesor vigilante (sin asignaturas):");
        for (int i = 0; i < numProfesores; i++) {
            if (profesores[i].getNumAsignaturas() == 0) {
                System.out.printf("%d: %s\n", i, profesores[i].getNombre());
            }
        }
        int iv = Integer.parseInt(sc.nextLine());
        Profesor vigilante = profesores[iv];

        ex.getProfesor().darExamen(vigilante, ex);
    }

    private void listarTodos() {
        System.out.println("Asignaturas:");
        for (int i = 0; i < numAsignaturas; i++) {
            System.out.println(asignaturas[i]);
        }
        System.out.println("Profesores:");
        for (int i = 0; i < numProfesores; i++) {
            System.out.println(profesores[i]);
        }
        System.out.println("Examenes:");
        for (int i = 0; i < numExamenes; i++) {
            System.out.println(examenes[i]);
        }
    }
}
