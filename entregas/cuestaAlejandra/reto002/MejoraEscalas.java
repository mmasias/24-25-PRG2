import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa",
            "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    static final int[][] PATRONES = {
            { 2, 2, 1, 2, 2, 2, 1 },
            { 2, 1, 2, 2, 1, 2, 2 },
            { 2, 1, 2, 2, 1, 3, 1 },
            { 2, 1, 2, 2, 2, 2, 1 },
            { 2, 2, 3, 2, 3 },
            { 3, 2, 2, 3, 2 },
            { 2, 1, 2, 2, 2, 1, 2 },
            { 1, 2, 2, 2, 1, 2, 2 },
            { 2, 2, 2, 1, 2, 2, 1 },
            { 2, 2, 1, 2, 2, 1, 2 },
            { 1, 2, 2, 1, 2, 2, 2 },
            { 2, 2, 2, 2, 2, 2 }
    };

    static final String[] NOMBRES_ESCALAS = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        mostrarMenuNotas();

        int seleccionNota = obtenerSeleccionValida(entrada, 1, 12);
        if (seleccionNota == -1) {
            entrada.close();
            return;
        }

        mostrarMenuEscalas();
        int seleccionEscala = obtenerSeleccionValida(entrada, 1, PATRONES.length);
        if (seleccionEscala == -1) {
            entrada.close();
            return;
        }

        procesarSeleccion(seleccionNota - 1, seleccionEscala - 1);
        entrada.close();
    }

    static void mostrarMenuNotas() {
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.print((i + 1) + ": " + NOTAS[i]);
            if (i < NOTAS.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    static void mostrarMenuEscalas() {
        System.out.println();
        System.out.println("Seleccione el tipo de escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }
    }

    static int obtenerSeleccionValida(Scanner entrada, int min, int max) {
        int seleccion = entrada.nextInt();
        if (seleccion < min || seleccion > max) {
            System.out.println("Selección inválida");
            return -1;
        }
        return seleccion;
    }

    static void procesarSeleccion(int indiceNota, int indiceEscala) {
        String notaBase = NOTAS[indiceNota];
        String nombreEscala = NOMBRES_ESCALAS[indiceEscala];

        System.out.println();
        System.out.println("Ha elegido la nota " + notaBase);

        String[] escala = construirEscala(indiceNota, PATRONES[indiceEscala]);
        System.out.print("La escala de " + notaBase + " " + nombreEscala + " es: ");
        mostrarNotas(escala);

        String[] acorde = construirAcorde(escala);
        System.out.print("El acorde de " + notaBase + " " + nombreEscala + " está conformado por: ");
        mostrarNotas(acorde);
    }

    static String[] construirEscala(int indiceInicial, int[] patron) {
        String[] escala = new String[patron.length + 1];
        int indiceActual = indiceInicial;
        escala[0] = NOTAS[indiceActual];

        for (int i = 0; i < patron.length; i++) {
            indiceActual = (indiceActual + patron[i]) % 12;
            escala[i + 1] = NOTAS[indiceActual];
        }

        return escala;
    }

    static String[] construirAcorde(String[] escala) {
        return new String[] { escala[0], escala[2], escala[4] };
    }

    static void mostrarNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]");
            if (i < notas.length - 1)
                System.out.print(" / ");
        }
        System.out.println();
    }
}