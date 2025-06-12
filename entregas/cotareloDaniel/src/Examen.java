public class Examen {
    private String nombre;
    private PreguntasExamen preguntas;

    public Examen(String nombre, PreguntasExamen preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public PreguntasExamen getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(PreguntasExamen nuevasPreguntas) {
        preguntas = nuevasPreguntas;
    }

    @Override
    public String toString() {
        return nombre + " con preguntas:\n" + preguntas.toString();
    }
}
