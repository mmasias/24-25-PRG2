package entregas.vaqueroInigo;

import java.util.Scanner;

public class reto002 {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    private static final String[] NOMBRES_ESCALAS = {
        "Mayor", "Menor Natural", "Menor Armónica", "Menor Melódica",
        "Pentatónica Mayor", "Pentatónica Menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por Tonos"
    };
    
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota a trabajar (1: Do, 2: Do#, 3: Re, ... 12: Si): ");
        int notaBase = scanner.nextInt();
        
        if (notaBase < 1 || notaBase > NOTAS.length) {
            System.out.println("Número de nota no válido. Ingresa un valor entre 1 y 12.");
            scanner.close();
            return;
        }
        
        String notaSeleccionada = NOTAS[notaBase - 1];
        System.out.println("La nota seleccionada es: " + notaSeleccionada);
        
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            String[] escala = construirEscala(notaBase - 1, PATRONES_ESCALAS[i]);
            System.out.print("Escala " + NOMBRES_ESCALAS[i] + " de " + notaSeleccionada + " es:");
            for (String nota : escala) {
                System.out.print(" [" + nota + "]");
            }
            System.out.println();
            
            if (escala.length >= 5) {
                System.out.print("Acorde: [" + escala[0] + "] [" + escala[2] + "] [" + escala[4] + "]");
            } else {
                System.out.print("No se puede formar un acorde 1-3-5 con esta escala.");
            }
            System.out.println("\n");
        }
        
        scanner.close();
    }

    public static String[] construirEscala(int indiceNotaBase, int[] patron) {
        String[] escala = new String[patron.length + 1];
        int posicionActual = indiceNotaBase;
        for (int i = 0; i < patron.length; i++) {
            escala[i] = NOTAS[posicionActual % NOTAS.length];
            posicionActual += patron[i];
        }
        escala[patron.length] = NOTAS[posicionActual % NOTAS.length];
        return escala;
    }
}
