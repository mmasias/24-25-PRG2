package entregas.src.calderonJimena;

import java.util.Scanner;

public class Profesor {
    private String nombre;
    private String dni;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public static Profesor crearProfesorPorDatos(String descripcionRol) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del profesor " + descripcionRol + ": ");
        String nombreProfesor = scanner.nextLine();

        System.out.print("DNI del profesor " + descripcionRol + ": ");
        String dniProfesor = scanner.nextLine();

        return new Profesor(nombreProfesor, dniProfesor);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
