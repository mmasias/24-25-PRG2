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

        String[] escalaMayor = construirEscalaMayor(notaBase);
        String[] acordeMayor = construirAcordeMayor(escalaMayor);

        System.out.println("Escala mayor de " + notaBase + ":");
        for (String nota : escalaMayor) {
            System.out.print(nota + " ");
        }

        System.out.println("Acorde mayor de " + notaBase + ":");
        for (String nota : acordeMayor) {
            System.out.print(nota + " ");
        }

        System.out.println();
        scanner.close();
    }

    private static String[] construirEscalaMayor(String notaBase) {
        String[] escala = new String[7];
        int indice = obtenerIndiceNota(notaBase);

        for (int i = 0; i < PATRON_ESCALA_MAYOR.length; i++) {
            escala[i] = NOTAS[indice];
            indice = (indice + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
        }
        return escala;
    }

    private static String[] construirAcordeMayor(String[] escalaMayor) {
        return new String[]{escalaMayor[0], escalaMayor[2], escalaMayor[4]};
    }

    private static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equalsIgnoreCase(nota)) {
                return i;
            }
        }
        return 0;
    }
}
