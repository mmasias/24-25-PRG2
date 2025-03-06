package reto002;
import java.util.Scanner;

class EscalasYAcordesPlus {

    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_MEDIO = TONO + SEMITONO;
    static final int[][] PATRONES_ESCALAS = {
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
    static final String[] NOMBRES_ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica", 
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", 
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };
    static final int I = 0, III = 2, V = 4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int eleccionNota = scanner.nextInt() - 1;

        if (eleccionNota < 0 || eleccionNota >= NOTAS.length) {
            System.out.println("Elección inválida. Por favor ingrese un número entre 1 y 12.");
            return;
        }

        System.out.println("Seleccione la escala a trabajar:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }
        int eleccionEscala = scanner.nextInt() - 1;

        if (eleccionEscala < 0 || eleccionEscala >= NOMBRES_ESCALAS.length) {
            System.out.println("Elección inválida. Por favor ingrese un número válido.");
            return;
        }

        String notaBase = NOTAS[eleccionNota];
        System.out.println("Ha elegido la nota " + notaBase + " y la escala " + NOMBRES_ESCALAS[eleccionEscala]);
        String[] escala = construirEscala(eleccionNota, PATRONES_ESCALAS[eleccionEscala]);
        String[] acorde = construirAcorde(escala);

        System.out.println("La escala de " + notaBase + " " + NOMBRES_ESCALAS[eleccionEscala] + " es: ");
        imprimirNotas(escala);
        System.out.println("El acorde de " + notaBase + " " + NOMBRES_ESCALAS[eleccionEscala] + " está conformado por: ");
        imprimirNotas(acorde);
    }

    static String[] construirEscala(int notaBase, int[] patron) {
        String[] escala = new String[patron.length + 1];
        int notaActual = notaBase;

        for (int i = 0; i < patron.length; i++) {
            escala[i] = NOTAS[notaActual];
            notaActual = (notaActual + patron[i]) % NOTAS.length;
        }

        escala[patron.length] = NOTAS[notaBase];
        return escala;
    }

    static String[] construirAcorde(String[] escala) {
        return new String[]{escala[I], escala[III], escala[V]};
    }

    static void imprimirNotas(String[] notas) {
        for (String nota : notas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }
}
