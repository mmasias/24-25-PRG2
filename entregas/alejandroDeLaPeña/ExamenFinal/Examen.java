package entregas.alejandroDeLaPeña.ExamenFinal;

public class Examen {
    private String nombreExamen;
    private Profesor profesor;
    private String[] preguntas;
    private int puntos;

    public Examen(String nombreExamen, Profesor profesor, String[] preguntas, int puntos) {
        this.nombreExamen = nombreExamen;
        this.profesor = profesor;
        this.preguntas = preguntas;
        this.puntos = puntos;
    }

    public void mostrarExamen() {
        System.out.println("Examen: " + nombreExamen);
        System.out.println("Profesor: " + profesor.getNombreCompleto());
        System.out.println("Puntos: " + puntos);
        System.out.println("Preguntas:");
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println((i + 1) + ". " + preguntas[i]);
        }
    }
}
