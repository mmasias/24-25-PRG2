package doaltoBienvenido;

public class Asignatura {
    private String nombre;
    private String examenTitulo;
    private String[] preguntas;

    public void crearAsignatura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setExamen(String titulo) {
        this.examenTitulo = titulo;
        this.preguntas = new String[3];
        preguntas[0] = "¿Qué es la Programación Orientada a Objetos?";
        preguntas[1] = "Explique el concepto de herencia.";
        preguntas[2] = "¿Qué es el polimorfismo en Java?";
    }

    public String getExamenTitulo() {
        return examenTitulo;
    }

    public String[] getPreguntas() {
        return preguntas;
    }
}

