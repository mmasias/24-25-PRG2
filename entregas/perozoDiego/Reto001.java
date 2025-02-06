package entregas.perozoDiego;
import java.util.Scanner;

class Reto001 {
    public static void main(String[] args) {
        int indiceNota = obtenerIndiceNota();
    }

    private static int obtenerIndiceNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduzca el número correspondiente a la nota (0-Do, 1-Do#, 2-Re, 3-Re#, 4-Mi, 5-Fa, 6-Fa#, 7-Sol, 8-Sol#, 9-La, 10-La#, 11-Si):");
        return scanner.nextInt();
    }
}
