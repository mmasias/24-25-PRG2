import java.util.Scanner;

public class EscalaAcordes {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};
    private static final int ERROR_OPTION = -1;

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new EscalaAcordes().run();
    }

    private void run() {
        mostrarOpciones();
        int opcion = obtenerEntradaUsuario();
        if (opcion != ERROR_OPTION) {
            mostrarResultado(opcion - 1);
        }
        scanner.close();
    }

    private void mostrarOpciones() {
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        System.out.print("Opción: ");
    }

    private int obtenerEntradaUsuario() {
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return ERROR_OPTION;
        }
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > NOTAS.length) {
            System.out.println("Opción inválida. Debe ingresar un número entre 1 y " + NOTAS.length + ".");
            return ERROR_OPTION;
        }
        return opcion;
    }

    private String[] construirEscalaMayor(int indiceNota) {
        String[] escalaMayor = new String[PATRON_ESCALA_MAYOR.length + 1];
        escalaMayor[0] = NOTAS[indiceNota];
        int posicion = indiceNota;
        for (int i = 0; i < PATRON_ESCALA_MAYOR.length; i++) {
            posicion = (posicion + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
            escalaMayor[i + 1] = NOTAS[posicion];
        }
        return escalaMayor;
    }

    private void mostrarResultado(int indiceNota) {
        String[] escalaMayor = construirEscalaMayor(indiceNota);
        String[] acordeMayor = {escalaMayor[0], escalaMayor[2], escalaMayor[4]};

        System.out.println("La escala de " + NOTAS[indiceNota] + " Mayor es: " + String.join(" / ", escalaMayor));
        System.out.println("El acorde de " + NOTAS[indiceNota] + " Mayor está conformado por: " + String.join(" / ", acordeMayor));
    }
}

