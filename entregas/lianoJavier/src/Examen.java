
public class Examen {

    private String[] preguntas;
    private String nombre;

    public Examen(String nombre, String[] preguntas) {
        this.preguntas = preguntas;
        this.nombre = nombre;
    }

    public void mostrarPreguntas() {
        for (String pregunta : preguntas) {
            mensaje(pregunta);
            saltarLinea();
        }
    }

    private void mensaje(String pregunta) {
        System.out.print(pregunta);
    }

    private void saltarLinea() {
        System.out.println();
    }

    public void mostrarNombre() {
        mensaje(nombre);
    }

}
