package entregas.calderonJimena.reto001;

import java.util.Scanner;

public class EscalaAcordeMayor {
    public static void main(String[] args) {
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] intervalosMayor = {2, 2, 1, 2, 2, 2, 1};
        int[] acordeMayor = {0, 4, 7};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si: ");
        int nota = scanner.nextInt();
        scanner.close();

        int notaIndex = nota - 1;
        String nombreNota = notas[notaIndex];
        final int NOTAS_TOTALES = 12;

        System.out.print("La escala de " + nombreNota + " Mayor es: ");
        int actual = notaIndex;
        System.out.print("[" + notas[actual] + "]");
        for (int i = 0; i < intervalosMayor.length; i++) {
            actual = (actual + intervalosMayor[i]) % NOTAS_TOTALES;
            System.out.print(" / [" + notas[actual] + "]");
        }
        System.out.println();

        System.out.print("El acorde de " + nombreNota + " Mayor está conformado por: ");
        System.out.print("[" + notas[(notaIndex + acordeMayor[0]) % NOTAS_TOTALES] + "]");
        for (int i = 1; i < acordeMayor.length; i++) {
            System.out.print(" / [" + notas[(notaIndex + acordeMayor[i]) % NOTAS_TOTALES] + "]");
        }
        System.out.println();
    }
}
