package entregas.perozoDiego;
import java.util.Scanner;

public class Reto001 {

    public static void main(String[] args) {
        obtenerRespuesta();
    }

    public static void obtenerRespuesta() {
        System.out.println("Por favor introduce el número correspondiente a la nota (0-Do, 1-Do#, 2-Re, 3-Re#, 4-Mi, 5-Fa, 6-Fa#, 7-Sol, 8-Sol#, 9-La, 10-La#, 11-Si):");

        Scanner scanner = new Scanner(System.in);
        int indiceNota = scanner.nextInt();

        if (indiceNota < 0 || indiceNota > 11) {
            System.out.println("Número no válido.");
            return;
        }

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] escalaMayor = {0, 2, 4, 5, 7, 9, 11};

        System.out.println("Escala mayor de " + notas[indiceNota] + ":");

        for (int intervalo : escalaMayor) {
            System.out.print(notas[(indiceNota + intervalo) % 12] + " ");
        }
        System.out.println();
    }
}
