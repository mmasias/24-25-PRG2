package entregas.caicedoEsteban.reto002;

import java.util.Scanner;

public class EscalasYAcordes {
    static final int CHORD_COUNT = 12;
    static final String[] CHORDS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int[] SCALES = { 2, 2, 1, 2, 2, 2, 1 };
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int baseScale = mostrarMenu();
        generarEscala(baseScale);

        scanner.close();
    }

    static int mostrarMenu() {
        System.out.println(
                "Elije la escala que quieres utilizar (0 = Do, 1 = Do#, 2 = Re , 3 = Re#, 4 = Mi, 5 = Fa, 6 = Fa#, 7 = Sol, 8 = Sol#, 9 = La, 10 = La# , 11 = Si): ");
        return scanner.nextInt();
    }

    static void generarEscala(int baseScale) {
        System.out.println("Escala seleccionada: " + CHORDS[baseScale]);
        System.out.print("Notas de la escala: " + CHORDS[baseScale]);

        int actualChord = baseScale;
        for (int nextChord : SCALES) {
            actualChord = (actualChord + nextChord) % CHORD_COUNT;
            System.out.print(" " + CHORDS[actualChord]);
        }
        System.out.println();
    }
}
