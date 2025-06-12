package entregas.orozcoBeatriz;

public class Pregunta {
    private String texto;
    public Pregunta(String texto) {
        this.texto = texto;
    }

    public void mostrar() {
        System.out.println("- " + texto);
    }
}
