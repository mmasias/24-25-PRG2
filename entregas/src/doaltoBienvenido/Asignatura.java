package doaltoBienvenido;

public class Asignatura {
    private String nombre;
    private String examenTitulo;
    private String[] preguntas;

    public Asignatura() {
        this.nombre = "";
        this.examenTitulo = "";
        this.preguntas = new String[0];
    }

    public void crearAsignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExamenTitulo() {
        return examenTitulo;
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public void setExamenTitulo(String examenTitulo) {
        this.examenTitulo = examenTitulo;
    }

    public void setPreguntas(String[] preguntas) {
        this.preguntas = preguntas;
    }
}
