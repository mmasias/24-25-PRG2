package entregas.arellanoDiego;

import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] patron = {"T", "T", "S", "T", "T", "T", "S"};

        // Obtener la nota base
        String notaBase = obtenerNotaBase(entrada, notas);
        System.out.println("Ha elegido la nota " + notaBase);

        // Obtener el índice de la nota base
        int indiceBase = obtenerIndiceNota(notaBase, notas);

        // Generar la escala mayor
        String[] escala = new String[8];
        escala[0] = notas[indiceBase]; 
        int indiceActual = indiceBase;

        for (int i = 1; i < 7; i++) {
            indiceActual = (indiceActual + (patron[i - 1].equals("T") ? 2 : 1)) % 12;
            escala[i] = notas[indiceActual];
        }
        escala[7] = notas[indiceBase];

        // Mostrar la escala mayor
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        for (String nota : escala) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();

        // Generar el acorde mayor (1ra, 3ra y 5ta nota de la escala)
        String[] acorde = {escala[0], escala[2], escala[4]};

        // Mostrar el acorde mayor
        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        for (String nota : acorde) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();

        entrada.close();
    }

    public static String obtenerNotaBase(Scanner scanner, String[] notas) {
        System.out.println("Ingrese la nota a trabajar: ");
        System.out.println("1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");

        int opcion = scanner.nextInt();
        return notas[opcion - 1];
    }

    public static int obtenerIndiceNota(String notaBase, String[] notas) {
        int indice = 0;
        while (indice < notas.length && !notas[indice].equals(notaBase)) {
            indice++;
        }
        return indice;
    }
}
