package entregas.arceMarina;

import java.util.Scanner;

public class EscalaAcordes {
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

    static final String MENSAJE_INGRESO_ESCALA = "Ingrese una escala a trabajar: 1: Mayor, 2: Menor, 3: Menor Armonica, 4: Menor Melodica, 5: Pentatonica Mayor, ...";
    static final String MENSAJE_INGRESO_NOTA = "Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int notaBase = obtenerNotaBase(scanner);
        int escalaDeseada = obtenerEscala(scanner);

        String notaSeleccionada = TONOS[notaBase - 1];
        int[] escalaSeleccionada = ESCALAS[escalaDeseada - 1];

        String[] escalaFinal = obtenerEscala(notaSeleccionada, escalaSeleccionada);
        imprimirNotaSeleccionada(notaSeleccionada);
        imprimirEscalaSeleccionada(escalaSeleccionada, notaSeleccionada, escalaDeseada, escalaFinal);
        obtenerYImprimirAcordeMayor(notaSeleccionada, escalaFinal);
    }

    private static int obtenerEscala(Scanner scanner) {
        System.out.print(MENSAJE_INGRESO_ESCALA);
        return scanner.nextInt();
    }

    private static void imprimirNotaSeleccionada(String notaSeleccionada) {
        System.out.println("La nota seleccionada es: " + notaSeleccionada);
    }

    private static int obtenerNotaBase(Scanner scanner) {
        System.out.print(MENSAJE_INGRESO_NOTA);
        return scanner.nextInt();
    }

    private static String[] obtenerEscala(String notaSeleccionada, int[] escalaSeleccionada) {
        int posicionNotaBase = obtenerPosicionNota(notaSeleccionada);

        String[] escala = new String[escalaSeleccionada.length];
        escala[0] = notaSeleccionada;

        for (int contadorNotas = 1; contadorNotas < escala.length; contadorNotas++) {
            posicionNotaBase = (posicionNotaBase + escalaSeleccionada[contadorNotas - 1]) % TONOS.length;
            escala[contadorNotas] = TONOS[posicionNotaBase];
        }

        return escala;
    }

    private static void imprimirEscalaSeleccionada(int[] escalaSeleccionada, String notaSeleccionada, int escalaDeseada,
            String[] escalaFinal) {
        final String[] NOMBRES_ESCALAS = { "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
                "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria",
                "Por tonos" };

        System.out.print("La escala [" + NOMBRES_ESCALAS[escalaDeseada - 1] + "] de [" + notaSeleccionada + "] es :");
        for (String nota : escalaFinal) {
            System.out.print(" [" + nota + "] / ");
        }
        System.out.println();
    }

    private static void obtenerYImprimirAcordeMayor(String notaBase, String[] escalaFinal) {
        String[] acorde = { escalaFinal[0], escalaFinal[2], escalaFinal[4] };

        System.out.print("Acorde de " + notaBase + " está conformado por:");
        for (String nota : acorde) {
            System.out.print(" [" + nota + "] / ");
        }
        System.out.println();
    }

    private static int obtenerPosicionNota(String notaSeleccionada) {
        for (int indiceNota = 0; indiceNota < TONOS.length; indiceNota++) {
            if (TONOS[indiceNota] == notaSeleccionada) {
                return indiceNota;
            }
        }
        return -1;
    }
}