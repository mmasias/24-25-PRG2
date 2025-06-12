public class Supervisor {
    private String nombre;
    private String dni;

    public Supervisor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void recibir(Examen e, Profesor p) {
        System.out.println("Examen recibido por el supervisor.");
        System.out.println(e.toString());
        System.out.println("Vigilado por: " + nombre + " / DNI " + dni);
    }
}

