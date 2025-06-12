public class ProfesorVigilante {
    public String nombre;
    public String dni;

    public ProfesorVigilante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public static ProfesorVigilante vigilarExamen(String nombre, String dni) {
        return new ProfesorVigilante(nombre, dni);
    }
}
