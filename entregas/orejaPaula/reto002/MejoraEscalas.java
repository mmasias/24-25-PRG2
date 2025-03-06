import java.util.*;

public class MejoraEscalas {
    private static final String[] NOTAS = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa",
        "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final String[] TIPOS_ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    private static final int[][] PATRONES_ESCALAS = {
        {2, 2, 1, 2, 2, 2, 1},
        {2, 1, 2, 2, 1, 2, 2},
        {2, 1, 2, 2, 1, 3, 1},
        {2, 1, 2, 2, 2, 2, 1},
        {2, 2, 3, 2, 3},
        {3, 2, 2, 3, 2},
        {2, 1, 2, 2, 2, 1, 2},
        {1, 2, 2, 2, 1, 2, 2},
        {2, 2, 2, 1, 2, 2, 1},
        {2, 2, 1, 2, 2, 1, 2},
        {1, 2, 2, 1, 2, 2, 2},
        {2, 2, 2, 2, 2, 2}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        mostrarOpcionesNotas();

        int notaElegida = obtenerOpcionValida(input, 1, 12);
        if (notaElegida == -1) return;

        mostrarOpcionesEscalas();
        int escalaElegida = obtenerOpcionValida(input, 1, TIPOS_ESCALAS.length);
        if (escalaElegida == -1) return;

        generarSalida(notaElegida - 1, escalaElegida - 1);
        input.close();
    }

    private static void mostrarOpcionesNotas() {
        System.out.println("Seleccione una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.print((i + 1) + ": " + NOTAS[i] + (i < NOTAS.length - 1 ? ", " : "\n"));
        }
        System.out.print("Ingrese el número de la nota deseada: ");
    }

    private static void mostrarOpcionesEscalas() {
        System.out.println("\nSeleccione el tipo de escala:");
        for (int i = 0; i < TIPOS_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + TIPOS_ESCALAS[i]);
        }
        System.out.print("Ingrese el número de la escala deseada: ");
    }

    private static int obtenerOpcionValida(Scanner input, int min, int max) {
        int seleccion = input.nextInt();
        if (seleccion < min || seleccion > max) {
            System.out.println("Opción no válida");
            return -1;
        }
        return seleccion;
    }

    private static void generarSalida(int indiceNota, int indiceEscala) {
        System.out.println("\nNota seleccionada: " + NOTAS[indiceNota]);
        String[] escala = construirEscala(indiceNota, PATRONES_ESCALAS[indiceEscala]);
        System.out.print("Escala " + TIPOS_ESCALAS[indiceEscala] + ": ");
        mostrarNotas(escala);
        System.out.print("Acorde: ");
        mostrarNotas(construirAcorde(escala));
    }

    private static String[] construirEscala(int inicio, int[] patron) {
        String[] resultado = new String[patron.length + 1];
        int posicion = inicio;
        resultado[0] = NOTAS[posicion];

        for (int i = 0; i < patron.length; i++) {
            posicion = (posicion + patron[i]) % 12;
            resultado[i + 1] = NOTAS[posicion];
        }
        return resultado;
    }

    private static String[] construirAcorde(String[] escala) {
        return new String[]{escala[0], escala[2], escala[4]};
    }

    private static void mostrarNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]" + (i < notas.length - 1 ? " / " : "\n"));
        }
    }
}
