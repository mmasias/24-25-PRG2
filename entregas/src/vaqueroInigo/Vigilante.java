package vaqueroInigo;

public class Vigilante {
    private String nombre;
    private String dni;

    public Vigilante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void vigilarExamen(Examen examen) {
        System.out.println("Vigilado por: " + nombre + " / DNI: " + dni);
    }
}

