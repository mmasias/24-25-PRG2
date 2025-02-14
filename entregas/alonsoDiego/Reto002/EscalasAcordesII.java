package entregas.alonsoDiego.Reto002;
import java.util.Scanner;
public class EscalasAcordesII {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final String[] NOMBRES_ESCALAS = {
        "Mayor", "Menor Natural", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor",
        "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por Tonos"
    };
    private static final int[][] ESCALAS = {
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
    private static final int[] INDICES_ACORDE = {0, 2, 4};
    private static final int OPCION_MINIMA = 1;
    private static final int OPCION_MAXIMA = NOTAS.length;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        System.out.print("Opción: ");
        int seleccion = scanner.nextInt();
        if (seleccion < OPCION_MINIMA || seleccion > OPCION_MAXIMA) {
            System.out.println("Opción inválida.");
            scanner.close();
            return;
        }
        int indiceNotaBase = seleccion - 1;
        
        System.out.println("Seleccione la escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }
        System.out.print("Opción: ");
        int seleccionEscala = scanner.nextInt();
        if (seleccionEscala < 1 || seleccionEscala > NOMBRES_ESCALAS.length) {
            System.out.println("Opción inválida.");
            scanner.close();
            return;
        }
        
        String nombreEscala = NOMBRES_ESCALAS[seleccionEscala - 1];
        int[] intervalosEscala = ESCALAS[seleccionEscala - 1];
        
        String[] escala = generarEscala(indiceNotaBase, intervalosEscala);
        imprimirEscala(nombreEscala, NOTAS[indiceNotaBase], escala);
        imprimirAcorde(NOTAS[indiceNotaBase], escala);
        
        scanner.close();
    }
    
    private static String[] generarEscala(int indiceBase, int[] intervalos) {
        String[] escala = new String[intervalos.length + 1];
        escala[0] = NOTAS[indiceBase];
        int indiceActual = indiceBase;
        for (int i = 0; i < intervalos.length; i++) {
            indiceActual = (indiceActual + intervalos[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[indiceActual];
        }
        return escala;
    }
    
    private static void imprimirEscala(String nombre, String notaBase, String[] escala) {
        System.out.print("La escala de " + notaBase + " " + nombre + " es: ");
        for (int i = 0; i < escala.length; i++) {
            System.out.print("[" + escala[i] + "]");
            if (i < escala.length - 1) System.out.print(" / ");
        }
        System.out.println();
    }
    
    private static void imprimirAcorde(String notaBase, String[] escala) {
        System.out.print("El acorde de " + notaBase + " está conformado por: ");
        for (int i = 0; i < INDICES_ACORDE.length; i++) {
            System.out.print("[" + escala[INDICES_ACORDE[i]] + "]");
            if (i < INDICES_ACORDE.length - 1) System.out.print(" / ");
        }
        System.out.println();
    }
}

