import java.util.Scanner;

public class EscalaAcordesExtendido {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;
    
    static final int[][] INTERVALOS_DE_LAS_ESCALAS = {
        { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO }, 
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO }, 
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO }, 
        { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO }, 
        { TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO }, 
        { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO }
    };

    static final String[] NOMBRE_INTERVALOS_DE_LAS_ESCALAS = {"Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor"};

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String notaBase = pedirNota(entrada);
        int tipoEscala = pedirTipoEscala(entrada);
        
        String[] escala = construirEscala(notaBase, INTERVALOS_DE_LAS_ESCALAS[tipoEscala]);
        String[] acorde = construirAcorde(escala);
        
        System.out.println("Escala " + NOMBRE_INTERVALOS_DE_LAS_ESCALAS[tipoEscala] + ":");
        imprimirSecuencia(escala);
        System.out.println("Acorde:");
        imprimirSecuencia(acorde);
    }

    static String pedirNota(Scanner entrada) {
        System.out.println("Elige una nota:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        int opcionNota;
        do {
            System.out.print("Introduce un número (1-12): ");
            opcionNota = entrada.nextInt();
        } while (opcionNota < 1 || opcionNota > 12);

        return NOTAS[opcionNota - 1];
    }

    static int pedirTipoEscala(Scanner entrada) {
        System.out.println("Elige un tipo de escala:");
        for (int i = 0; i < NOMBRE_INTERVALOS_DE_LAS_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRE_INTERVALOS_DE_LAS_ESCALAS[i]);
        }
        int opcion;
        do {
            System.out.print("Introduce un número válido: ");
            opcion = entrada.nextInt();
        } while (opcion < 1 || opcion > NOMBRE_INTERVALOS_DE_LAS_ESCALAS.length);
        
        return opcion - 1;
    }

    static String[] construirEscala(String nota, int[] intervalos) {
        int posicionNota = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length + 1];
        
        for (int i = 0; i < escala.length; i++) {
            escala[i] = NOTAS[posicionNota];
            if (i < intervalos.length) {
                posicionNota = (posicionNota + intervalos[i]) % NOTAS.length;
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

    static String[] construirAcorde(String[] escala) {
        if (escala.length < 5) {
            return new String[]{escala[0], escala[1], escala[2]};
        }
        return new String[]{escala[0], escala[2], escala[4]};
    }

    static void imprimirSecuencia(String[] secuencia) {
        for (String nota : secuencia) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }
}
