import java.util.Scanner;

class EscalaAcordes {
    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

    static final int TONO = 2, SEMITONO = 1;

    static final int[] MAYOR = { 0, TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
    static final int[] MENOR = { 0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] MENOR_NATURAL = { 0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] MENOR_ARMONICA = { 0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO + TONO / 2, SEMITONO };
    static final int[] MENOR_MELODICA = { 0, TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO };
    static final int[] PENTATONICA_MAYOR = { 0, TONO, TONO, TONO + SEMITONO, TONO, TONO + TONO / 2 };
    static final int[] PENTATONICA_MENOR = { 0, TONO + TONO / 2, TONO, TONO, TONO + TONO / 2, TONO };
    static final int[] DORICA = { 0, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO };
    static final int[] FRIGIA = { 0, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] LIDIA = { 0, TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO };
    static final int[] MIXOLIDIA = { 0, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO };
    static final int[] LOCRIA = { 0, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO };
    static final int[] POR_TONO = { 0, TONO, TONO, TONO, TONO, TONO, TONO };

    static final int[][] SALTOS = { MAYOR, MENOR, MENOR_NATURAL, MENOR_ARMONICA, MENOR_MELODICA,
            PENTATONICA_MAYOR,
            PENTATONICA_MENOR, DORICA, FRIGIA, LIDIA, MIXOLIDIA, LOCRIA, POR_TONO };

    public static void main(String[] args) {
        int nota = pedirNota();

        int[][] escalas = calcularEscalas(nota, SALTOS);

        int[] acorde = construirAcorde(escalas[0]);

        imprimirEscalas(escalas);
        imprimirSecuencia(acorde);
    }

    static void imprimirEscalas(int[][] escalas) {
        for (int i = 0; i < escalas.length; i++) {
            imprimirSecuencia(escalas[i]);
        }
    }

    static int[][] calcularEscalas(int nota, int[][] saltos) {
        int[][] escala = new int[SALTOS.length][];
        for (int i = 0; i < escala.length; i++) {
            escala[i] = construirEscala(nota, saltos[i]);
        }
        return escala;
    }

    static void imprimirSecuencia(int[] secuencia) {
        for (int i : secuencia) {
            System.out.print(NOTAS[i] + " ");
        }
        System.out.println();
    }

    static int pedirNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota inicial (1-12): ");
        int nota = scanner.nextInt()-1;
        scanner.close();
        return nota;
    }

    static int[] construirEscala(int nota, int[] saltos) {
        int[] escala = new int[saltos.length];
        escala[0] = nota;
        for (int i = 1; i < saltos.length; i++) {
            escala[i] = (escala[i-1] + saltos[i]) % NOTAS.length;
        }
        return escala;
    }

    static int[] construirAcorde(int[] escala) {
        final int[] SALTOS_ACORDE = { 0, 2, 4 };
        int[] acorde = new int[SALTOS_ACORDE.length];

        acorde[0] = escala[SALTOS_ACORDE[0]];
        acorde[1] = escala[SALTOS_ACORDE[1]];
        acorde[2] = escala[SALTOS_ACORDE[2]];
        
        return acorde;
    }
}