package entregas.calderonJimena.reto002;

import java.util.Scanner;

class EscalaAcordeMayor {

    static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    static final int[][] ESCALAS = {
            { 2, 2, 1, 2, 2, 2, 1 },
            { 2, 1, 2, 2, 1, 2, 2 },
            { 2, 1, 2, 2, 1, 3, 1 },
            { 2, 1, 2, 2, 2, 2, 1 },
            { 2, 2, 3, 2, 3 },
            { 3, 2, 2, 3, 2 },
            { 2, 1, 2, 2, 2, 1, 2 },
            { 1, 2, 2, 2, 1, 2, 2 },
            { 2, 2, 2, 1, 2, 2, 1 },
            { 2, 2, 1, 2, 2, 1, 2 },
            { 1, 2, 2, 1, 2, 2, 2 },
            { 2, 2, 2, 2, 2, 2 }
    };

    static final String[] NOMBRES_ESCALAS = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Notas: ");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.print((i + 1) + ". " + NOTAS[i]);
            if (i < NOTAS.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("\nSeleccione la nota base: ");

        int notaIndex = scanner.nextInt() - 1;

        System.out.println("Escalas: ");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ". " + NOMBRES_ESCALAS[i]);
        }

        System.out.print("Seleccione una escala: ");

        int escalaIndex = scanner.nextInt() - 1;
        scanner.close();

        System.out.print("\nNota seleccionada: " + NOTAS[notaIndex] + "\n");
        imprimirEscala(NOMBRES_ESCALAS[escalaIndex], notaIndex, ESCALAS[escalaIndex]);
    }

    static void imprimirEscala(String titulo, int notaIndex, int[] intervalos) {
        System.out.print(titulo + ": ");
        String[] escala = generarEscala(notaIndex, intervalos);

        for (int i = 0; i < escala.length; i++) {
            System.out.print(escala[i]);
            if (i < escala.length - 1) {
                System.out.print(" / ");
            }
        }
    }

    static String[] generarEscala(int notaIndex, int[] intervalos) {
        String[] escala = new String[intervalos.length + 1];
        int index = notaIndex;

        for (int i = 0; i < intervalos.length; i++) {
            escala[i] = NOTAS[index];
            index = (index + intervalos[i]) % NOTAS.length;
        }

        escala[intervalos.length] = NOTAS[notaIndex];
        return escala;
    }
}
