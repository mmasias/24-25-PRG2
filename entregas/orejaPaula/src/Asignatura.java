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

    public void mostrar() {
        System.out.println("Asignatura: " + nombre + " / Créditos: " + creditos);
    }
}

