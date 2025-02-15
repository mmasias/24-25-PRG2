import java.util.Scanner;

public class EscalaYAcorde {
    static final String NOTAS_ESCALA_COMPLETA[] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_MEDIO = SEMITONO + TONO;

    static final int PATRON_ESCALA_MAYOR[] = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};
    static final int PATRON_ESCALA_MENOR_NATURAL[] = {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO};
    static final int PATRON_ESCALA_MENOR_ARMONICA[] = {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO};
    static final int PATRON_ESCALA_MENOR_MELODICA[] = {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO};
    static final int PATRON_PENTATONICA_MAYOR[] = {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO};
    static final int PATRON_PENTATONICA_MENOR[] = {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO,TONO};
    static final int PATRON_DORICA[] = {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO};
    static final int PATRON_FRIGIA[] = {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO};
    static final int PATRON_LIDIA[] = {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO};
    static final int PATRON_MIXOLIDIA[] = {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO};
    static final int PATRON_LOCRIA[] = {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO};
    static final int PATRON_POR_TONOS[] = {TONO, TONO, TONO, TONO, TONO, TONO};
    
    static final String[] ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    static final int[][] PATRONES = {
        PATRON_ESCALA_MAYOR, PATRON_ESCALA_MENOR_NATURAL, PATRON_ESCALA_MENOR_ARMONICA, PATRON_ESCALA_MENOR_MELODICA, PATRON_PENTATONICA_MAYOR,
        PATRON_PENTATONICA_MENOR, PATRON_DORICA, PATRON_FRIGIA, PATRON_LIDIA, PATRON_MIXOLIDIA, PATRON_LOCRIA, PATRON_POR_TONOS
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int notaInicial;
        String[] escalaMayor;

        imprimoPeticionNotaUsuario();
        notaInicial = notaUsuario(scanner);

        imprimoPeticionEscalaUsuario();

        if (notaInicial == -1) {
            System.out.println("Elección no válida. Inténtelo de nuevo.");
        } else {
            escalaMayor =  calcularEscala(notaInicial, PATRON_ESCALA_MAYOR);
            respuestaFinal(notaInicial, escalaMayor);
        }
        scanner.close();
    }

    static void imprimoPeticionNotaUsuario() {
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
    }

    static void imprimoPeticionEscalaUsuario() {
        System.out.println("");
    }

    static int notaUsuario(Scanner scanner) {
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

    static int escalaUsuario(Scanner scanner) {
        
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