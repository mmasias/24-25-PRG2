import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#","Si" };
    static final int[] PATRON = { 2, 2, 1, 2, 2, 2, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una nota (Ejemplo: Do, Re#, Fa#): ");
        String notaBase = scanner.next().toUpperCase();
        int indice = obtenerIndiceNota(notaBase);

        if (indice == -1) {
            System.out.println("Nota inválida. Intente nuevamente.");
        } else {
            mostrarEscalaMayor(notaBase, indice);
            mostrarAcordeMayor(notaBase, indice);
        }

        scanner.close();

    }

    static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equalsIgnoreCase(nota)) {
                return i;
            }
        }
        return -1;
    }

    static void mostrarEscalaMayor(String notaBase, int indice) {
        System.out.print("Escala mayor de " + notaBase + ": " + notaBase + " ");
        for (int i = 0; i < PATRON.length; i++) {
            indice = (indice + PATRON[i]) % NOTAS.length;
            System.out.print(NOTAS[indice] + " ");
        }
        System.out.println();
    }

    static void mostrarAcordeMayor(String notaBase, int indice) {
        int indiceTercera = (indice + 2) % NOTAS.length;
        int indiceQuinta = (indice + 4) % NOTAS.length;
        System.out.println("Acorde mayor de " + notaBase + ": " + notaBase + " - " + NOTAS[indiceTercera] + " - " + NOTAS[indiceQuinta]);
    }
}
