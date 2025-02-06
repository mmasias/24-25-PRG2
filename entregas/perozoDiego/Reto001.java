package entregas.perozoDiego;

import java.util.Scanner;

public class Reto001 {

    public static void main(String[] args) {
        obtenerRespuesta();
    }

    public static void obtenerRespuesta() {
        System.out.println(
                "Por favor introduce el número correspondiente a la nota (1-Do, 2-Do#, 3-Re, 4-Re#, 5-Mi, 6-Fa, 7-Fa#, 8-Sol, 9-Sol#, 10-La, 11-La#, 12-Si):");

        Scanner scanner = new Scanner(System.in);
        int indiceNota = scanner.nextInt() - 1;

        if (indiceNota < 0 || indiceNota > 11) {
            System.out.println("Número no válido.");
            return;
        }

        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        int[] escalaMayor = { 0, 2, 4, 5, 7, 9, 11 };

        System.out.println("Escala mayor de " + notas[indiceNota] + ":");

        for (int intervalo : escalaMayor) {
            System.out.print(notas[(indiceNota + intervalo) % 12] + " ");
        }
        System.out.println();

        obtenerAcordeMayor(indiceNota, notas);
    }

    public static void obtenerAcordeMayor(int indiceNota, String[] notas) {
        System.out.println("Acorde mayor de " + notas[indiceNota] + ":");
        System.out.println(notas[indiceNota] + " " + notas[(indiceNota + 4) % 12] + " " + notas[(indiceNota + 7) % 12]);
    }
}
