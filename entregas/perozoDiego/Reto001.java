package entregas.perozoDiego;

import java.util.Scanner;

class Reto001 {
    public static void main(String[] args) {
        int indiceNota = obtenerIndiceNota();
        imprimirNota(indiceNota);
    }

    private static int obtenerIndiceNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Por favor, introduzca el numero correspondiente a la nota (0-Do, 1-Do#, 2-Re, 3-Re#, 4-Mi, 5-Fa, 6-Fa#, 7-Sol, 8-Sol#, 9-La, 10-La#, 11-Si):");
        return scanner.nextInt();
    }

    private static void imprimirNota(int indice) {
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        if (indice >= 0 && indice <= 11) {
            System.out.println("La nota correspondiente es: " + notas[indice]);
        } else {
            System.out.println("Nota no valida");
        }
    }
}
