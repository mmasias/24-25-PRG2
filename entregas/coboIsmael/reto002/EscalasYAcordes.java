package entregas.coboIsmael.reto002;

import java.util.Scanner;

public class EscalasYAcordes {
    public static void main(String[] args) {

        static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        static final String[] NOMBRES_ESCALAS = {"Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"};
        static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONOYMEDIO = TONO + SEMITONO;
        static final int[][] PATRONES = {
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
}