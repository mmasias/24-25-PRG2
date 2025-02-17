import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int TONO = 2, SEMITONO = 1;
    
    static final int[][] ESCALAS = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},  // Mayor
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO}   // Menor natural
    };
    
    static final String[] NOMBRES_ESCALAS = {"Mayor", "Menor natural"};
    
    public static void main(String[] args) {
        int notaBase = obtenerNotaBase();
        int tipoEscala = obtenerTipoEscala();
        
        String[] escala = construirEscala(notaBase, ESCALAS[tipoEscala]);
        String[] acorde = {escala[0], escala[2], escala[4]};
        
        System.out.println("Escala " + NOMBRES_ESCALAS[tipoEscala] + " de " + NOTAS[notaBase] + ": " + String.join(" - ", escala));
        System.out.println("Acorde de " + NOTAS[notaBase] + ": " + String.join(" - ", acorde));
    }

    static int obtenerNotaBase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la nota base:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        int opcion = scanner.nextInt() - 1;
        return (opcion >= 0 && opcion < NOTAS.length) ? opcion : 0;
    }

    static int obtenerTipoEscala() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }
        int opcion = scanner.nextInt() - 1;
        return (opcion >= 0 && opcion < NOMBRES_ESCALAS.length) ? opcion : 0;
    }

    static String[] construirEscala(int notaBase, int[] patron) {
        String[] escala = new String[patron.length + 1];
        escala[0] = NOTAS[notaBase];
        int posicion = notaBase;
        for (int i = 0; i < patron.length; i++) {
            posicion = (posicion + patron[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[posicion];
        }
        return escala;
    }
}
