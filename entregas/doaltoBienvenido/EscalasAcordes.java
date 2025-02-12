package entregas.doaltoBienvenido;

import java.util.Scanner;

class EscalasAcordes {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
    static final int TONO = 2, SEMITONO = 1, TONOYMEDIO = 3;
    static final int[][] ESCALAS = 
    {
        { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO },
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO },
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO },
        { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO },
        { TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO },
        { TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO },
        { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO },
        { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO },
        { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO },
        { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO },
        { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO },
        { TONO, TONO, TONO, TONO, TONO, TONO }
    };
    static final String[] NOMBRE_ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };


    public static void main(String[] args) {

        String nota = preguntarNota();
        int[] escala = preguntarEscala();
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
        return new String[] { escalaMayor[0], escalaMayor[TONO], escalaMayor[4] };
    }

    static String[] construirEscalaMayor(String nota) {
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
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota() {
        System.out.println("Elige Nota -> 1:do, 2:do#, 3:re...");
        int nota = new Scanner(System.in).nextInt();
        return NOTAS[nota - 1];
        
    }
    static int[] preguntarEscala() {
        System.out.println("Elige Escala:");
        System.out.println("1: Mayor");
        System.out.println("2: Menor natural");
        System.out.println("3: Menor armónica");
        System.out.println("4: Menor melódica");
        System.out.println("5: Pentatónica mayor");
        System.out.println("6: Pentatónica menor");
        System.out.println("7: Dórica");
        System.out.println("8: Frigia");
        System.out.println("9: Lidia");
        System.out.println("10: Mixolidia");
        System.out.println("11: Locria");
        System.out.println("12: Por tonos");
        int escala = new Scanner(System.in).nextInt();
        return ESCALAS[escala - 1];
    }
}