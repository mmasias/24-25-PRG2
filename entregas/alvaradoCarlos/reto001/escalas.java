import java.util.Scanner;

class escalas {
    public static void main(String[] args) {
        int tono = 0;
        String[] arrayNotas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si", "Do"};
        escalaMayor(arrayNotas, tono);
    }

    public static void escalaMayor(String[] arrayNotas, int tono) {
        System.out.println("Escala mayor de " + arrayNotas[tono] + " mayor");
        int[] intervalos = {0, 2, 4, 5, 7, 9, 11, 12};

        for (int i = 0; i < intervalos.length; i++) {
            System.out.print(arrayNotas[tono + intervalos[i]] + " ");
        }
        System.out.println();
    }
}