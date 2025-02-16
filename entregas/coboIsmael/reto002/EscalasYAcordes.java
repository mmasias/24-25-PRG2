package entregas.coboIsmael.reto002;

import java.util.Scanner;

public class EscalasYAcordes {
    public static void main(String[] args) {

        final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        final String[] NOMBRES_ESCALAS = {"Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"};
        final int SEMITONO = 1;
        final int TONO = SEMITONO + SEMITONO;
        final int TONOYMEDIO = TONO + SEMITONO;
        final int[][] PATRONES = {
            {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
            {TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO},
            {TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO},  
            {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
            {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
            {TONO, TONO, TONO, TONO, TONO, TONO}
        };

        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Ingrese la nota a trabajar (1-12): ");
        int notaBase = entradaUsuario.nextInt() - 1;

        if (notaBase < 0 || notaBase >= NOTAS.length) {
            System.out.println("Nota no válida.");
            return;
        }

        System.out.println("Seleccione la escala:");
        for (int i = 0; i < NOMBRES_ESCALAS.length; i++) {
            System.out.println((i + 1) + ": " + NOMBRES_ESCALAS[i]);
        }

        int escalaSeleccionada = entradaUsuario.nextInt() - 1;
        if (escalaSeleccionada < 0 || escalaSeleccionada >= NOMBRES_ESCALAS.length) {
            System.out.println("Escala no válida.");
            return;
        }

        System.out.println("Ha elegido la nota " + NOTAS[notaBase] + " y la escala " + NOMBRES_ESCALAS[escalaSeleccionada]);
        String[] escala = construirEscala(notaBase, NOTAS, PATRONES[escalaSeleccionada]);
        construirAcorde(escala, NOTAS[notaBase]);

        entradaUsuario.close();
    }

    public static String[] construirEscala(int notaBase, String[] NOTAS, int[] PATRONES) {
        String[] escala = new String[PATRONES.length + 1];
        escala[0] = NOTAS[notaBase];
        int indiceActual = notaBase;

        for (int i = 1; i < escala.length; i++) {
            indiceActual = (indiceActual + PATRONES[i - 1]) % NOTAS.length;
            escala[i] = NOTAS[indiceActual];
        }

        System.out.print("La escala es: ");
        for (String nota : escala) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();
        return escala;
    }
    
    public static void construirAcorde(String[] escala, String notaBase) {
        if (escala.length < 5) {
            System.out.println("No se puede construir el acorde.");
            return;
        }
        String[] acorde = {escala[0], escala[2], escala[4]};
        System.out.print("El acorde de " + notaBase + " está conformado por: ");
        for (String nota : acorde) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();
    }
}