import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        int[] arrayIntervaleMajor = {0, 2, 4, 5, 7, 9, 11};
        int[] arrayAcordMajor = {0, 2, 4};

        System.out.print("Enter a note: ");
        String inputNote = scanner.nextLine().toUpperCase();

        String[] arrayScale = getScale(arrayNotes, arrayIntervaleMajor, inputNote);
        if (arrayScale != null) {
            System.out.println("Major Scale for " + inputNote + ":");
            for (String note : arrayScale) {
                System.out.print(note + " ");
            }
            System.out.println("\n");
        }

        String[] arrayChord = getAcord(arrayScale, arrayAcordMajor);
        if (arrayChord != null) {
            System.out.println("Major Chord for " + inputNote + ":");
            for (String note : arrayChord) {
                System.out.print(note + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int getStartIndex(String[] arrayNotes, String inputNote) {
        for (int i = 0; i < arrayNotes.length; i++) {
            if (arrayNotes[i].equals(inputNote)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    public static String[] getScale(String[] arrayNotes, int[] arrayIntervaleMajor, String inputNote) {
        int startIndex = getStartIndex(arrayNotes, inputNote);
        if (startIndex == -1) {
            return null;
        }

        String[] arrayScale = new String[arrayIntervaleMajor.length];
        for (int i = 0; i < arrayIntervaleMajor.length; i++) {
            int noteIndex = (startIndex + arrayIntervaleMajor[i]) % arrayNotes.length;
            arrayScale[i] = arrayNotes[noteIndex];
        }
        return arrayScale;
    }

    public static String[] getAcord(String[] arrayScale, int[] arrayAcordMajor) {
        if (arrayScale == null) {
            return null;
        }

        String[] arrayChord = new String[arrayAcordMajor.length];
        for (int i = 0; i < arrayAcordMajor.length; i++) {
            arrayChord[i] = arrayScale[arrayAcordMajor[i]];
        }
        return arrayChord;
    }
}
