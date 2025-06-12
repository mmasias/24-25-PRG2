package vaqueroInigo;

public class Examen {
    private String nombre;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private Vigilante vigilante;

    public Examen(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPreguntas(String p1, String p2, String p3) {
        this.pregunta1 = p1;
        this.pregunta2 = p2;
        this.pregunta3 = p3;
    }

    public void entregarAVigilante(Vigilante vigilante) {
        this.vigilante = vigilante;
    }

    public void mostrarPreguntas() {
        System.out.println("Pregunta 1: \"" + pregunta1 + "\"");
        System.out.println("Pregunta 2: \"" + pregunta2 + "\"");
        System.out.println("Pregunta 3: \"" + pregunta3 + "\"");
    }

    public String getNombre() {
        return nombre;
    }
}
