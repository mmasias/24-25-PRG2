import java.util.Scanner;

public class EscalasAcordes {
    static final String[] TONOS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };
    static final int SEMITONO = 1;
    static final int TONO = 2 * SEMITONO;
    static final int TONO_Y_MEDIO = TONO + SEMITONO;

    static final int[][] ESCALAS = {
            { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO },
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO },
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO },
            { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO },
            { TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO },
            { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO },
            { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO },
            { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO },
            { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO },
            { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO },
            { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO },
            { TONO, TONO, TONO, TONO, TONO, TONO }
    };

    public static void main(String[] args) {
        int notaBase = obtenerNotaBase();
        int escalaDeseada = obtenerEscala();

        String notaSeleccionada = TONOS[notaBase - 1];
        int escalaSeleccionada[] = ESCALAS[escalaDeseada - 1];

        String[] escalaFinal = obtenerEscala(notaSeleccionada, escalaSeleccionada);
        imprimirNotaSeleccionada(notaSeleccionada);
        imprimirEscalaSeleccionada(escalaSeleccionada, notaSeleccionada, escalaDeseada, escalaFinal);
        obtenerAndImprimirAcordeMayor(notaSeleccionada, escalaFinal);
    }

    private static int obtenerEscala() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Ingrese una escala a trabajar: 1: Mayor, 2: Menor, 3: Menor Armonica, 4: Menor Melodica, 5: Pentatonica Mayor, ...");
        System.out.println();
        int escalaSeleccionada = scanner.nextInt();
        return (escalaSeleccionada);
    }

    private static void imprimirNotaSeleccionada(String notaSeleccionada) {
        System.out.println("La nota seleccionada es: " + notaSeleccionada);
    }

    private static int obtenerNotaBase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");
        System.out.println();
        int notaBase = scanner.nextInt();
        return (notaBase);
    }

    private static String[] obtenerEscala(String notaSeleccionada, int[] escalaSeleccionada) {
        int[] intervaloActual = escalaSeleccionada;
        int posicionNotaBase = -1;
        int posicionActual = 0;
        int contadorNotas = 1;

        String[] escala = new String[escalaSeleccionada.length];
        escala[0] = notaSeleccionada;

        while (posicionActual < TONOS.length) {
            if (TONOS[posicionActual] == notaSeleccionada) {
                posicionNotaBase = posicionActual;
            }
            posicionActual++;
        }

        while (contadorNotas < escala.length) {
            posicionNotaBase = (posicionNotaBase + intervaloActual[contadorNotas - 1]) % TONOS.length;
            escala[contadorNotas] = TONOS[posicionNotaBase];
            contadorNotas++;
        }

        return escala;

    }

    private static void imprimirEscalaSeleccionada(int[] escalaSeleccionada, String notaSeleccionada, int escalaDeseada,
            String[] escalaFinal) {
        final String[] NOMBRES_ESCALAS = { "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
                "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria",
                "Por tonos" };

        int variableImprimir = 0;
        System.out.print("La escala [" + NOMBRES_ESCALAS[escalaDeseada - 1] + "] de [" + notaSeleccionada + "] es :");
        while (variableImprimir < escalaSeleccionada.length) {
            System.out.print(" [" + escalaFinal[variableImprimir] + "] / ");
            variableImprimir++;
        }
        System.out.println();
    }

    private static String[] obtenerAndImprimirAcordeMayor(String notaBase, String[] escalaFinal) {
        String[] acorde = new String[3];
        int variableImprimir = 0;

        acorde[0] = escalaFinal[0];
        acorde[1] = escalaFinal[2];
        acorde[2] = escalaFinal[4];

        System.out.print("Acorde de " + notaBase + " esta conformado por:");
        for (variableImprimir = 0; variableImprimir < acorde.length; variableImprimir++) {
            System.out.print(" [" + acorde[variableImprimir] + "] / ");
        }
        System.out.println();

        return acorde;
    }
}