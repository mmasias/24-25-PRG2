import java.util.Scanner;

public class Main {
    static final  String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    static final  int[] INTERVALE_SCALE_MAJOR = {0, 2, 4, 5, 7, 9, 11};
    static final  int[] INTERVALE_ACORD_MAJOR = {0, 2, 4};
    static final  String NOTE = getNote();

    public static void main(String[] args) {
        String[] scaleMajor= getScale();
        String[] acord= getAcord(scaleMajor);

        showArray(scaleMajor);
        showArray(acord);
    }

    static String getNote() {
        showArray(NOTES);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a note: ");
        return scanner.nextLine();
    }

    static  int getStartNote() {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(NOTE)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    static  String[] getScale() {
        int startNote = getStartNote();
        String[] scale = new String[INTERVALE_SCALE_MAJOR.length];

        for (int i = 0; i < INTERVALE_SCALE_MAJOR.length; i++) {
            int noteIndex = (startNote + INTERVALE_SCALE_MAJOR[i]) % NOTES.length;
            scale[i] = NOTES[noteIndex];
        }
        return scale;
    }

    static  String[] getAcord(String[] scale) {
        String[] acord = new String[INTERVALE_ACORD_MAJOR.length];

        for (int i = 0; i < INTERVALE_ACORD_MAJOR.length; i++) {
            acord[i] = scale[INTERVALE_ACORD_MAJOR[i]];
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
        if (array.length == 12) {
            System.out.print("Selentect one note: ");
            for (String note : array) {
                System.out.print(note + " ");
            }
        }
        System.out.println();
    }
}
