
import java.util.Scanner;

public class CalculoEscalaYAcordeMayor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int POSICION_MINIMA_ESCALA = 1;
        final int POSICION_MAXIMA_ESCALA = 12;
        final String NOTAS_ESCALA_COMPLETA[] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int notaInicial, numeroUsuario;

        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        numeroUsuario = scanner.nextInt();
        notaInicial = numeroUsuario - 1;

        if ((numeroUsuario < POSICION_MINIMA_ESCALA) || (numeroUsuario > POSICION_MAXIMA_ESCALA)) {
            System.out.println("Elección no válida. Inténtelo de nuevo.");
        } else {
            System.out.println("Ha elegido la nota " + NOTAS_ESCALA_COMPLETA[notaInicial]);

            String[] escalaMayor = calcularEscalaMayor(notaInicial);

            System.out.print("La escala de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " Mayor es: ");
            for (int i = 0; i < escalaMayor.length; i++) {
                System.out.print("[" + escalaMayor[i] + "] ");
            }
            System.out.println();
            System.out.println("El acorde de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " Mayor está conformado por: [" + escalaMayor[0] + "] / [" + escalaMayor[2] + "] / [" + escalaMayor[4] + "]");

        }

        scanner.close();
    }

    static String[] calcularEscalaMayor(int notaInicial) {
        final int TONO = 2, SEMITONO = 1;
        final int PATRON_ESCALA_MAYOR[] = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};
        final String NOTAS_ESCALA_COMPLETA[] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] escalaMayor = new String[8];
        int posicionNotaActual = notaInicial;
        for (int i = 0; i < 7; i++) {
            escalaMayor[i] = NOTAS_ESCALA_COMPLETA[posicionNotaActual];
            posicionNotaActual = (posicionNotaActual + PATRON_ESCALA_MAYOR[i]) % NOTAS_ESCALA_COMPLETA.length;
        }

        escalaMayor[7] = escalaMayor[0];

        return escalaMayor;
    }
}
