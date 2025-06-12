import java.util.Scanner;

public class EscalasYAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CHORD_COUNT = 12;

        System.out.println("Escalas y Acordes");
        final String[] CHORDS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        final int[] SCALES = { 2, 2, 1, 2, 2, 2, 1 };

        System.out.println(
                "Elije la escala que quieres utilizar (0 = Do, 1 = Do#, 2 = Re , 3 = Re#, 4 = Mi, 5 = Fa, 6 = Fa#, 7 = Sol, 8 = Sol#, 9 = La, 10 = La# , 11 = Si): ");
        int baseScale = scanner.nextInt();

        System.out.println("Escala seleccionada: " + CHORDS[baseScale]);
        System.out.print("Notas de la escala: " + CHORDS[baseScale]);

        int actualChord = baseScale;
        for (int nextChord = 0; nextChord < SCALES.length; nextChord++) {
            actualChord = (actualChord + SCALES[nextChord]) % CHORD_COUNT;
            System.out.print(" " + CHORDS[actualChord]);
        }
        System.out.println();
        scanner.close();
    }
}


