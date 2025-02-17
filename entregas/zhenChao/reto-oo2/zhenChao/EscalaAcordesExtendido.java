
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
        { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO }, 
        { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO }, 
        { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO }, 
        { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO }, 
        { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO }, 
        { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO }, 
        { TONO, TONO, TONO, TONO, TONO, TONO } 
    };
     static final String[] NOMBRE_INTERVALOS_DE_LAS_ESCALAS = {"Mayor", "Menor", "Menor Armónica", "Menor Melódica", "Pentatónica Mayor", "Pentatónica Menor"};
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroNota = pedirNota();
        String[] escalaMayor = construirEscala(nota, INTERVALOS_DE_LAS_ESCALAS[escala]);
        String[] acordeMayor = construirAcordeMayor(escalaMayor);
        int opcionEscala = pedirTipoEscala(entrada);
        System.out.println("Acorde mayor: " + acordeMayor[0] + " - " + acordeMayor[1] + " - " + acordeMayor[2]);
        mostrarEscala(escalaMayor);  
    }
    public static int pedirNota() {
        Scanner entrada = new Scanner(System.in);
        int numeroNota;
        do {
            System.out.println("Elige una nota:");
            for (int i = 0; i < NOTAS.length; i++) {
                System.out.println((i + 1) + ": " + NOTAS[i]);
            }
            System.out.print("Introduce un número (1-12): ");
            numeroNota = entrada.nextInt();
        } while (numeroNota < 1 || numeroNota > 12);

        entrada.close(); 
        return numeroNota;
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

    public static String[] construirAcordeMayor(String[] escala) {
        return new String[]{escala[0], escala[2], escala[4]};
    }
    public static void mostrarEscala(String[] escala) {
        System.out.println("Escala mayor:");

        for (int i = 0; i < escala.length; i++) {
            System.out.print(escala[i] + "----" );
           
        }
        System.out.println();
    }

    
}