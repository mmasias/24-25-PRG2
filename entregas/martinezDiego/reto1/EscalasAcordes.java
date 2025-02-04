package entregas.martinezDiego.reto1;

import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = { "do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si" };
        imprimirNotas(notas);

        System.out.println("Selecciona una nota:");
        String eleccion = scanner.nextLine().toLowerCase();

        String[] escalaMayor = construirEscalaMayor(notas, eleccion);
        if (escalaMayor != null) {
            construirAcordeMayor(escalaMayor, eleccion);
        }
        scanner.close();
    }

    static String[] construirEscalaMayor(String[] notas, String eleccion) {
        int[] estructuraMayor = { 2, 2, 1, 2, 2, 2, 1 };
        int posicion = -1;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equals(eleccion)) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("Nota no válida.");
            return null;
        }

        String[] escala = new String[7];
        System.out.print("Escala mayor de " + eleccion + ": ");
        System.out.print(notas[posicion] + " ");
        escala[0] = notas[posicion];

        for (int i = 1; i < estructuraMayor.length; i++) {
            posicion = (posicion + estructuraMayor[i - 1]) % notas.length;
            escala[i] = notas[posicion];
            System.out.print(notas[posicion] + " ");
        }

        System.out.println();
        return escala;
    }

    static void construirAcordeMayor(String[] escalaMayor, String eleccion) {
        String tónica = escalaMayor[0];
        String tercera = escalaMayor[2];
        String quinta = escalaMayor[4];

        System.out.println("Acorde mayor de " + eleccion + ": " + tónica + " " + tercera + " " + quinta);
    }

    static void imprimirNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println();
    }
}

