import java.util.Scanner;

public class Main {

    static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    static final int TONE = 2;
    static final int SEMI_TONE = 1;
    static final int TONE_AND_HALF = 3;

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
    static final int[] INTERVALE_ACORD = {0, 2, 4};

    static final String[] SCALE_NAMES = {
        "Major", "Elder", "Natural Minor", "Harmonic Minor", "Melodic Minor", 
        "Major Pentatonic", "Pentatonic Minor", "Doric", "Phrygia", "Bullfight", 
        "Mixolydia", "Locria", "By Tone"
    };

    static final int[][] ALL_SCALES = {
        INTERVALE_SCALE_MAJOR, INTERVALE_ELDER, INTERVALE_NATURAL_MINOR, INTERVALE_HARMONIC_MINOR, 
        INTERVALE_MELODIC_MINOR, INTERVALE_MAJOR_PENTATONIC, INTERVALE_PENTATONIC_MINOR, 
        INTERVALE_DORIC, INTERVALE_PHRYGIA, INTERVALE_BULLFIGHT, INTERVALE_MIXOLYDIA, 
        INTERVALE_LOCRIA, INTERVALE_BY_TONE
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showMenu();
        int scaleChoice = getIntInput("Select a scale (1-13): ", scanner, 1, SCALE_NAMES.length);
        String inputNote = getInput("Enter a starting note: ", scanner);

        int[] selectedScale = ALL_SCALES[scaleChoice - 1];
        String[] scale = getScale(inputNote, selectedScale);
        String[] acord = getAcord(scale);

        showArray("Scale", scale);
        showArray("Acord", acord);

        scanner.close();
    }

    static void showMenu() {
        System.out.println("Available Scales:");
        for (int i = 0; i < SCALE_NAMES.length; i++) {
            System.out.println((i + 1) + ". " + SCALE_NAMES[i]);
        }
    }

    static String getInput(String message, Scanner scanner) {
        showArray("Notes", NOTES);
        System.out.print(message);
        return scanner.nextLine();
    }

    static int getIntInput(String message, Scanner scanner, int min, int max) {
        int value;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            value = scanner.nextInt();
            scanner.nextLine();
        } while (value < min || value > max);
        return value;
    }

    static int getStartNote(String inputNote) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equalsIgnoreCase(inputNote)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    static String[] getScale(String inputNote, int[] intervals) {
        int startNote = getStartNote(inputNote);
        if (startNote == -1) return new String[0];

        String[] scale = new String[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            scale[i] = NOTES[startNote % NOTES.length];
            startNote += intervals[i];
        }
        return scale;
    }

    static String[] getAcord(String[] scale) {
        String[] acord = new String[INTERVALE_ACORD.length];
        for (int i = 0; i < INTERVALE_ACORD.length; i++) {
            acord[i] = scale[INTERVALE_ACORD[i]];
        }
        return acord;
    }

    static void showArray(String label, String[] array) {
        System.out.print(label + ": ");
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
