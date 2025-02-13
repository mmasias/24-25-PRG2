
import java.util.Scanner;

public class Main {

    static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    static final int TONE = 2;
    static final int SEMI_TONE = 1;
    static final int[] INTERVALE_SCALE_MAJOR = {TONE, TONE, SEMI_TONE, TONE, TONE, TONE, SEMI_TONE};
    static final int[] INTERVALE_ACORD = {0, 2, 4};

    public static void main(String[] args) {
        String inputNote = getNote();

        String[] scaleMajor = getScale(inputNote, INTERVALE_SCALE_MAJOR);
        String[] acord = getAcord(scaleMajor);

        showArray(scaleMajor);
        showArray(acord);
    }

    static String getNote() {
        showArray(NOTES);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a note: ");
        return scanner.nextLine();
    }

    static int getStartNote(String inputNote) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(inputNote)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    static String[] getScale(String inputNote, int[] intervals) {
        int startNote = getStartNote(inputNote);
        String[] scale = new String[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int noteIndex = startNote % NOTES.length;
            scale[i] = NOTES[noteIndex];
            if (i < intervals.length) {
                startNote += intervals[i];
            }
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

    static void showArray(String[] array) {
        if (array.length == 3) {
            System.out.print("Acord: ");
            for (String note : array) {
                System.out.print(note + " ");
            }
        }
        if (array.length == 7) {
            System.out.print("Scale: ");
            for (String note : array) {
                System.out.print(note + " ");
            }
        }
        else{
            System.out.print("Selentect one note: ");
            for (String note : array) {
                System.out.print(note + " ");
            }
        }
        System.out.println();
    }
}
