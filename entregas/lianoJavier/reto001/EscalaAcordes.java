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
            System.out.print("El acorde de " + notas[notaATrabajar] + " Mayor es: ");

            for (int i = 0; i < escala.length; i++) {

                System.out.print("[" + escala[i] + "]");

                if (i < escala.length - 1) System.out.print(" / ");
            }
            System.out.println();

    }

    static void imprimirAcorde(int notaATrabajar, String[] acorde) {

            String[] notas = getNotas();
            System.out.print("La escala de " + notas[notaATrabajar] + " Mayor es: ");

            for (int i = 0; i < acorde.length; i++) {
                System.out.print("[" + acorde[i] + "]");

                if (i < acorde.length - 1) System.out.print(" / ");
            }
            System.out.println();

    }

    static String[] crearEscala(int notaATrabajar) {
        String[] escala = new String[8];

        String[] notas = getNotas();

        int[] posiciones = { 0, 2, 4, 5, 7, 9, 11, 12 };

        int anchoEscala = escala.length;
        int anchoNotas = notas.length;
        for (int i = 0; i < anchoEscala; i++) {
            escala[i] = notas[(notaATrabajar + posiciones[i]) % anchoNotas];
        }

        return escala;
    }

    static String[] getNotas() {
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        return notas;
    }

    static String[] crearAcorde(String[] escala) {
            String[] acorde = new String[3];
    

        int[] posiciones = { 0, 2, 4 };

        int anchoAcorde = acorde.length;
        for (int i = 0; i < anchoAcorde; i++) {
            acorde[i] = escala[posiciones[i]];
        }

        return acorde;
    }

    static int pedirNota() {

        System.out.println("Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");

        Scanner sc = new Scanner(System.in);
        int notaATrabajar = sc.nextInt() - 1;

        String[] notas = getNotas();
        System.out.println("Ha elegido la nota " + notas[notaATrabajar]);

        return notaATrabajar;
    }
}