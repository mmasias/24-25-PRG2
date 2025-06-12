
public class Examen {

    private String[] preguntas;
    private String nombre;
    private Asignatura asignatura;

    public Examen(String nombre, String[] preguntas, Asignatura asignatura) {
        this.preguntas = preguntas;
        this.nombre = nombre;
        this.asignatura = asignatura;
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
