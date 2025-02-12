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