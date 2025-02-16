import java.util.Scanner;

class EscalaAcorde {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };

    static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;
    
    static final int[][] INTERVALOS = {
        { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO }, 
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO }, 
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO }, 
        { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO }, 
        { TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO }, 
        { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO }, 
        { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO }, 
        { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO }, 
        { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO }, 
        { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO }, 
        { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO }, 
        { TONO, TONO, TONO, TONO, TONO, TONO } 
    };

    static final String[] NOMBRES_INTERVALOS = {
        "Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor",
        "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por Tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String nota = preguntarNota(scanner);
        int opcionIntervalo = preguntarIntervalo(scanner);
        
        String[] escala = construirEscala(nota, INTERVALOS[opcionIntervalo]);
        String[] acorde = construirAcorde(escala);
        
        System.out.println("Escala " + NOMBRES_INTERVALOS[opcionIntervalo] + ":");
        mostrarSecuencia(escala);
        System.out.println("Acorde:");
        mostrarSecuencia(acorde);
    }

    static void mostrarSecuencia(String[] secuenciaNotas) {
        for (String nota : secuenciaNotas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    static String[] construirAcorde(String[] escala) {
        return new String[] { escala[0], escala[2], escala[4] };
    }

    static String[] construirEscala(String nota, int[] intervalos) {
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
        System.out.println("Elige una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        int nota = scanner.nextInt();
        return NOTAS[nota - 1];
    }

    static int preguntarIntervalo(Scanner scanner) {
        System.out.println("Elige un intervalo:");
        for (int i = 0; i < NOMBRES_INTERVALOS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_INTERVALOS[i]);
        }
        return scanner.nextInt() - 1;
    }
}
