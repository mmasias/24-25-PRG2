import java.util.Scanner;

class EscalaAcordes {
    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int TONO = 2, SEMITONO = 1;
    static final int[] SALTOS_MAYOR = { 0, TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
    static final int[] SALTOS_MENOR = { 0, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };

    static final int[] SALTOS_ACORDE = { 0, TONO, TONO};

    public static void main(String[] args) {
        int nota = pedirNota();

        int[] escala = new int[SALTOS_MAYOR.length];
        construirEscala(escala, nota, SALTOS_MAYOR);

        int[] acorde = new int[3];
        construirAcorde(acorde, escala, SALTOS_ACORDE);

        imprimirSecuencia(escala);
        imprimirSecuencia(acorde);
    }

    static void imprimirSecuencia(int[] secuencia) {
        for (int i : secuencia) {
            System.out.print(NOTAS[i] + " ");
        }
        System.out.println();
    }

    static void construirAcorde(int[] acorde, int[] escala, int[] saltos) {

        acorde[0] = escala[0];
        for (int i = 1; i < acorde.length; i++) {
            acorde[i] = (acorde[i-1] + saltos[i]) % NOTAS.length;
        }

    }

    static void construirEscala(int[] escala, int nota, int[] saltos) {
        escala[0] = nota;
        for (int i = 1; i < escala.length; i++) {
            escala[i] = (escala[i - 1] + saltos[i]) % NOTAS.length;
        }
    }

    static int pedirNota() {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué nota te gustaría elegir?");
        imprimirNotas(NOTAS);

        int nota = sc.nextInt()-1;
        System.out.println("Has elegido: " + NOTAS[nota]);

        return nota;
    }

    static void imprimirNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print((i+1) + ": [" + notas[i] + "]");
            System.out.print(" ");
        }
    }

}