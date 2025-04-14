package reto002;

import java.util.Scanner;

class Masescalasacordes {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_MEDIO = SEMITONO + TONO;

    private static final int[][] ESCALAS = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
        {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO},
        {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
        {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
        {TONO, TONO, TONO, TONO, TONO, TONO}
    };

    public static void main(String[] args) {
        String notaBase = solicitarNota();
        int[] escalaSeleccionada = solicitarEscala();
        String[] escala = generarEscala(notaBase, escalaSeleccionada);
        String[] acorde = generarAcorde(escala);
        System.out.println("Escala en " + notaBase + ":");
        mostrarNotas(escala);
        System.out.println("Acorde:");
        mostrarNotas(acorde);
    }

    private static void mostrarNotas(String[] notas) {
        for (String nota : notas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    private static String[] generarAcorde(String[] escala) {
        return new String[]{escala[0], escala[2], escala[4]};
    }

    private static String[] generarEscala(String nota, int[] intervalos) {
        int indiceNota = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length + 1];
        
        escala[0] = NOTAS[indiceNota];  // La primera nota de la escala es la base
        for (int i = 1; i < escala.length; i++) {
            indiceNota = (indiceNota + intervalos[i - 1]) % NOTAS.length;
            escala[i] = NOTAS[indiceNota];
        }
        return escala;
    }

    private static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1; // Si no se encuentra la nota
    }

    private static String solicitarNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la nota base -> 1: Do, 2: Do#, 3: Re ...");
        int nota = scanner.nextInt();
        if (nota < 1 || nota > NOTAS.length) {
            System.out.println("Opción inválida. Seleccionando Do por defecto.");
            return "Do";  // Retorna "Do" si la opción es inválida
        }
        return NOTAS[nota - 1];
    }

    private static int[] solicitarEscala() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de escala:");
        System.out.println("1: Mayor");
        System.out.println("2: Menor natural");
        System.out.println("3: Menor armónica");
        System.out.println("4: Menor melódica");
        System.out.println("5: Pentatónica mayor");
        System.out.println("6: Pentatónica menor");
        System.out.println("7: Dórica");
        System.out.println("8: Frigia");
        System.out.println("9: Lidia");
        System.out.println("10: Mixolidia");
        System.out.println("11: Locria");
        System.out.println("12: Por tonos");
        int escala = scanner.nextInt();
        if (escala < 1 || escala > ESCALAS.length) {
            System.out.println("Opción inválida. Seleccionando Mayor por defecto.");
            return ESCALAS[0];  // Selecciona la escala mayor si la opción es inválida
        }
        return ESCALAS[escala - 1];
    }
}
