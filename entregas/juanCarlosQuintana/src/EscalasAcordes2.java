import java.util.Scanner;

class EscalasAcordes2 {

    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

    static final int SEMITONO = 1,
            TONO = 2 * SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;

    static final int[] MAYOR = {0, TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
            MENOR = {0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
            MENOR_NATURAL = {0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
            MENOR_ARMONICA = {0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO},
            MENOR_MELODICA = {0, TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
            PENTATONICA_MAYOR = {0, TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO},
            PENTATONICA_MENOR = {0, TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO},
            DORICA = {0, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
            FRIGIA = {0, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
            LIDIA = {0, TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
            MIXOLIDIA = {0, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
            LOCRIA = {0, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
            POR_TONO = {0, TONO, TONO, TONO, TONO, TONO, TONO};

    static final String[] NOMBRE_ESCALAS = {"Mayor", "Menor", "Menor natural", "Menor armónica", "Menor melódica",
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lídia", "Mixolidia", "Locria", "Por tono"};
    static final int[][] SALTOS = {MAYOR, MENOR, MENOR_NATURAL, MENOR_ARMONICA, MENOR_MELODICA,
        PENTATONICA_MAYOR, PENTATONICA_MENOR, DORICA, FRIGIA, LIDIA, MIXOLIDIA, LOCRIA, POR_TONO};

    static final int I = 0, III = 2, V = 4;
    static final int[] SALTOS_ACORDE = {I, III, V};

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int notaActiva = pedirNota();
        int escalaActiva = pedirEscala();

        int[] escala = construirEscala(notaActiva, SALTOS[escalaActiva]);

        int[] acorde = new int[SALTOS_ACORDE.length];
        construirAcorde(acorde, escala);

        imprimirSecuencia(escala);
        imprimirSecuencia(acorde);

        scanner.close();
    }

    static int pedirEscala() {
        imprimirSecuencia(NOMBRE_ESCALAS);
        System.out.print("Ingrese la nota inicial (1-" + NOMBRE_ESCALAS.length + "): ");
        int escala = scanner.nextInt() - 1;
        System.out.println();
        return escala;
    }

    static int pedirNota() {
        System.out.print("Ingrese la nota inicial (1-12): ");
        int nota = scanner.nextInt() - 1;
        System.out.println();
        return nota;
    }

    static int[] construirEscala(int nota, int[] saltos) {
        int[] escala = new int[saltos.length];
        escala[0] = nota;
        for (int i = 1; i < saltos.length; i++) {
            escala[i] = (escala[i - 1] + saltos[i]) % NOTAS.length;
        }
        return escala;
    }

    static void construirAcorde(int[] acorde, int[] escala) {
        for (int i = 0; i < acorde.length; i++) {
            acorde[i] = escala[SALTOS_ACORDE[i]];
        }
    }

    static void imprimirSecuencia(int[] secuencia) {
        for (int i : secuencia) {
            System.out.print(NOTAS[i] + " ");
        }
        System.out.println();
    }

    static void imprimirSecuencia(String[] secuencia) {
        final String SPACE = " ";
        for (int i = 0; i < secuencia.length; i++) {
            System.out.print(NOMBRE_ESCALAS[i] + SPACE);
        }
        System.out.println();
    }

}
