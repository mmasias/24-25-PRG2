package alvaradoCarlos;
import java.util.Scanner;

public class Profesor {

    private String nombre;
    private String DNI;
    private Scanner scanner;
    private Asignatura[] asignaturas;
    private int cantidadAsignaturas;

    public Profesor(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.asignaturas = new Asignatura[10];
        this.scanner = new Scanner(System.in);
    }

    public String nombre() {
        return nombre;
    }

    public Examen crearExamen(Asignatura asignatura) {
        System.out.println("Ingrese el nombre del examen: ");
        String tipo = scanner.nextLine();
        return new Examen(tipo, asignatura);
    }

    public void entregarExamen(Examen examen, Profesor profesorAsignado, Profesor profesorVigilante) {
        System.out.println("- Examen: " + examen);
        System.out.println("- Asignatura: " + examen);
        System.out.println("- Profesor asignado: " + profesorAsignado.nombre());
    }

    public String toString() {
        return "Profesor: " + nombre + ", DNI: " + DNI;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        if (cantidadAsignaturas < asignaturas.length) {
            asignaturas[cantidadAsignaturas] = asignatura;
            cantidadAsignaturas++;
        } else {
            System.out.println("No se pueden agregar más asignaturas al profesor " + nombre + ".");
        }
    }


}
