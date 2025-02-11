import java.util.Scanner;

class EscalaAcordes {
    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int TONO = 2, SEMITONO = 1;
    static final int[] SALTOS_MAYOR = { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
    static final int[] SALTOS_MENOR = { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };

    public static void main(String[] args) {
        int nota = pedirNota();

        int[] escala = construirEscala(nota, SALTOS_MAYOR);
        int[] acorde = construirAcorde(nota, acorde);

        imprimirSecuencia(escala);
        imprimirSecuencia(acorde);
    }

    static int[] construirEscala(int nota, int[] saltosMayor) {
        for (int i = 0; i < saltosMayor.length; i++) {
            
        }
    }

    static int pedirNota() {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué nota te gustaría elegir?");
        imprimirNotas(NOTAS);

        int nota = sc.nextInt();
        System.out.println("Has elegido: " + NOTAS[nota]);

        return nota;
    }

    static void imprimirNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.println(i + ": [" + notas + "]");
            System.out.println(" ");
        }
    }

}