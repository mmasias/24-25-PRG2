package entregas.delaasuncionJose.Final;
import java.util.Scanner;

public class Examen {
    private Asignatura asignatura;
    private String tipo;
    private String[] preguntas = new String[3];
    private String vigilado;

    public Examen(Asignatura asignatura) {
        Scanner scanner = new Scanner(System.in);
        this.asignatura = asignatura;
        System.out.print("Tipo: ");
        tipo = scanner.nextLine();
        for (int i = 0; i < preguntas.length; i++) {
            System.out.print("Pregunta "+i+1+": ");
            preguntas[i] = scanner.nextLine();
        }
        scanner.close();
    }

    public void vigilado(String profesor) {
        vigilado= profesor;
    }

    public void mostrar() {
        System.out.println("        Examen: " + tipo);
        System.out.println("            Vigilado por:" + vigilado);
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("            Pregunta "+ i+1 + ":" + preguntas[i]);
        }
    }
    
    public Asignatura getAsignatura() {
        return asignatura;
    }
}