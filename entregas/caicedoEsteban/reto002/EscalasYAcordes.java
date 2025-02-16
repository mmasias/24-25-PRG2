package entregas.caicedoEsteban.reto002;

import java.util.Scanner;

public class EscalasYAcordes {
    static final int CHORD_COUNT = 12;
    static final String[] CHORDS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int SEMITONE = 1;
    static final int TONE = 2 * SEMITONE;
    static final int TONE_AND_A_HALF = TONE + SEMITONE;
    static final int[] SCALES = { TONE, TONE, SEMITONE, TONE, TONE, TONE, SEMITONE };
    static Scanner scanner = new Scanner(System.in);
    static final int[][] EXTRA_SCALES = {
            { TONE, TONE, SEMITONE, TONE, TONE, TONE, SEMITONE },
            { TONE, SEMITONE, TONE, TONE, SEMITONE, TONE, TONE },
            { TONE, SEMITONE, TONE, TONE, SEMITONE, TONE_AND_A_HALF, SEMITONE },
            { TONE, SEMITONE, TONE, TONE, TONE, TONE, SEMITONE },
            { TONE, TONE, TONE_AND_A_HALF, TONE, TONE_AND_A_HALF },
            { TONE_AND_A_HALF, TONE, TONE, TONE_AND_A_HALF, TONE },
            { TONE, SEMITONE, TONE, TONE, TONE, SEMITONE, TONE },
            { SEMITONE, TONE, TONE, TONE, SEMITONE, TONE, TONE },
            { TONE, TONE, TONE, SEMITONE, TONE, TONE, SEMITONE },
            { TONE, TONE, SEMITONE, TONE, TONE, SEMITONE, TONE },
            { SEMITONE, TONE, TONE, SEMITONE, TONE, TONE, TONE },
            { TONE, TONE, TONE, TONE, TONE, TONE }
    };
    static final String[] NAMES = {
            "Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor", "Dórica",
            "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {

        int baseScale = showMenu();
        generateScale(baseScale);
        selectionScale(EXTRA_SCALES, NAMES);

        scanner.close();
    }

    static void selectionScale(int[][] scales, String[] names) {
        System.out.println("Elije una escala adicional: ");
        for (int i = 0; i < scales.length; i++) {
            System.out.println(i + " = " + names[i]);
        }
        int selection = scanner.nextInt();
        System.out.println("Escala seleccionada: " + names[selection]);
        System.out.print("Notas de la escala: " + CHORDS[0]);

        int actualChord = 0;
        for (int nextChord : scales[selection]) {
            actualChord = (actualChord + nextChord) % CHORD_COUNT;
            System.out.print(" " + CHORDS[actualChord]);
        }
        System.out.println();
    }

    static int showMenu() {
        System.out.println(
                "Elije la escala que quieres utilizar (0 = Do, 1 = Do#, 2 = Re , 3 = Re#, 4 = Mi, 5 = Fa, 6 = Fa#, 7 = Sol, 8 = Sol#, 9 = La, 10 = La# , 11 = Si): ");
        return scanner.nextInt();
    }

    static void generateScale(int baseScale) {
        System.out.println("Escala seleccionada: " + CHORDS[baseScale]);
        System.out.print("Notas de la escala: " + CHORDS[baseScale]);

        int actualChord = baseScale;
        for (int nextChord : SCALES) {
            actualChord = (actualChord + nextChord) % CHORD_COUNT;
            System.out.print(" " + CHORDS[actualChord]);
        }
        System.out.println();
    }
}
