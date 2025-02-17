import java.util.Scanner;

public class EscalasAcordes2 {

    static final String[] TONOS = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };
    static final int SEMITONO = 1;
    static final int TONO = 2 * SEMITONO;
    static final int TONO_Y_MEDIO = TONO + SEMITONO;

    static final int[][] ESCALAS = {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce la nota base (por ejemplo, Do, Re#, Mi): ");
            String notaBase = scanner.nextLine(); 

            int indiceNotaBase = obtenerIndiceNota(notaBase);

            if (indiceNotaBase == -1) {
                System.out.println("Nota inválida. Por favor, intenta de nuevo.");
                continue; 
            }

            String[] escalaMayor = construirEscalaMayor(indiceNotaBase);

            System.out.print("Escala mayor de " + TONOS[indiceNotaBase] + ": ");
            for (String nota : escalaMayor) {
                System.out.print(nota + " ");
            }
            System.out.println();

            System.out.println("Acorde mayor de " + TONOS[indiceNotaBase] + ": " + escalaMayor[0] + " " + escalaMayor[2] + " " + escalaMayor[4]);

            System.out.print("¿Quieres introducir otra nota? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("n")) {
                return; 
            }
        }
    }

    private static int obtenerIndiceNota(String notaBase) {
        for (int i = 0; i < TONOS.length; i++) {
            if (TONOS[i].equals(notaBase)) {
                return i;
            }
        }
        return -1;
    }

    private static String[] construirEscalaMayor(int indiceNotaBase) {
        String[] escala = new String[7];
        int indiceActual = indiceNotaBase;
        int[] patronEscala = ESCALAS[0]; // Escala mayor es el primer patrón en ESCALAS

        for (int i = 0; i < 7; i++) {
            escala[i] = TONOS[indiceActual];
            indiceActual = (indiceActual + patronEscala[i]) % TONOS.length;
        }

        return escala;
    }
}