package entregas.vaqueroInigo;

import java.util.Scanner;

public class reto001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tonos = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        System.out.print("Ingrese la nota a trabajar (1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ... 12: Si): ");
        int notaBase = scanner.nextInt();

        if (notaBase >= 1 && notaBase <= 12) {
            String notaSeleccionada = tonos[notaBase - 1];
            System.out.println("La nota seleccionada es: " + notaSeleccionada);
            String[] escalaMayor = obtenerEscalaMayor(notaBase - 1, tonos);
            imprimirEscalaMayor(escalaMayor, notaSeleccionada);
            obtenerAndImprimirAcordeMayor(escalaMayor);
        } else {
            System.out.println("Número de nota no válido. Ingresa un valor entre 1 y 12.");
        }

        scanner.close();
    }

    public static String[] obtenerEscalaMayor(int indiceNotaBase, String[] tonos) {
        int[] intervalosEscalaMayor = {2, 2, 1, 2, 2, 2, 1};
        String[] escalaMayor = new String[8];
        escalaMayor[0] = tonos[indiceNotaBase];
        int posicionActual = indiceNotaBase;

        for (int i = 1; i < escalaMayor.length; i++) {
            posicionActual = (posicionActual + intervalosEscalaMayor[i - 1]) % tonos.length;
            escalaMayor[i] = tonos[posicionActual];
        }

        return escalaMayor;
    }

    public static void imprimirEscalaMayor(String[] escalaMayor, String notaBase) {
        System.out.print("Escala mayor de " + notaBase + " es:");
        for (String nota : escalaMayor) {
            System.out.print(" [" + nota + "] ");
        }
        System.out.println();
    }

    public static void obtenerAndImprimirAcordeMayor(String[] escalaMayor) {
        String[] acordeMayor = {escalaMayor[0], escalaMayor[2], escalaMayor[4]};
        System.out.print("Acorde mayor de " + escalaMayor[0] + " está conformado por:");
        for (String nota : acordeMayor) {
            System.out.print(" [" + nota + "] ");
        }
        System.out.println();
    }
}
