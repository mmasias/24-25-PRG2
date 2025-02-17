import java.util.Scanner;

public class EscalasAcordes {
    private static final String[] NOTAS = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};

    private static final int[][] SECUENCIA_ESCALA = {
        {0, 2, 4, 5, 7, 9, 11},  
        {0, 2, 3, 5, 7, 8, 10},  
        {0, 2, 3, 5, 7, 8, 11},  
        {0, 2, 3, 5, 7, 9, 11},  
        {0, 2, 4, 7, 9},         
        {0, 3, 5, 7, 10},        
        {0, 2, 3, 5, 7, 9, 10},  
        {0, 1, 3, 5, 7, 8, 10},  
        {0, 2, 4, 6, 7, 9, 11},  
        {0, 2, 4, 5, 7, 9, 10},  
        {0, 1, 3, 5, 6, 8, 10},  
        {0, 2, 4, 6, 8, 10}      
    };

    private static final int[][] SECUENCIA_ACORDE = {
        {0, 4, 7},  
        {0, 3, 7},  
        {0, 3, 7},  
        {0, 3, 7},  
        {0, 4, 7},  
        {0, 3, 7},  
        {0, 3, 7},  
        {0, 3, 7},  
        {0, 4, 7},  
        {0, 4, 7},  
        {0, 3, 7},  
        {0, 4, 7}   
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = pedirNota(scanner);
        int opcionEscala = pedirEscala(scanner);
        int posicion = obtenerPosicionNota(notas[1]);

        String[] notasReordenadas = reordenarNotas(notas, posicion);
        String[] escala = obtenerEscala(notasReordenadas, opcionEscala);
        String[] acorde = obtenerAcorde(notasReordenadas, opcionEscala);

        imprimirResultado("Notas de la Escala:", escala);
        imprimirResultado("Notas del Acorde:", acorde);

        scanner.close();
    }

    private static String[] pedirNota(Scanner scanner) {
        System.out.println("Seleccione una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ". " + NOTAS[i]);
        }

        System.out.print("Ingrese el número correspondiente: ");
        int notaSeleccionada = scanner.nextInt();

        return new String[]{Integer.toString(notaSeleccionada), NOTAS[notaSeleccionada - 1]};
    }

    private static int obtenerPosicionNota(String notaSeleccionada) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equals(notaSeleccionada)) {
                return i;
            }
        }
        return -1;
    }

    private static int pedirEscala(Scanner scanner) {
        String[] escalas = {
            "1. Mayor", "2. Menor Natural", "3. Menor Armónica", "4. Menor Melódica",
            "5. Pentatónica Mayor", "6. Pentatónica Menor", "7. Dórica", "8. Frigia",
            "9. Lidia", "10. Mixolidia", "11. Locria", "12. Por Tonos"
        };

        System.out.println("Seleccione una escala:");
        for (String escala : escalas) {
            System.out.println(escala);
        }

        System.out.print("Ingrese el número correspondiente: ");
        return scanner.nextInt();
    }

    private static String[] reordenarNotas(String[] notas, int posicion) {
        String[] notasReordenadas = new String[NOTAS.length];
        for (int i = 0; i < NOTAS.length; i++) {
            notasReordenadas[i] = NOTAS[(posicion + i) % NOTAS.length];
        }
        return notasReordenadas;
    }

    private static String[] obtenerEscala(String[] notasReordenadas, int opcionEscala) {
        int[] escalaIndices = SECUENCIA_ESCALA[opcionEscala - 1];
        String[] escala = new String[escalaIndices.length];
        for (int i = 0; i < escalaIndices.length; i++) {
            escala[i] = notasReordenadas[escalaIndices[i]];
        }
        return escala;
    }

    private static String[] obtenerAcorde(String[] notasReordenadas, int opcionEscala) {
        int[] acordeIndices = SECUENCIA_ACORDE[opcionEscala - 1];
        String[] acorde = new String[acordeIndices.length];
        for (int i = 0; i < acordeIndices.length; i++) {
            acorde[i] = notasReordenadas[acordeIndices[i]];
        }
        return acorde;
    }

    private static void imprimirResultado(String mensaje, String[] resultado) {
        System.out.println("\n" + mensaje);
        for (String elemento : resultado) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}
