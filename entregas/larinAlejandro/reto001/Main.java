import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        int[] intervaleScaleMajor = {0, 2, 4, 5, 7, 9, 11};
        int[] intervaleAcordMajor = {0, 2, 4};
        

        String note= getNote(notes);

        String[] scale= getScale(notes, intervaleScaleMajor, note);
        String[] acord= getAcord(scale, intervaleAcordMajor);

        
        showArray(scale);
        showArray(acord);

    }

    static String getNote(String[] notes) {
        showArray(notes);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a note: ");
        return scanner.nextLine();
    }

    static  int getStartNote(String[] notes, String inputNote) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(inputNote)) {
                return i;
            }
        }
        System.err.println("Note not found.");
        return -1;
    }

    static  String[] getScale(String[] notes, int[] intervaleScaleMajor, String inputNote) {
        int startNote = getStartNote(notes, inputNote);
        String[] scale = new String[intervaleScaleMajor.length];

        for (int i = 0; i < intervaleScaleMajor.length; i++) {
            int noteIndex = (startNote + intervaleScaleMajor[i]) % notes.length;
            scale[i] = notes[noteIndex];
        }
        return scale;
    }

    static  String[] getAcord(String[] scale, int[] intervaleAcordMajor) {
        String[] acord = new String[intervaleAcordMajor.length];

        for (int i = 0; i < intervaleAcordMajor.length; i++) {
            acord[i] = scale[intervaleAcordMajor[i]];
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
