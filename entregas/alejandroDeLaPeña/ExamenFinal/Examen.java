package entregas.alejandroDeLaPeña.ExamenFinal;

public class Examen {
    private String nombreExamen;
    private Profesor profesorCreador;
    private Profesor vigilante;
    private String[] preguntas;
    private int puntos;

    public Examen(String nombreExamen, Profesor profesorCreador, String[] preguntas, int puntos) {
        this.nombreExamen = nombreExamen;
        this.profesorCreador = profesorCreador;
        this.preguntas = preguntas;
        this.puntos = puntos;
    }

    public void asignarVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public void mostrarExamen() {
        System.out.println("Examen: " + nombreExamen);
        System.out.println("Creador: " + profesorCreador.getNombreCompleto());
        if (vigilante != null) {
            System.out.println("Vigilado por: " + vigilante.getNombreCompleto());
        } else {
            System.out.println("Vigilante: No asignado");
        }
        System.out.println("Puntos totales: " + puntos);
        System.out.println("Preguntas:");
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println((i + 1) + ". " + preguntas[i]);
        }
    }
}
