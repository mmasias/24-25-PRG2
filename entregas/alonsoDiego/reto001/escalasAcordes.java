package entregas.alonsoDiego.reto001;
import java.util.Scanner;
public class escalasAcordes {
    public static void main(String[] args) {
        final int TONO = 2;
        final int SEMITONO = 1;
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] patronIntervalos = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};
        final int OPCION_MINIMA = 1;
        final int OPCION_MAXIMA = notas.length;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println((OPCION_MINIMA + i) + ": " + notas[i]);
        }
        System.out.print("Opción: ");
        
        int seleccion = scanner.nextInt();
        if (seleccion < OPCION_MINIMA || seleccion > OPCION_MAXIMA) {
            System.out.println("Opción inválida. Debe ingresar un número entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA + ".");
            scanner.close();
            return;
        }
        
        int indiceNotaBase = seleccion - OPCION_MINIMA;
        String notaBase = notas[indiceNotaBase];
        System.out.println("\nHa elegido la nota " + notaBase);
        
        final int NUM_NOTAS_ESCALA = patronIntervalos.length + 1;
        String[] escala = new String[NUM_NOTAS_ESCALA];
        escala[0] = notaBase;
        int indiceActual = indiceNotaBase;
        for (int i = 0; i < patronIntervalos.length; i++) {
            indiceActual = (indiceActual + patronIntervalos[i]) % notas.length;
            escala[i + 1] = notas[indiceActual];
        }
        
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        for (int i = 0; i < escala.length; i++) {
            System.out.print("[" + escala[i] + "]");
            if (i < escala.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
        
        final int[] INDICES_ACORDE = {0, 2, 4};
        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        for (int i = 0; i < INDICES_ACORDE.length; i++) {
            System.out.print("[" + escala[INDICES_ACORDE[i]] + "]");
            if (i < INDICES_ACORDE.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
}
