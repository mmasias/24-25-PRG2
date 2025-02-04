import java.util.Scanner;

public class EscalasAcordes {

    private static final String[] NOTAS = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la nota base (Ejemplo: Do, Re, Mi, Fa, Sol, La, Si, Do): ");
        String notaBase = scanner.nextLine().trim();

        System.out.println();
        scanner.close();
    }
}
