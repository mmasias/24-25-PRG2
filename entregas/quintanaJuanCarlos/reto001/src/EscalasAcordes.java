import java.util.Scanner;

public class EscalasAcordes {

    public static void main(String[] args) {
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        Scanner scanner = new Scanner(System.in);

        int notaUsuario = obtenerNotaUsuario(scanner);

        if (notaValida(notaUsuario, notas.length)) {
            mostrarResultados(notaUsuario, notas);
        } else {
            System.out.println("Nota no válida. Por favor, ingrese un número entre 1 y 12.");
        }

        scanner.close();
    }

    private static int obtenerNotaUsuario(Scanner scanner) {
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");
        return scanner.nextInt() - 1;
    }

    private static boolean notaValida(int notaUsuario, int totalNotas) {
        return notaUsuario >= 0 && notaUsuario < totalNotas;
    }

    private static void mostrarResultados(int notaUsuario, String[] notas) {
        String notaElegida = notas[notaUsuario];
        System.out.println("Ha elegido la nota " + notaElegida);

        String[] escalaMayor = construirEscalaMayor(notaUsuario, notas);
        String[] acordeMayor = construirAcordeMayor(notaUsuario, notas);

        System.out.println("La escala de " + notaElegida + " Mayor es: " + String.join(" / ", escalaMayor));
        System.out.println("El acorde de " + notaElegida + " Mayor está conformado por: " + String.join(" / ", acordeMayor));
    }

    private static String[] construirEscalaMayor(int notaInicial, String[] notas) {
        int[] intervalos = {2, 2, 1, 2, 2, 2, 1};
        String[] escala = new String[8];
        int posicionActual = notaInicial;

        escala[0] = notas[notaInicial];

        for (int i = 0; i < intervalos.length; i++) {
            posicionActual = (posicionActual + intervalos[i]) % notas.length;
            escala[i + 1] = notas[posicionActual];
        }

        return escala;
    }

    private static String[] construirAcordeMayor(int notaInicial, String[] notas) {
        int[] intervalosAcorde = {0, 4, 7};
        String[] acorde = new String[3];

        for (int i = 0; i < intervalosAcorde.length; i++) {
            acorde[i] = notas[(notaInicial + intervalosAcorde[i]) % notas.length];
        }

        return acorde;
    }
}