import java.util.Scanner;

class EscalasAcordes {
    static final String[] NOTAS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa",
            "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    public static void main(String[] args) {
        EscalasAcordes.ejecutarGeneradorEscalas();
    }

    static int[] obtenerPatronEscala(String nombreEscala) {
        if (nombreEscala.equalsIgnoreCase("Mayor"))
            return new int[] { 2, 2, 1, 2, 2, 2, 1 };
        if (nombreEscala.equalsIgnoreCase("Menor Natural"))
            return new int[] { 2, 1, 2, 2, 1, 2, 2 };
        if (nombreEscala.equalsIgnoreCase("Menor Armónica"))
            return new int[] { 2, 1, 2, 2, 1, 3, 1 };
        if (nombreEscala.equalsIgnoreCase("Menor Melódica"))
            return new int[] { 2, 1, 2, 2, 2, 2, 1 };
        if (nombreEscala.equalsIgnoreCase("Pentatónica Mayor"))
            return new int[] { 2, 2, 3, 2, 3 };
        if (nombreEscala.equalsIgnoreCase("Pentatónica Menor"))
            return new int[] { 3, 2, 2, 3, 2 };
        if (nombreEscala.equalsIgnoreCase("Dórica"))
            return new int[] { 2, 1, 2, 2, 2, 1, 2 };
        if (nombreEscala.equalsIgnoreCase("Frigia"))
            return new int[] { 1, 2, 2, 2, 1, 2, 2 };
        if (nombreEscala.equalsIgnoreCase("Lidia"))
            return new int[] { 2, 2, 2, 1, 2, 2, 1 };
        if (nombreEscala.equalsIgnoreCase("Mixolidia"))
            return new int[] { 2, 2, 1, 2, 2, 1, 2 };
        if (nombreEscala.equalsIgnoreCase("Locria"))
            return new int[] { 1, 2, 2, 1, 2, 2, 2 };
        if (nombreEscala.equalsIgnoreCase("Por Tonos"))
            return new int[] { 2, 2, 2, 2, 2, 2 };
        return null;
    }

    static String[] obtenerNombresEscalas() {
        return new String[] {
                "Mayor", "Menor Natural", "Menor Armónica", "Menor Melódica",
                "Pentatónica Mayor", "Pentatónica Menor", "Dórica", "Frigia",
                "Lidia", "Mixolidia", "Locria", "Por Tonos"
        };
    }

    static void ejecutarGeneradorEscalas() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la nota de la escala: ");
        String notaRaiz = teclado.nextLine();

        String[] nombresEscalas = obtenerNombresEscalas();
        for (int i = 0; i < nombresEscalas.length; i++) {
            generarEscala(notaRaiz, nombresEscalas[i]);
        }

        teclado.close();
    }

    static void generarEscala(String notaRaiz, String nombreEscala) {
        int indiceInicial = buscarIndiceNota(notaRaiz);

        if (indiceInicial == -1) {
            System.out.println("Nota no válida.");
            return;
        }

        int[] patronEscala = obtenerPatronEscala(nombreEscala);
        if (patronEscala == null) {
            System.out.println("Escala no reconocida.");
            return;
        }

        String[] escala = new String[patronEscala.length + 1];
        escala[0] = NOTAS[indiceInicial];

        int indiceActual = indiceInicial;
        for (int i = 0; i < patronEscala.length; i++) {
            indiceActual = (indiceActual + patronEscala[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[indiceActual];
        }

        System.out.print("Escala " + nombreEscala + ": ");
        for (int i = 0; i < escala.length; i++) {
            System.out.print(escala[i] + " ");
        }
        System.out.println();

        generarAcorde(escala);
    }

    static void generarAcorde(String[] escala) {
        System.out.println("Acorde de la escala: " + escala[0] + " " + escala[2] + " " + escala[4]);
    }

    static int buscarIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (NOTAS[i].equalsIgnoreCase(nota)) {
                return i;
            }
        }
        return -1;
    }
}
