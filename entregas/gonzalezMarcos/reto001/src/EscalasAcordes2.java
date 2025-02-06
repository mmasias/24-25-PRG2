import java.util.Scanner;

public class EscalasAcordes2 {
    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int[] PATRON = { 2, 2, 1, 2, 2, 2, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una nota (Ejemplo: Do, Re#, Fa#): ");
        String notaBase = scanner.next();
        int indice = buscarIndiceNota(notaBase);

        String resultado = (indice == -1)
            ? "Nota inválida. Intente nuevamente."
            : generarEscalaMayor(notaBase, indice) + "\n" + generarAcordeMayor(notaBase, indice);

        System.out.println(resultado);
        scanner.close();
    }

    static int buscarIndiceNota(String nota) {
        int i = 0;
        while (i < NOTAS.length && !NOTAS[i].equals(nota)) i++;
        return i < NOTAS.length ? i : -1;
    }

    static String generarEscalaMayor(String notaBase, int indice) {
        String escala = "Escala mayor de " + notaBase + ": " + notaBase;
        for (int i = 0; i < PATRON.length; i++) {
            indice = (indice + PATRON[i]) % NOTAS.length;
            escala += " " + NOTAS[indice]; 
        }
        return escala;
    }

    static String generarAcordeMayor(String notaBase, int indice) {
        String tercera = NOTAS[(indice + 4) % NOTAS.length];
        String quinta = NOTAS[(indice + 7) % NOTAS.length];
        return "Acorde mayor de " + notaBase + ": " + notaBase + " - " + tercera + " - " + quinta;
    }
}
