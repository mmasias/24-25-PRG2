
public class Examen {
    private Asignatura asignatura;
    private String[] preguntas;
    private Vigilante vigilante;

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new String[3];
    }

    public void montarPreguntas() {
        preguntas[0] = "Vista pública clases";
        preguntas[1] = "Vista pública de objetos";
        preguntas[2] = "Vista privada de clases";
    }

    public void entregarAVigilante(Vigilante vigilante) {
        this.vigilante = vigilante;
    }

    public void mostrarResumen(String nombreUni, Profesor profesor) {
        System.out.println("Universidad: " + nombreUni);
        System.out.println("Profesor : " + profesor.getNombre() + " / DNI " + profesor.getDni());
        Asignatura a = profesor.getAsignatura();
        System.out.println("Asignatura: " + a.getNombre() + " - PRG2 - " + a.getCreditos() + " créditos");
        System.out.println("Examen: Examen Final");
        System.out.println("Vigilado por : " + vigilante.getNombre() + " / DNI " + vigilante.getDni());
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + (i + 1) + ": \"" + preguntas[i] + "\"");
        }
    }
}
