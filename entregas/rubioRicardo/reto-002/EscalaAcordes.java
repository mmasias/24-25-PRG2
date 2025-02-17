import java.util.Scanner;

class EscalasAcordes {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
    static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONOYMEDIO = TONO + SEMITONO;

    static final int[][] INTERVALOS_ESCALAS = {
            { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO }, 
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO }, 
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO }, 
            { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO }, 
            { TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO }, 
            { TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO }, 
            { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO }, 
            { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO }, 
            { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO }, 
            { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO }, 
            { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO }, 
            { TONO, TONO, TONO, TONO, TONO, TONO } 
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nota = preguntarNota(scanner);
        int[] escalaSeleccionada = preguntarEscala(scanner);
        String[] escalaGenerada = calcularEscala(nota, escalaSeleccionada);
        String[] acorde = calcularAcorde(escalaGenerada);

        System.out.println("Escala en " + nota + ":");
        imprimirOrden(escalaGenerada);
        System.out.println("Acorde:");
        imprimirOrden(acorde);
        scanner.close();
    }

    static void imprimirOrden(String[] ordenNotas) {
        for (String nota : ordenNotas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    static String[] calcularAcorde(String[] escala) {
        return new String[] { escala[0], escala[2], escala[4] }; 
    }

    static String[] calcularEscala(String nota, int[] intervalos) {
        int posicionEnNotas = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length + 1];

        for (int i = 0; i < escala.length; i++) {
            escala[i] = NOTAS[posicionEnNotas];
            if (i < intervalos.length) {
                posicionEnNotas = (posicionEnNotas + intervalos[i]) % NOTAS.length;
            }
        }
        return escala;
    }

    static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota(Scanner scanner) {
        System.out.println("Selecciona una nota (1-12):");
        System.out.println(
                "1: DO, 2: DO#, 3: RE, 4: RE#, 5: MI, 6: FA, 7: FA#, 8: SOL, 9: SOL#, 10: LA, 11: LA#, 12: SI");
        int nota = scanner.nextInt();
        return NOTAS[nota - 1];
    }

    static int[] preguntarEscala(Scanner scanner) {
        System.out.println("Elige una escala (1-12):");
        System.out.println("1: Mayor, 2: Menor natural, 3: Menor armónica, 4: Menor melódica, 5: Pentatónica mayor, " +
                "6: Pentatónica menor, 7: Dórica, 8: Frigia, 9: Lidia, 10: Mixolidia, 11: Locria, 12: Por tonos");

        int escala = scanner.nextInt();
        return INTERVALOS_ESCALAS[escala - 1];
    }
}
