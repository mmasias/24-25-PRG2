package lianoJavier.tarea001;
import java.util.Scanner;

class EscalaAcordes {
    public static void main(String[] args) {
        int notaATrabajar = pedirNota();
        String[] escala = crearEscala(notaATrabajar);
        String[] acorde = crearAcorde(escala);

        imprimirEscala(notaATrabajar, escala);
        imprimirAcorde(notaATrabajar, acorde);
    }

    static void imprimirEscala(int notaATrabajar, String[] escala) {
            String[] notas = getNotas();
            System.out.print("La escala de " + notas[notaATrabajar] + " Mayor es:");

            for (int i = 0; i < escala.length; i++) {

                System.out.println("[" + escala[i] + "]");

                if (i < escala.length - 1) { System.out.print(" / "); }
            }

    }

    static void imprimirAcorde(int notaATrabajar, String[] acorde) {

            String[] notas = getNotas();
            System.out.print("La escala de " + notas[notaATrabajar] + " Mayor es:");

            for (int i = 0; i < acorde.length; i++) {

                System.out.println("[" + acorde[i] + "]");

                if (i < acorde.length - 1) { System.out.print(" / "); }
            }

    }

    static String[] crearEscala(int notaATrabajar) {
        String[] escala = new String[8];

        String[] notas = getNotas();

        int[] posiciones = { 0, 2, 4, 5, 7, 9, 11, 12 };

        int anchoEscala = escala.length;
        for (int i = 0; i < anchoEscala; i++) {
            escala[i] = notas[notaATrabajar + posiciones[i]];
        }

        return escala;
    }

    static String[] getNotas() {
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        return notas;
    }

    static String[] crearAcorde(String[] escala) {
        String[] acorde = new String[3];

        acorde[0] = escala[0];
        acorde[1] = escala[2];
        acorde[2] = escala[4];

        int[] posiciones = { 0, 2, 4 };

        int anchoEscala = escala.length;
        for (int i = 0; i < anchoEscala; i++) {
            acorde[i] = escala[posiciones[i]];
        }

        return acorde;
    }

    static int pedirNota() {

        System.out.println("Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");

        Scanner sc = new Scanner(System.in);
        int notaATrabajar = sc.nextInt();

        String[] notas = getNotas();
        System.out.println("Ha elegido la nota " + notas[notaATrabajar]);

        return notaATrabajar;
    }
}