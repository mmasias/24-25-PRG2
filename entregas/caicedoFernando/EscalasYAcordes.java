package entregas.caicedoFernando;

import java.util.Arrays;
import java.util.Scanner;

class EscalasYAcordes {
    private static final String[] NOTES = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#",
            "Si" };
    private static final int SEMITONE = 1;
    private static final int TONE = 2 * SEMITONE;
    private static final int HALF_TONE = TONE + SEMITONE;
    private static final int[][] SCALES = {
            { TONE, TONE, SEMITONE, TONE, TONE, TONE, SEMITONE },
            { TONE, SEMITONE, TONE, TONE, SEMITONE, TONE, TONE },
            { TONE, SEMITONE, TONE, TONE, SEMITONE, HALF_TONE, SEMITONE },
            { TONE, SEMITONE, TONE, TONE, TONE, TONE, SEMITONE },
            { TONE, TONE, HALF_TONE, TONE, HALF_TONE },
            { HALF_TONE, TONE, TONE, HALF_TONE, TONE },
            { TONE, SEMITONE, TONE, TONE, TONE, SEMITONE, TONE },
            { SEMITONE, TONE, TONE, TONE, SEMITONE, TONE, TONE },
            { TONE, TONE, TONE, SEMITONE, TONE, TONE, SEMITONE },
            { TONE, TONE, SEMITONE, TONE, TONE, SEMITONE, TONE },
            { SEMITONE, TONE, TONE, SEMITONE, TONE, TONE, TONE },
            { TONE, TONE, TONE, TONE, TONE, TONE }
    };

    private static String[] SCALE_NAMES = {
            "Mayor",
            "Menor natural",
            "Menor Armónica",
            "Menor Melódica",
            "Pentatónica Mayor",
            "Pentatónica Menor",
            "Dórica",
            "Frigia",
            "Lidia",
            "Mixolidia",
            "Locria",
            "Por tonos"
    };

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese una de las escalas y acordes " + Arrays.toString(SCALE_NAMES));
        int scaleAndChordChoice = entry.nextInt();
        String scaleName = SCALE_NAMES[scaleAndChordChoice];
        System.out.println("Ingrese una de las notas " + Arrays.toString(NOTES));
        int noteChoice = entry.nextInt();
        String note = NOTES[noteChoice];
        printScaleAndChordChoice(scaleName, note, scaleAndChordChoice, noteChoice);

        entry.close();
    }

    static void printScaleAndChordChoice(String scaleName, String note, int scaleAndChordChoice, int noteChoice) {
        System.out.println("Ha elegido la nota " + note + " y la escala " + scaleName);
        System.out.print("La escala de " + note + " " + scaleName + " es: [");
        int[] scale = SCALES[scaleAndChordChoice];
        int noteIndex = noteChoice;
        for (int i = 0; i < scale.length; i++) {
            noteIndex = (noteIndex + scale[i]) % NOTES.length;
            System.out.print(NOTES[noteIndex]);
            if (i < scale.length - 1) {
                System.out.print("] / [");
            }
        }
        System.out.println("]");
        System.out.print("El acorde de " + note + " " + scaleName + " está conformado por: [");
        int[] chord = getChord(scaleAndChordChoice, noteChoice);
        for (int i = 0; i < chord.length; i++) {
            System.out.print(NOTES[chord[i]]);
            if (i < chord.length - 1) {
                System.out.print("] / [");
            }
        }
        System.out.println("]");
    }

    static int[] getChord(int scaleAndChordChoice, int noteChoice) {
        int[] scale = SCALES[scaleAndChordChoice];
        int noteIndex = noteChoice;
        int[] chord = new int[3];
        chord[0] = noteIndex;
        noteIndex = (noteIndex + scale[0]) % NOTES.length;
        chord[1] = noteIndex;
        noteIndex = (noteIndex + scale[2]) % NOTES.length;
        chord[2] = noteIndex;
        return chord;
    }
}