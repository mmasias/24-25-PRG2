package entregas.masiasManuel.reto001;

import java.util.Scanner;

class EscalaAcorde {
    public static void main(String[] args) {

        String nota = preguntarNota();
        String[] escalaMayor = construirEscalaMayor(nota);
        String[] acorde = construirAcorde(escalaMayor);
        mostrarSecuencia(escalaMayor);
        mostrarSecuencia(acorde);
    }

    static void mostrarSecuencia(String[] secuenciaNotas) {
        for (int i = 0; i < secuenciaNotas.length; i++) {
            System.out.print("[" + secuenciaNotas[i] + "] ");
        }
        System.out.println();
    }

    static String[] construirAcorde(String[] escalaMayor) {
        return new String[] { escalaMayor[0], escalaMayor[2], escalaMayor[4] };
    }

    static String[] construirEscalaMayor(String nota) {
        final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        final int TONO = 2, SEMITONO = 1;
        final int[] intervalos = { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
        int posicionEnNotas = obtenerIndiceNota(nota);
        int posicionEscala = 0;
        final int NOTAS_ESCALA = 7;
        String[] escalaMayor = new String[NOTAS_ESCALA];

        do {
            escalaMayor[posicionEscala] = NOTAS[posicionEnNotas];
            posicionEnNotas = (posicionEnNotas + intervalos[posicionEscala]) % NOTAS.length;
            posicionEscala++;
        } while (posicionEscala < NOTAS_ESCALA);
        return escalaMayor;
    }

    static int obtenerIndiceNota(String nota) {
        final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota() {
        final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        System.out.println("Elige 1:do, 2:do#, 3:re...");
        int nota = new Scanner(System.in).nextInt();
        return new NOTAS[nota - 1];
    }
}
