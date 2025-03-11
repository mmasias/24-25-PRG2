package entregas.FilothJose.Reto001;
import java.util.Scanner;

public class EscalaMayor {

    private static final String[] NOTAS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final int[] PATRON_ESCALA_MAYOR = { 2, 2, 1, 2, 2, 2, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una la nota a trabajar: ");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }

        int opcion = scanner.nextInt() - 1;

        if (opcion >= 0 && opcion < NOTAS.length) {
            String notaSeleccionada = NOTAS[opcion];
            System.out.println("Ha elegido la nota " + notaSeleccionada);

            String[] escalaMayor = new String[8];
            construirEscala(notaSeleccionada, escalaMayor);
            System.out.print("La escala de " + notaSeleccionada + " Mayor es: ");
            imprimirArray(escalaMayor);

            String[] acordeMayor = new String[3];
            construirAcorde(escalaMayor, acordeMayor);
            System.out.print("El acorde de " + notaSeleccionada + " Mayor está conformado por: ");
            imprimirArray(acordeMayor);
        } else {
            System.out.println("Opción no válida. Por favor, seleccione un número entre 1 y 12.");
        }

        scanner.close();
    }

    private static void construirEscala(String notaBase, String[] escala) {
        int indice = -1;
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equals(notaBase)) {
                indice = i;

            }
        }

        escala[0] = notaBase;

        for (int i = 0; i < PATRON_ESCALA_MAYOR.length; i++) {
            indice = (indice + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[indice];
        }
    }

    private static void construirAcorde(String[] escala, String[] acorde) {

        acorde[0] = escala[0];
        acorde[1] = escala[2];
        acorde[2] = escala[4];
    }

    private static void imprimirArray(String[] array) {
        for (String nota : array) {
            System.out.print("[" + nota nota + "] / ");
        }
        System.out.println();
    }
}
