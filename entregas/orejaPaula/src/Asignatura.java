
public class Asignatura {
    private String nombre;
    private int creditos;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public static void asignarAsignatura() {
        Asignatura asignatura = Universidad.getAsignatura();
        Profesor profesor = Universidad.getProfesor();
        profesor.asignarAsignatura(asignatura);
    }

    public void mostrar() {
        System.out.println("Asignatura: " + nombre + " - Créditos: " + creditos);
    }

    public String getNombre() {
        return nombre;
    }
}
