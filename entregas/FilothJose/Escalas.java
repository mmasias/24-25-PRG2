import java.util.Scanner;

public class EscalaMayor {

    private static final String[] NOTAS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final int SEMITONO = 1;
    private static final int TONO = 2;
    private static final int TONO_Y_MEDIO = 3;

    private static final int[][] PATRONES_ESCALAS = {
            {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
            {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO},
            {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO},
            {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, TONO, SEMITONO, TONO, SEMITONO, TONO, TONO},
            {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
            {TONO, TONO, TONO, TONO, TONO, TONO}
    };

    private static final String[] NOMBRES_ESCALAS = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }

        int opcionEscala = scanner.nextInt() - 1;

        System.out.println("Ingrese una la nota a trabajar: ");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }

        int opcionNota = scanner.nextInt() - 1;

        if (opcionEscala >= 0 && opcionEscala < NOMBRES_ESCALAS.length && opcionNota >= 0 && opcionNota < NOTAS.length) {
            String notaSeleccionada = NOTAS[opcionNota];
            System.out.println("Ha elegido la nota " + notaSeleccionada + " y la escala " + NOMBRES_ESCALAS[opcionEscala]);

            String[] escala = new String[8];
            construirEscala(notaSeleccionada, PATRONES_ESCALAS[opcionEscala], escala);
            System.out.print("La escala de " + notaSeleccionada + " " + NOMBRES_ESCALAS[opcionEscala] + " es: ");
            imprimirArray(escala);

            String[] acorde = new String[3];
            construirAcorde(escala, acorde);
            System.out.print("El acorde de " + notaSeleccionada + " " + NOMBRES_ESCALAS[opcionEscala] + " está conformado por: ");
            imprimirArray(acorde);
        } else {
            System.out.println("Opción no válida. Por favor, seleccione un número válido.");
        }

        scanner.close();
    }

    private static void construirEscala(String notaBase, int[] patron, String[] escala) {
        int indice = -1;
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equals(notaBase)) {
                indice = i;
            }
        }

        escala[0] = notaBase;

        for (int i = 0; i < patron.length; i++) {
            indice = (indice + patron[i]) % NOTAS.length;
            escala[i