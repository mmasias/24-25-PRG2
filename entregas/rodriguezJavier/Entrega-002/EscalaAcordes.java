import java.util.Scanner;

public class EscalaAcordes {
    private static final String[] NOTES = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[][] SCALE_PATTERNS = {
        {2, 2, 1, 2, 2, 2, 1},
        {2, 1, 2, 2, 1, 2, 2},
        {2, 1, 2, 2, 1, 3, 1},
        {2, 1, 2, 2, 2, 2, 1},
        {2, 2, 3, 2, 3},
        {3, 2, 2, 3, 2},
        {2, 1, 2, 2, 2, 1, 2},
        {1, 2, 2, 2, 1, 2, 2},
        {2, 2, 2, 1, 2, 2, 1},
        {2, 2, 1, 2, 2, 1, 2},
        {1, 2, 2, 1, 2, 2, 2},
        {2, 2, 2, 2, 2, 2}
    };
    private static final String[] SCALE_NAMES = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la nota de la escala: ");
        String note = scanner.nextLine();

        System.out.println("Selecciona el tipo de escala:");
        for (int i = 0; i < SCALE_NAMES.length; i++) {
            System.out.println((i + 1) + ". " + SCALE_NAMES[i]);
        }
        int scaleChoice = scanner.nextInt();
        scanner.close();

        int startIndex = getNoteIndex(note);
        if (startIndex == -1) {
            System.out.println("Nota no válida.");
        } else if (scaleChoice < 1 || scaleChoice > SCALE_PATTERNS.length) {
            System.out.println("Selección de escala no válida.");
        } else {
            int[] scaleIndices = generateScale(startIndex, SCALE_PATTERNS[scaleChoice - 1]);
            printScale(scaleIndices, SCALE_NAMES[scaleChoice - 1]);
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

    private static int[] generateScale(int startIndex, int[] pattern) {
        int[] scaleIndices = new int[pattern.length + 1];
        scaleIndices[0] = startIndex;
        for (int i = 0; i < pattern.length; i++) {
            startIndex = (startIndex + pattern[i]) % NOTES.length;
            scaleIndices[i + 1] = startIndex;
        }
        return scaleIndices;
    }

    private static void printScale(int[] scaleIndices, String scaleName) {
        System.out.print("Escala " + scaleName + ": ");
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