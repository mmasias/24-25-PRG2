package entregas.src.calderonJimena;

import java.util.Scanner;

public class Asignatura {
    private String nombre;
    private String abreviatura;
    private int creditos;
    private Profesor profesorResponsable;

    public Asignatura(String nombre, String abreviatura, int creditos, Profesor profesorResponsable) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.creditos = creditos;
        this.profesorResponsable = profesorResponsable;
    }

    public static Asignatura crearAsignatura(Profesor profesorResponsable) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre de la asignatura: ");
        String nombreAsignatura = scanner.nextLine();

        System.out.print("Abreviatura de la asignatura: ");
        String abreviaturaAsignatura = scanner.nextLine();

        int cantidadCreditos = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Número de créditos: ");
            String entrada = scanner.nextLine();
            try {
                cantidadCreditos = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, escriba un número válido para los créditos.");
            }
        }

        return new Asignatura(nombreAsignatura, abreviaturaAsignatura, cantidadCreditos, profesorResponsable);
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public Profesor getProfesorResponsable() {
        return profesorResponsable;
    }
}
