import java.util.Scanner;

public class escalaAcordes {
    public static void main(String[] args) {
        String[] notes = {"Do","Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        Scanner tc = new Scanner(System.in);
        System.out.println("Introduce la nota de la escala: ");
        String note = tc.nextLine();
        System.out.println("Nota: " + note);

        int startIndex = getNoteIndex(notes, note);

        if (startIndex == -1) {
            System.out.println("Nota no válida.");
        } else {
            int[] majorScalePattern = {2, 2, 1, 2, 2, 2, 1};
            int[] scaleIndices = generateMajorScale(notes, startIndex, majorScalePattern);
            printScale(notes, scaleIndices);
            printChords(notes, scaleIndices);
        }
    }

    public static int getNoteIndex(String[] notes, String note) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equalsIgnoreCase(note)) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateMajorScale(String[] notes, int startIndex, int[] pattern) {
        int[] scaleIndices = new int[pattern.length + 1];
        scaleIndices[0] = startIndex;
        for (int i = 0; i < pattern.length; i++) {
            startIndex = (startIndex + pattern[i]) % notes.length;
            scaleIndices[i + 1] = startIndex;
        }
        return scaleIndices;
    }

    public static void printScale(String[] notes, int[] scaleIndices) {
        System.out.print("Escala mayor: ");
        for (int index : scaleIndices) {
            System.out.print(notes[index] + " ");
        }
        
    }

    public static void printChords(String[] notes, int[] scaleIndices) {
        System.out.println("\nAcordes de la escala: ");
        int root = scaleIndices[0];
        int third = scaleIndices[2];
        int fifth = scaleIndices[4];
        System.out.println(notes[root] + " " + notes[third] + " " + notes[fifth]);
    }
}