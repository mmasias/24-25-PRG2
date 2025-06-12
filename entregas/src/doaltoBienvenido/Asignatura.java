package doaltoBienvenido;

public class Asignatura {
    String nombre;
    String examenTitulo;
    String[] preguntas;

    public Asignatura() {
        nombre = "";
        examenTitulo = "";
        preguntas = new String[0];
    }

    public void crearAsignatura(String nombre) {
        this.nombre = nombre;
    }

}



