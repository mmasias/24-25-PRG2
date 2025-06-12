package valdesCarlos;

public class ProfesorVigilante {
    private String nombre;
    private String dni;

    public ProfesorVigilante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void vigilarExamen(Examen examen) {
        System.out.println("El profesor " + nombre + " está vigilando el examen.");
    }
}
