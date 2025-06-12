
public class Asignatura {

    private String nombre;
    private String acronimo;
    private int creditos;

    public Asignatura(String nombre, String acronimo, int creditos) {
        this.nombre = nombre;
        this.acronimo = acronimo;
        this.creditos = creditos;
    }

    public void mostrarNombre() {
        Utilidades.mensaje(nombre);
    }

}
