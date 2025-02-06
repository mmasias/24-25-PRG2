package entregas.cotareloDaniel.reto001;

import java.util.Scanner;

public class EscalaAcordes {
    static final String[] NOTAS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa",
            "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.print((i + 1) + ": " + NOTAS[i]);
            if (i < NOTAS.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > 12) {
            System.out.println("Selección inválida");
            scanner.close();
            return;
        }

        int indiceNota = seleccion - 1;
        String notaBase = NOTAS[indiceNota];

        System.out.println("Ha elegido la nota " + notaBase);

        String[] escalaMayor = construirEscalaMayor(indiceNota);
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        mostrarNotas(escalaMayor);

        String[] acordeMayor = construirAcordeMayor(escalaMayor);
        System.out.print("El acorde de " + notaBase + " Mayor esta conformado por: ");
        mostrarNotas(acordeMayor);

        scanner.close();
    }

    static String[] construirEscalaMayor(int indiceInicial) {
        int[] patron = { 2, 2, 1, 2, 2, 2, 1 };
        String[] escala = new String[8];

        int indiceActual = indiceInicial;
        escala[0] = NOTAS[indiceActual];

        for (int i = 0; i < patron.length; i++) {
            indiceActual = (indiceActual + patron[i]) % 12;
            escala[i + 1] = NOTAS[indiceActual];
        }

        return escala;
    }

    static String[] construirAcordeMayor(String[] escalaMayor) {
        return new String[] { escalaMayor[0], escalaMayor[2], escalaMayor[4] };
    }

    static void mostrarNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]");
            if (i < notas.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
    }
}