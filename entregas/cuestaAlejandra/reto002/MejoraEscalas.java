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