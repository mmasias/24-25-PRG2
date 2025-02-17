
import java.util.Scanner;

public class ScaleChord {

    static Scanner scanner = new Scanner(System.in);

    static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    static final int SEMI_TONE = 1, TONE = 2 * SEMI_TONE, TONE_AND_HALF = TONE + SEMI_TONE;

    static final int[] INTERVALE_SCALE_MAJOR = {TONE, TONE, SEMI_TONE, TONE, TONE, TONE, SEMI_TONE};
    static final int[] INTERVALE_ELDER = {TONE, SEMI_TONE, TONE, SEMI_TONE, TONE, TONE, SEMI_TONE};
    static final int[] INTERVALE_NATURAL_MINOR = {TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, TONE};
    static final int[] INTERVALE_HARMONIC_MINOR = {TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE_AND_HALF, SEMI_TONE};
    static final int[] INTERVALE_MELODIC_MINOR = {TONE, SEMI_TONE, TONE, TONE, TONE, TONE, SEMI_TONE};
    static final int[] INTERVALE_MAJOR_PENTATONIC = {TONE, TONE, TONE_AND_HALF, TONE, TONE_AND_HALF};
    static final int[] INTERVALE_PENTATONIC_MINOR = {TONE_AND_HALF, TONE, TONE, TONE_AND_HALF, TONE};
    static final int[] INTERVALE_DORIC = {TONE, SEMI_TONE, TONE, TONE, TONE, SEMI_TONE, TONE};
    static final int[] INTERVALE_PHRYGIA = {SEMI_TONE, TONE, TONE, TONE, SEMI_TONE, TONE, TONE};
    static final int[] INTERVALE_BULLFIGHT = {TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, SEMI_TONE};
    static final int[] INTERVALE_MIXOLYDIA = {TONE, TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE};
    static final int[] INTERVALE_LOCRIA = {SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, TONE, TONE};
    static final int[] INTERVALE_BY_TONE = {TONE, TONE, TONE, TONE, TONE, TONE};

    static final int[][] ALL_SCALES = {
        INTERVALE_SCALE_MAJOR, INTERVALE_ELDER, INTERVALE_NATURAL_MINOR, INTERVALE_HARMONIC_MINOR,
        INTERVALE_MELODIC_MINOR, INTERVALE_MAJOR_PENTATONIC, INTERVALE_PENTATONIC_MINOR,
        INTERVALE_DORIC, INTERVALE_PHRYGIA, INTERVALE_BULLFIGHT, INTERVALE_MIXOLYDIA,
        INTERVALE_LOCRIA, INTERVALE_BY_TONE
    };

    static final String[] SCALE_NAMES = {
        "Major", "Elder", "Natural Minor", "Harmonic Minor", "Melodic Minor",
        "Major Pentatonic", "Pentatonic Minor", "Doric", "Phrygia", "Bullfight",
        "Mixolydia", "Locria", "By Tone"
    };

    static final int I = 0, III = 2, V = 4;
    static final int[] INTERVALE_CHORD = {I, III, V};

    public static void main(String[] args) {
        int choicedScale = askScale();
        String choicedNote = askNote();

        int[] selectedScale = ALL_SCALES[choicedScale - 1];

        String[] scale = getScale(choicedNote, selectedScale);
        String[] chord = getChord(scale);

        showIntervals("Scale", scale);
        showIntervals("Chord", chord);

        scanner.close();
    }

    static String askNote() {
        showIntervals("Notes: ", NOTES);

        System.out.print("Enter a starting note: ");
        String note = scanner.nextLine();

        return note;
    }

    static int askScale() {
        showIntervals("Available Scales:", SCALE_NAMES);

        System.out.print("Select a scale (1-13): ");
        int scale = scanner.nextInt();
        scanner.nextLine();

        return scale;
    }

    static int getStartNote(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equalsIgnoreCase(note)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    static String[] getScale(String note, int[] intervals) {
        int startNote = getStartNote(note);
        if (startNote == -1) {
            return new String[0];
        }

        String[] scale = new String[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            scale[i] = NOTES[startNote % NOTES.length];
            startNote += intervals[i];
        }

        return scale;
    }

    static String[] getChord(String[] scale) {
        String[] chord = new String[INTERVALE_CHORD.length];

        for (int i = 0; i < INTERVALE_CHORD.length; i++) {
            chord[i] = scale[INTERVALE_CHORD[i]];
        }

        return chord;
    }

    static void showIntervals(String label, String[] intervals) {
        if (intervals.length == SCALE_NAMES.length) {
            for (int i = 0; i < SCALE_NAMES.length; i++) {
                System.out.println((i + 1) + ". " + SCALE_NAMES[i]);
            }
        } else {
            System.out.print(label + ": ");

            for (String item : intervals) {
                System.out.print(item + " ");
            }

            System.out.println();
        }
    }
}
