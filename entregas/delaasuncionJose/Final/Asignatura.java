package entregas.delaasuncionJose.Final;

public class Asignatura {
    private String nombre;
    private int creditos;
    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    public void mostrar() {
        System.out.println("    Asignatura: " + nombre + " - "+ creditos + " creditos");
    }
}
