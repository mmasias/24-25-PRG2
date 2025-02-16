import java.util.Scanner;

public class NoteScale {
    public static void main(String[] args) {
        scaleMenu();
    }
    
    static void scaleMenu() {
        final int TONE = 2, SEMI_TONE = 1;
        final String[] MUSIC_SCALES = { "1. Mayor", "2. Menor natural", "3. Menor armónica", "4. Menor melódica", "5. Pentatónica mayor", "6. Pentatónica menor",
        "7. Dórica", "8. Frigia", "9. Lidia", "10. Mixolidia", "11. Locria", "12. Por tonos" };
        final int[][] TEMPOS = {{TONE, TONE, SEMI_TONE, TONE, TONE, TONE, SEMI_TONE }, { TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, TONE },
                { TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, (3 * SEMI_TONE), SEMI_TONE }, { TONE, SEMI_TONE, TONE, TONE, TONE, TONE, SEMI_TONE },
                { TONE, TONE, (3 * SEMI_TONE), TONE, (3 * SEMI_TONE) }, { (3 * SEMI_TONE), TONE, TONE, (3 * SEMI_TONE), TONE },
                { TONE, SEMI_TONE, TONE, TONE, TONE, SEMI_TONE, TONE }, { SEMI_TONE, TONE, TONE, TONE, SEMI_TONE, TONE, TONE },
                { TONE, TONE, TONE, SEMI_TONE, TONE, TONE, SEMI_TONE }, { TONE, TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE },
                { SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, TONE, TONE }, { TONE, TONE, TONE, TONE, TONE, TONE }};
       
        String[] twelveNoteMap = twelveNoteMap();

        for (String scale : MUSIC_SCALES) {
            System.out.println(scale);
        }

        System.out.print("Dime un numero y hare una escala: ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        scaleAndAcord(twelveNoteMap, TEMPOS[option - 1]);

        input.close();
    }

    static String[] twelveNoteMap() {
        final String[] NOTES = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        String[] twelveNoteMap = new String[12];

        System.out.println("Notas: Do, Do#, Re, Re#, Mi, Fa, Fa#, Sol, Sol#, La, La#, Si");
        System.out.print("Dime una nota con la cual quieras iniciar la escala: ");
        Scanner input = new Scanner(System.in);
        String keyNote = input.nextLine();

        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(keyNote)) {
                System.arraycopy(NOTES, i, twelveNoteMap, 0, NOTES.length - i);
            }
        }

        for (int i = 0; i < NOTES.length; i++) {
            if (twelveNoteMap[i] == null) {
                System.arraycopy(NOTES, 0, twelveNoteMap, i, NOTES.length - i);
            }
        }
        return twelveNoteMap;
    }

    static void scaleAndAcord(String[] upperScaleMap, int[] tempo) {
        int i = 0, j = 0;
        String[] acord = new String[7];
        
        do {
            System.out.print(upperScaleMap[i] + " ");
            acord[j] = upperScaleMap[i];
            i += tempo[j];
            j++;
        } while (i < upperScaleMap.length);
        System.out.println("\nEsta es la escala");

        for(int k = 0; k < 3; k++){
            System.out.print(acord[k] + " ");
        }
        System.out.println("\nEsta es el acorde");
    }
}