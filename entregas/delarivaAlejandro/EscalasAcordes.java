import java.util.Scanner;

class EscalasyAcordes {

    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

    static final int TONO = 2, SEMITONO = 1;

    static final int[] ESCALA_MAYOR = { 0, TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
    static final int[] ESCALA_MENOR = { 0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] PENTATONICA_MAYOR = { 0, TONO, TONO, TONO + SEMITONO, TONO, TONO + TONO / 2 };
    static final int[] PENTATONICA_MENOR = { 0, TONO + TONO / 2, TONO, TONO, TONO + TONO / 2, TONO };
    static final int[] ESCALA_DORICA = { 0, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO };
    static final int[] ESCALA_FRIGIA = { 0, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] ESCALA_LIDIA = { 0, TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO };
    static final int[] ESCALA_MIXOLIDIA = { 0, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO };
    static final int[] ESCALA_LOCRIA = { 0, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO };
    static final int[] ESCALA_POR_TONOS = { 0, TONO, TONO, TONO, TONO, TONO, TONO };

    static final int[][] MODOS = {
            ESCALA_MAYOR, ESCALA_MENOR, PENTATONICA_MAYOR,
            PENTATONICA_MENOR, ESCALA_DORICA, ESCALA_FRIGIA,
            ESCALA_LIDIA, ESCALA_MIXOLIDIA, ESCALA_LOCRIA, ESCALA_POR_TONOS
    };

    public static void main(String[] args) {
        int notaBase = obtenerNotaBase();
        int[][] escalasGeneradas = generarEscalas(notaBase, MODOS);
        int[] acordeGenerado = generarAcorde(escalasGeneradas[0]);

        mostrarEscalas(escalasGeneradas);
        mostrarAcorde(acordeGenerado);
    }

    static int obtenerNotaBase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese la nota inicial (1-12): ");
        int nota = scanner.nextInt() - 1;
        scanner.close();
        return nota;
    }

    static int[][] generarEscalas(int notaBase, int[][] modos) {
        int[][] escalas = new int[modos.length][];
        for (int i = 0; i < modos.length; i++) {
            escalas[i] = construirEscala(notaBase, modos[i]);
        }
        return escalas;
    }

    static int[] construirEscala(int notaBase, int[] saltos) {
        int[] escala = new int[saltos.length];
        escala[0] = notaBase;
        for (int i = 1; i < saltos.length; i++) {
            escala[i] = (escala[i - 1] + saltos[i]) % NOTAS.length;
        }
        return escala;
    }

    static int[] generarAcorde(int[] escala) {
        final int[] INTERVALOS_ACORDE = { 0, 2, 4 };
        int[] acorde = new int[INTERVALOS_ACORDE.length];
        for (int i = 0; i < INTERVALOS_ACORDE.length; i++) {
            acorde[i] = escala[INTERVALOS_ACORDE[i]];
        }
        return acorde;
    }

    static void mostrarEscalas(int[][] escalas) {
        for (int[] escala : escalas) {
            mostrarSecuencia(escala);
        }
    }

    static void mostrarSecuencia(int[] secuencia) {
        for (int nota : secuencia) {
            System.out.print(NOTAS[nota] + " ");
        }
        System.out.println();
    }

    static void mostrarAcorde(int[] acorde) {
        mostrarSecuencia(acorde);
    }
}