import java.util.Scanner;

public class EscalasMusicales {
    final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    final int[] ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1}; 
    final int[] ESCALA_MENOR = {2, 1, 2, 2, 1, 2, 2}; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcionNota = elegirNota(scanner);
        if (opcionNota == -1) {
            System.out.println("Entrada no válida. Saliendo...");
            return;
        }

        String notaBase = NOTAS[opcionNota - 1];
        System.out.println("Ha elegido la nota: " + notaBase);

        System.out.println("\nEscala Mayor:");
        imprimirEscala(notaBase, ESCALA_MAYOR);
        imprimirAcordeMayor(notaBase, ESCALA_MAYOR);

        System.out.println("\nEscala Menor:");
        imprimirEscala(notaBase, ESCALA_MENOR);
        imprimirAcordeMenor(notaBase, ESCALA_MENOR);

        scanner.close();
    }

    private static int elegirNota(Scanner scanner) {
        System.out.println("Ingrese una nota:");

        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        System.out.print("> ");

        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= NOTAS.length) {
                return opcion;
            }
        }
        return -1; 
    }

    private static void imprimirEscala(String notaBase, int[] intervalos) {
        int indice = obtenerIndiceNota(notaBase);
        String[] escala = new String[7];

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[indice % NOTAS.length];
            indice += intervalos[i];
        }

        System.out.println("La escala de " + notaBase + " es: " + String.join(" ", escala));
    }

     private static void imprimirAcordeMayor(String notaBase, int[] intervalos) {
        imprimirAcorde(notaBase, intervalos, "Mayor", 0, 2, 4);
    }

     private static void imprimirAcordeMenor(String notaBase, int[] intervalos) {
        imprimirAcorde(notaBase, intervalos, "Menor", 0, 2, 4);
    }

    private static void imprimirAcorde(String notaBase, int[] intervalos, String tipo, int... grados) {
        int indice = obtenerIndiceNota(notaBase);
        String[] escala = new String[7];

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[indice % NOTAS.length];
            indice += intervalos[i];
        }

        System.out.println("El acorde de " + notaBase + " " + tipo + " está conformado por: [" +
                escala[grados[0]] + ", " + escala[grados[1]] + ", " + escala[grados[2]] + "]");
    }

    
    private static int obtenerIndiceNota(String nota) {

     nota = nota.intern(); 
     int i = 0;
      while (i < NOTAS.length && NOTAS[i] != nota) {
        i++;
      }
     return (i < NOTAS.length) ? i : -1;
    }
}