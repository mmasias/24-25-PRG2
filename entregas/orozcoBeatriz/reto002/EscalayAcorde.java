
import java.util.Scanner;

public class EscalaYAcorde {

    static final String NOTAS_ESCALA_COMPLETA[] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_MEDIO = SEMITONO + TONO;

    static final int PATRON_ESCALA_MAYOR[] = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};
    static final int PATRON_ESCALA_MENOR_NATURAL[] = {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO};
    static final int PATRON_ESCALA_MENOR_ARMONICA[] = {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO};
    static final int PATRON_ESCALA_MENOR_MELODICA[] = {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO};
    static final int PATRON_PENTATONICA_MAYOR[] = {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO};
    static final int PATRON_PENTATONICA_MENOR[] = {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO};
    static final int PATRON_DORICA[] = {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO};
    static final int PATRON_FRIGIA[] = {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO};
    static final int PATRON_LIDIA[] = {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO};
    static final int PATRON_MIXOLIDIA[] = {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO};
    static final int PATRON_LOCRIA[] = {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO};
    static final int PATRON_POR_TONOS[] = {TONO, TONO, TONO, TONO, TONO, TONO};

    static final String[] ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int notaInicial, escalaElegida;
        int[] patronEscala;
        String[] escala;

        imprimirPeticionNotaUsuario();
        notaInicial = respuestaNotaUsuario(scanner);

        imprimirPeticionEscalaUsuario();
        escalaElegida = respuestaEscalaUsuario(scanner);

        patronEscala = calcularPatronEscala(escalaElegida);
        escala = calcularEscala(notaInicial, patronEscala);
        respuestaFinal(notaInicial, escala, patronEscala, escalaElegida);
        scanner.close();
    }

    static void imprimirPeticionNotaUsuario() {
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
    }

    static void imprimirPeticionEscalaUsuario() {
        
    }

    static int respuestaNotaUsuario(Scanner scanner) {
        int notaInicial, numeroUsuario = scanner.nextInt();
        notaInicial = numeroUsuario - 1;
        return notaInicial;
    }

    static int respuestaEscalaUsuario(Scanner scanner) {
        int escalaUsuario;
        escalaUsuario = scanner.nextInt();
        return escalaUsuario;
    }

    static String[] calcularEscala(int notaInicial, int[] patron) {
        String[] escala = new String[8];
        int posicionNotaActual = notaInicial;
        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS_ESCALA_COMPLETA[posicionNotaActual];
            posicionNotaActual = (posicionNotaActual + patron[i]) % NOTAS_ESCALA_COMPLETA.length;
        }
        escala[7] = escala[0];
        return escala;
    }

    static int[] calcularPatronEscala(int escalaElegida) {
        switch (escalaElegida) {
            case 1: return PATRON_ESCALA_MAYOR;
            case 2: return PATRON_ESCALA_MENOR_NATURAL;
            case 3: return PATRON_ESCALA_MENOR_ARMONICA;
            case 4: return PATRON_ESCALA_MENOR_MELODICA;
            case 5: return PATRON_PENTATONICA_MAYOR;
            case 6: return PATRON_PENTATONICA_MENOR;
            case 7: return PATRON_DORICA;
            case 8: return PATRON_FRIGIA;
            case 9: return PATRON_LIDIA;
            case 10: return PATRON_MIXOLIDIA;
            case 11: return PATRON_LOCRIA;
            case 12: return PATRON_POR_TONOS;
            default:
                System.out.println("Número de escala fuera de rango.");
                return null;
        }
    }    

    static void respuestaFinal(int notaInicial, String[] escala, int[] patron, int escalaElegida) {
        System.out.println("Ha elegido la nota " + NOTAS_ESCALA_COMPLETA[notaInicial]);
        escala = calcularEscala(notaInicial, patron);
        System.out.print("La escala" + ESCALAS[escalaElegida - 1] + " de " + NOTAS_ESCALA_COMPLETA[notaInicial] + " es: ");
        for (int i = 0; i < escala.length; i++) {
            System.out.print("[" + escala[i] + "] ");
        }
        System.out.println();
        System.out.println("El acorde de " + NOTAS_ESCALA_COMPLETA[notaInicial] + ESCALAS[escalaElegida - 1]  + " está conformado por: [" + 
                            escala[0] + "] / [" + escala[2] + "] / [" + escala[4] + "]");
    }
}
