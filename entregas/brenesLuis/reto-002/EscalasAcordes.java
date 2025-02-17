import java.util.Scanner;

public class EscalasAcordesCompleto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce un número según la nota musical que quieras obtener:");
        for (int i = 0; i < notasMusicales.length; i++) {
            System.out.println((i + 1) + ". " + notasMusicales[i]);
        }
        int notaSeleccionada = scanner.nextInt() - 1;
        
        System.out.println("Introduce un número según la escala que quieras obtener:");
        for (int i = 0; i < nombresEscalas.length; i++) {
            System.out.println((i + 1) + ". " + nombresEscalas[i]);
        }
        int escalaSeleccionada = scanner.nextInt() - 1;
        scanner.close();

        if (escalaSeleccionada >= 0 && escalaSeleccionada < escalas.length) {
            String escala = generarEscala(notaSeleccionada, escalas[escalaSeleccionada]);
            String acorde = generarAcorde(notaSeleccionada, escalas[escalaSeleccionada]);
            System.out.println("Escala " + nombresEscalas[escalaSeleccionada] + ": " + escala);
            System.out.println("Acorde " + nombresEscalas[escalaSeleccionada] + ": " + acorde);
        } else {
            System.out.println("Selección de escala no válida.");
        }
    }

    public static String[] notasMusicales = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa",
        "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    public final static int SEMITONO = 1, TONO = 2 * SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;

    public final static int[][] escalas = {
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

    public final static String[] nombresEscalas = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor",
        "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static String generarEscala(int notaSeleccionada, int[] intervalos) {
        StringBuilder escala = new StringBuilder(notasMusicales[notaSeleccionada]);
        int notaActual = notaSeleccionada;
        for (int intervalo : intervalos) {
            notaActual = (notaActual + intervalo) % 12;
            escala.append("-").append(notasMusicales[notaActual]);
        }
        return escala.toString();
    }

    public static String generarAcorde(int notaSeleccionada, int[] intervalos) {
        int tercera = (notaSeleccionada + intervalos[0] + intervalos[1]) % 12;
        int quinta = (notaSeleccionada + intervalos[0] + intervalos[1] + intervalos[2] + intervalos[3]) % 12;
        return notasMusicales[notaSeleccionada] + "-" + notasMusicales[tercera] + "-" + notasMusicales[quinta];
    }
}