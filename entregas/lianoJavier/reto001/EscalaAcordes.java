import java.util.Scanner;

class EscalaAcordes {

    static final String[] NOTAS = new String[] { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    public static void main(String[] args) {
        int notaATrabajar = pedirNota();
        String[] escala = crearEscala(notaATrabajar);
        String[] acorde = crearAcorde(escala);

        System.out.print("El acorde de " + NOTAS[notaATrabajar] + " Mayor es: ");
        imprimirArray(notaATrabajar, escala);
        System.out.print("La escala de " + NOTAS[notaATrabajar] + " Mayor es: ");
        imprimirArray(notaATrabajar, acorde);
    }

    static void imprimirArray(int notaATrabajar, String[] escala) {
            for (String nota : escala) {
                System.out.print("[" + nota + "] ");
            }
            System.out.println();
    }

    static String[] crearEscala(int notaATrabajar) {
        String[] escala = new String[8];


        int[] posiciones = { 0, 2, 4, 5, 7, 9, 11, 12 };

        int anchoEscala = escala.length;
        int anchoNotas = NOTAS.length;
        for (int i = 0; i < anchoEscala; i++) {
            escala[i] = NOTAS[(notaATrabajar + posiciones[i]) % anchoNotas];
        }

        return escala;
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
        sc.close();

        System.out.println("Ha elegido la nota " + NOTAS[notaATrabajar]);

        return notaATrabajar;
    }
}