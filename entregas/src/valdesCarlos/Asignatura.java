package valdesCarlos;

public class Asignatura {
    private String nombre;
    private int creditos;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }
    

    public void determinarNota(Alumno alumno) {
        System.out.println("La nota del alumno en " + nombre + " ha sido determinada.");
    }
}
