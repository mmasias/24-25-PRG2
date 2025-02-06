import java.util.Scanner;

public class EscalasAcordes2 {
    public static void main(String[] args) {
        String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");
        int eleccion = scanner.nextInt() - 1;

        if (!esNotaValida(eleccion, NOTAS)) {
            System.out.println("Selección inválida.");
            return;
        }

        String notaBase = NOTAS[eleccion];
        System.out.println("Ha elegido la nota " + notaBase);

        String[] escalaMayor = construirEscalaMayor(eleccion, NOTAS, PATRON_ESCALA_MAYOR);
        mostrarEscala(notaBase, escalaMayor);
        mostrarAcorde(notaBase, escalaMayor);

        scanner.close();
    }

    private static boolean esNotaValida(int indice, String[] notas) {
        return indice >= 0 && indice < notas.length;
    }

    private static String[] construirEscalaMayor(int indiceBase, String[] notas, int[] patron) {
        String[] escalaMayor = new String[8];
        escalaMayor[0] = notas[indiceBase];
        int posicion = indiceBase;

        for (int i = 0; i < patron.length; i++) {
            posicion = (posicion + patron[i]) % notas.length;
            escalaMayor[i + 1] = notas[posicion];
        }
        return escalaMayor;
    }

    private static void mostrarEscala(String notaBase, String[] escalaMayor) {
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        for (String nota : escalaMayor) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    private static void mostrarAcorde(String notaBase, String[] escalaMayor) {
        System.out.println("El acorde de " + notaBase + " Mayor está conformado por: [" + escalaMayor[0] + "] / [" + escalaMayor[2] + "] / [" + escalaMayor[4] + "]");
    }
}
