package entregas.calderonJimena.reto001;

import java.util.Scanner;

class EscalaAcordeMayor {

    public static void main(String[] args) {
        String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

        int notaIndex = obtenerNotaUsuario();
        String notaBase = NOTAS[notaIndex];

        String[] escalaMayor = generarEscalaMayor(notaIndex, NOTAS);
        imprimirNotas("Escala Mayor de " + notaBase, escalaMayor);

        String[] acordeMayor = generarAcordeMayor(notaIndex, NOTAS);
        imprimirNotas("Acorde Mayor de " + notaBase, acordeMayor);
    }

    static int obtenerNotaUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar: ");
        System.out.println(
                "1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int nota = scanner.nextInt();
        scanner.close();
        return nota - 1;
    }

    static String[] generarEscalaMayor(int notaIndex, String[] NOTAS) {
        final int[] INTERVALOS = { 2, 2, 1, 2, 2, 2, 1 };
        String[] escala = new String[7];
        int index = notaIndex;

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[index];
            index = (index + INTERVALOS[i]) % NOTAS.length;
        }
        return escala;
    }

    static String[] generarAcordeMayor(int notaIndex, String[] NOTAS) {
        int[] ACORDE = { 0, 4, 7 };
        String[] acorde = new String[3];

        for (int i = 0; i < 3; i++) {
            acorde[i] = NOTAS[(notaIndex + ACORDE[i]) % NOTAS.length];
        }
        return acorde;
    }

    static void imprimirNotas(String titulo, String[] notas) {
        System.out.print(titulo + ": [");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println("]");
    }
}
