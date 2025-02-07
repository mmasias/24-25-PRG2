import java.util.Scanner;

public class EscalaAcordes {
    private static final String[] NOTES = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[] MAJOR_SCALE_PATTERN = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la nota de la escala: ");
        String note = scanner.nextLine();
        scanner.close();

        int startIndex = getNoteIndex(note);
        if (startIndex == -1) {
            System.out.println("Nota no válida.");
        } else {
            int[] scaleIndices = generateMajorScale(startIndex);
            printScale(scaleIndices);
            printChords(scaleIndices);
        }
    }

    private static int getNoteIndex(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equalsIgnoreCase(note)) {
                return i;
            }
        }
        return -1;
    }

    private static int[] generateMajorScale(int startIndex) {
        int[] scaleIndices = new int[MAJOR_SCALE_PATTERN.length + 1];
        scaleIndices[0] = startIndex;
        for (int i = 0; i < MAJOR_SCALE_PATTERN.length; i++) {
            startIndex = (startIndex + MAJOR_SCALE_PATTERN[i]) % NOTES.length;
            scaleIndices[i + 1] = startIndex;
        }
        return scaleIndices;
    }

    private static void printScale(int[] scaleIndices) {
        System.out.print("Escala mayor: ");
        for (int index : scaleIndices) {
            System.out.print(NOTES[index] + " ");
        }
        System.out.println();
    }

    private static void printChords(int[] scaleIndices) {
        System.out.println("Acordes de la escala: ");
        for (int i = 0; i < scaleIndices.length; i++) {
            int root = scaleIndices[i];
            int third = scaleIndices[(i + 2) % scaleIndices.length];
            int fifth = scaleIndices[(i + 4) % scaleIndices.length];
            System.out.println(NOTES[root] + " " + NOTES[third] + " " + NOTES[fifth]);
        }
    }
}