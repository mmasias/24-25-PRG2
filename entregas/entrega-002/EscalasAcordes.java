package entregas;

import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
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

    static final String[] NOMBRES_ESCALAS = {
        "Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor",
        "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por Tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nota = preguntarNota(scanner);
        int opcionEscala = preguntarEscala(scanner);

        String[] escala = construirEscala(nota, ESCALAS[opcionEscala]);
        String[] acorde = construirAcorde(escala);

        System.out.println("Escala " + NOMBRES_ESCALAS[opcionEscala] + ":");
        mostrarSecuencia(escala);
        System.out.println("Acorde:");
        mostrarSecuencia(acorde);
    }

    static void mostrarSecuencia(String[] secuenciaNotas) {
        for (String nota : secuenciaNotas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    static String[] construirAcorde(String[] escala) {
        return new String[] { escala[0], escala[2], escala[4] };
    }

    static String[] construirEscala(String nota, int[] intervalos) {
        int posicionEnNotas = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length + 1];
        escala[0] = nota;

        for (int i = 0; i < intervalos.length; i++) {
            posicionEnNotas = (posicionEnNotas + intervalos[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[posicionEnNotas];
        }
        return escala;
    }

    static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota(Scanner scanner) {
        System.out.println("Elige una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        int notaIndex = scanner.nextInt() - 1;
        if (notaIndex < 0 || notaIndex >= NOTAS.length) {
            System.out.println("Opción no válida. Se seleccionará DO por defecto.");
            return NOTAS[0];
        }
        return NOTAS[notaIndex];
    }

    static int preguntarEscala(Scanner scanner) {
        System.out.println("Elige una escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }
        int escalaIndex = scanner.nextInt() - 1;
        if (escalaIndex < 0 || escalaIndex >= NOMBRES_ESCALAS.length) {
            System.out.println("Opción no válida. Se seleccionará la escala Mayor por defecto.");
            return 0;
        }
        return escalaIndex;
    }
}