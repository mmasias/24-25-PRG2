import java.util.Scanner;

public class Universidad {

    private String nombre;
    private Profesor profesor;
    private Asignatura asignatura;
    private Examen examenes;
    private Scanner scanner;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        if (this.profesor == null) {
            System.out.println("No hay profesores.");
            contratarProfesor();
        } else {

        }
    }

    public void contratarProfesor(){
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del profesor: ");
        String dni = scanner.nextLine();
        this.profesor = new Profesor(nombre, dni);
        System.out.println("Profesor contratado: " + this.profesor.nombre());
    }

    public void crearAsignatura(){
        System.out.print("Ingrese el nombre de la asignatura: ");
        String nombreAsignatura = scanner.nextLine();
        System.out.print("Ingrese el número de créditos de la asignatura: ");
        int creditos = scanner.nextInt();
        this.asignatura = new Asignatura(nombreAsignatura, creditos);
        System.out.println("Asignatura creada: " + this.asignatura);

    }

    public void asignarAsignatura(Asignatura asignatura, Profesor profesor) {
        if (this.asignatura == null) {
            System.out.println("No hay asignaturas disponibles.");
            crearAsignatura();
        } else {
            this.asignatura = asignatura;
            System.out.println("Asignatura " + asignatura + " asignada al profesor " + profesor.nombre());
        }
    }
    
}
