import java.util.Scanner;

class EscalaAcordee {
    static final String[] NOTAS = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};
    
    static final int SEMITONO = 1, TONO = 2, TONO_Y_MEDIO = 3;
    
    static final int[][] INTERVALOS = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
        {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO},
        {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
        {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
        {TONO, TONO, TONO, TONO, TONO, TONO}
    };
    
    static final String[] TIPOS_ESCALAS = {
        "Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor",
        "Pentatónica Menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por Tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String notaBase = solicitarNota(scanner);
        int tipoEscala = solicitarEscala(scanner);
        
        String[] escala = generarEscala(notaBase, INTERVALOS[tipoEscala]);
        String[] acorde = generarAcorde(escala);
        
        System.out.println("Escala " + TIPOS_ESCALAS[tipoEscala] + ":");
        imprimirNotas(escala);
        System.out.println("Acorde:");
        imprimirNotas(acorde);
    }
    
    static void imprimirNotas(String[] notas) {
        for (String nota : notas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }
    
    static String[] generarAcorde(String[] escala) {
        return new String[]{escala[0], escala[2], escala[4]};
    }
    
    static String[] generarEscala(String nota, int[] intervalos) {
        int posicion = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length + 1];
        
        for (int i = 0; i < escala.length; i++) {
            escala[i] = NOTAS[posicion];
            if (i < intervalos.length) {
                posicion = (posicion + intervalos[i]) % NOTAS.length;
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
    
    static String solicitarNota(Scanner scanner) {
        System.out.println("Selecciona una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        return NOTAS[scanner.nextInt() - 1];
    }
    
    static int solicitarEscala(Scanner scanner) {
        System.out.println("Elige un tipo de escala:");
        for (int i = 0; i < TIPOS_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + TIPOS_ESCALAS[i]);
        }
        return scanner.nextInt() - 1;
    }
}

