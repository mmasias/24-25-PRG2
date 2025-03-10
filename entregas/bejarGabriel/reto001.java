import java.util.Scanner;

public class Reto001 {

    public static void main(String[] args) {

        final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese una la nota a trabajar: ");
            System.out.println("1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
            int opcion = scanner.nextInt() - 1;

            if (opcion < 0 || opcion >= NOTAS.length) {
                System.out.println("Opción no válida.");
                return;
            }

            System.out.println("Ha elegido la nota " + NOTAS[opcion]);

            String[] escalaMayor = new String[8];
            for (int i = 0; i < 8; i++) {
                escalaMayor[i] = NOTAS[(opcion + i) % NOTAS.length];
                if (i > 0) {
                    opcion += PATRON_ESCALA_MAYOR[i - 1];
                }
            }

            System.out.print("La escala de " + NOTAS[opcion] + " Mayor es: ");
            for (String nota : escalaMayor) {
                System.out.print("[" + nota + "] / ");
            }
            System.out.println();

            String acordeMayor = "[" + escalaMayor[0] + "] / [" + escalaMayor[2] + "] / [" + escalaMayor[4] + "]";
            System.out.println("El acorde de " + NOTAS[opcion] + " Mayor está conformado por: " + acordeMayor);

            System.out.println("julio");
        }
    }
}