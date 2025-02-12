import java.util.Scanner;

public class CalculoEscalaYAcordeMayor {
    static final String NOTAS_ESCALA_COMPLETA[] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int TONO = 2, SEMITONO = 1;
    static final int PATRON_ESCALA_MAYOR[] = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};
    static final int PATRON_ESCALA_MENOR[] = {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int notaInicial;
        String[] escalaMayor;

        imprimoPeticionUsuario();
        notaInicial = respuestaUsuario(scanner);

        if (notaInicial == -1) {
            System.out.println("Elección no válida. Inténtelo de nuevo.");
        } else {
            escalaMayor =  calcularEscala(notaInicial, PATRON_ESCALA_MAYOR);
            respuestaFinal(notaInicial, escalaMayor);
        }
        scanner.close();
    }

    static void imprimoPeticionUsuario() {
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
    }

    static int respuestaUsuario(Scanner scanner) {
        final int POSICION_MINIMA_ESCALA = 1, POSICION_MAXIMA_ESCALA = 12;
        final int notaInicial;
        int numeroUsuario = scanner.nextInt();
        if ((numeroUsuario < POSICION_MINIMA_ESCALA) || (numeroUsuario > POSICION_MAXIMA_ESCALA)) {
            return -1;
        } else {
            notaInicial = numeroUsuario - 1;
            return notaInicial;
        }
    }

    static String[] calcularEscala(int notaInicial, int[] patron) {
        String[] escala = new String[8];
        int posicionNotaActual = notaInicial;
        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS_ESCALA_COMPLETA[posicionNotaActual];
            posicionNotaActual = (posicionNotaActual + patron[i]) % NOTAS_ESCALA_COMPLETA.length;
        }
        escala[7] = escala[0];
        return escala;
    }
    
    static void respuestaFinal(int notaInicial, String[] escala) {
        System.out.println("Ha elegido la nota " + NOTAS_ESCALA_COMPLETA[notaInicial]);
        escala = calcularEscala(notaInicial, PATRON_ESCALA_MAYOR);
        System.out.print("La escala de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " Mayor es: ");
        System.out.print("La escala de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " Mayor es: ");
        for (int i = 0; i < escala.length; i++) {
            System.out.print("[" + escala[i] + "] ");
        }
        System.out.println();
        System.out.println("El acorde de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " Mayor está conformado por: [" + escala[0] + "] / [" + escala[2] + "] / [" + escala[4] + "]");
    }
}