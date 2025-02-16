import java.util.Scanner;

public class EscalaAcorde {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    private static final String[] NOMBRES_ESCALAS = {"Mayor", "Menor Natural", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por Tonos"};
    private static final int[][] PATRONES_ESCALAS = {
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

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Seleccione la nota base:");
            for (int i = 0; i < NOTAS.length; i++) {
                System.out.println((i + 1) + ": " + NOTAS[i]);
            }
            
            int opcion = scanner.nextInt() - 1;
            if (opcion < 0 || opcion >= NOTAS.length) {
                System.out.println("Opción no válida");
                return;
            }
            
            String notaBase = NOTAS[opcion];
            System.out.println("Nota seleccionada: " + notaBase);
            
            for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
                String[] escala = construirEscala(opcion, PATRONES_ESCALAS[i]);
                System.out.println("Escala " + NOMBRES_ESCALAS[i] + ": " + String.join(" / ", escala));
                System.out.println("Acorde: " + escala[0] + " / " + escala[2] + " / " + escala[4]);
            }
        }
    }

    private static String[] construirEscala(int indice, int[] patron) {
        String[] escala = new String[patron.length + 1];
        for (int i = 0; i < patron.length; i++) {
            escala[i] = NOTAS[indice % NOTAS.length];
            indice += patron[i];
        }
        escala[patron.length] = NOTAS[indice % NOTAS.length];
        return escala;
    }
}
