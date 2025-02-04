import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) {
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] patron = {2, 2, 1, 2, 2, 2, 1};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una nota (Ejemplo: Do, Re#, Fa#): ");
        String notaBase = scanner.next();

        int indice = -1;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(notaBase)) {
                indice = i;
            }
        }

        if (indice == -1) {
            System.out.println("Nota inválida. Intente nuevamente.");
        } else {
            System.out.print("Escala mayor de " + notaBase + ": ");
            System.out.print(notaBase + " ");
            for (int i = 0; i < patron.length; i++) {
                indice = (indice + patron[i]) % notas.length;
                System.out.print(notas[indice] + " ");
            }
            System.out.println();

            int indiceTercera = (indice + 2) % notas.length;
            int indiceQuinta = (indice + 4) % notas.length;
            System.out.println("Acorde mayor de " + notaBase + ": " + notaBase + " - " + notas[indiceTercera] + " - " + notas[indiceQuinta]);
        }
    }
}