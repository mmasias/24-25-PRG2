import java.util.Scanner;

class EscalaAcorde {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };

    static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;
    
    static final int[] INTERVALO_MAYOR = { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO };
    static final int[] INTERVALO_MENOR = { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] INTERVALO_MENOR_ARMONICA = { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO };
    static final int[] INTERVALO_MENOR_MELODICO = { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO };
    static final int[] INTERVALO_PENTATONICA_MAYOR = { TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO };
    static final int[] INTERVALO_PENTATONICA_MENOR = { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO };
    static final int[] INTERVALO_DORICA = { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO };
    static final int[] INTERVALO_FRIGIA = { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO };
    static final int[] INTERVALO_LIDIA = { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO };
    static final int[] INTERVALO_MIXOLIDIA = { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO };
    static final int[] INTERVALO_LOCRIA = { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO };
    static final int[] INTERVALO_POR_TONOS = { TONO, TONO, TONO, TONO, TONO, TONO };

    public static void main(String[] args) {

        String nota = preguntarNota();
        String[] escalaMayor = construirEscala(nota, INTERVALO_MAYOR);
        String[] acordeMayor = construirAcorde(escalaMayor);
        mostrarSecuencia(escalaMayor);
        mostrarSecuencia(acordeMayor);

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

    static String[] construirEscala(String nota, int[] ) {
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
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota() {
        System.out.println("Elige 1:do, 2:do#, 3:re...");
        int nota = new Scanner(System.in).nextInt();
        return NOTAS[nota - 1];
    }
}
