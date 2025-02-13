package entregas.martinezDiego.reto002.src;

import java.util.Scanner;

public class EscalasAcordes {

    static String[] notas = { "do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si" };
    static int[] escalas = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona una nota y una escala:");
        imprimirNotas(notas);
        System.out.println();
        imprimirEscalas(escalas);

        String eleccionNota = scanner.nextLine().toLowerCase();
        int eleccionEscala = scanner.nextInt();

        int[] escala = construirEscala(notas, eleccionNota, eleccionEscala);

        if (escala.length > 0) {
            System.out.print("Escala: ");
            for (int i : escala) {
                System.out.print(notas[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    static int[] construirEscala(String[] notas, String eleccionNota, int eleccionEscala) {
        int notaElegida = buscarNota(notas, eleccionNota);
        if (notaElegida == -1)
            return new int[0];

        int[] escalaElegida = seleccionarEscala(eleccionEscala);
        if (escalaElegida.length == 0)
            return new int[0];

        int[] escalaConstruida = new int[escalaElegida.length + 1];
        escalaConstruida[0] = notaElegida;

        for (int i = 1; i <= escalaElegida.length; i++) {
            notaElegida = (notaElegida + escalaElegida[i - 1]) % notas.length;
            escalaConstruida[i] = notaElegida;
        }

        return escalaConstruida;
    }

    static int[] seleccionarEscala(int eleccionEscala) {
        int tono = 2;
        int semitono = 1;
        int tonoMedio = 3;

        switch (eleccionEscala) {
            case 1:
                return new int[] { tono, tono, semitono, tono, tono, tono, semitono };
            case 2:
                return new int[] { tono, semitono, tono, tono, semitono, tono, tono };
            case 3:
                return new int[] { tono, semitono, tono, tono, semitono, tonoMedio, semitono };
            case 4:
                return new int[] { tono, semitono, tono, tono, tono, tono, semitono };
            case 5:
                return new int[] { tono, tono, tonoMedio, tono, tonoMedio };
            case 6:
                return new int[] { tonoMedio, tono, tono, tonoMedio, tono };
            case 7:
                return new int[] { tono, semitono, tono, tono, tono, semitono, tono };
            case 8:
                return new int[] { semitono, tono, tono, tono, semitono, tono, tono };
            case 9:
                return new int[] { tono, tono, tono, semitono, tono, tono, semitono };
            case 10:
                return new int[] { tono, tono, semitono, tono, tono, semitono, tono };
            case 11:
                return new int[] { semitono, tono, tono, semitono, tono, tono, tono };
            case 12:
                return new int[] { tono, tono, tono, tono, tono, tono };
            default:
                return new int[0];
        }
    }

    static int buscarNota(String[] notas, String eleccion) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equals(eleccion))
                return i;
        }
        return -1;
    }

    static void imprimirNotas(String[] notas) {
        System.out.print("Notas disponibles: ");
        for (String nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }

    static void imprimirEscalas(int[] escalas) {
        System.out.println("Escalas disponibles:");
        for (int escala : escalas) {
            System.out.println(convertirNumero(escala));
        }
    }

    static String convertirNumero(int valor) {
        switch (valor) {
            case 1:
                return "1: Escala Mayor";
            case 2:
                return "2: Escala Menor Natural";
            case 3:
                return "3: Escala Menor Armónica";
            case 4:
                return "4: Escala Menor Melódica";
            case 5:
                return "5: Escala Pentatónica Mayor";
            case 6:
                return "6: Escala Pentatónica Menor";
            case 7:
                return "7: Escala Dórico";
            case 8:
                return "8: Escala Frigia";
            case 9:
                return "9: Escala Lidia";
            case 10:
                return "10: Escala Mixolidia";
            case 11:
                return "11: Escala Locria";
            case 12:
                return "12: Escala por Tonos";
            default:
                return "";
        }
    }
}
