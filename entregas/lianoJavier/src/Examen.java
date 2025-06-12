
public class Examen {

    private String[] preguntas;
    private String nombre;

    public Examen(String nombre, String[] preguntas) {
        this.preguntas = preguntas;
        this.nombre = nombre;
    }

    public void mostrarPreguntas() {
        for (String pregunta : preguntas) {
            Utilidades.mensaje('"' + pregunta + '"');
            Utilidades.saltarLinea();
        }
    }

    public void mostrarNombre() {
        Utilidades.mensaje(nombre);
    }

}
