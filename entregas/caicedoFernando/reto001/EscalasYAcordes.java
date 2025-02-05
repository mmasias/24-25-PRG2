package entregas.caicedoFernando.reto001;

import java.util.Scanner;

public class EscalasYAcordes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

        System.out.println(
                "Ingrese la nota, 0: Do, 1: Do#, 2: Re, 3: Re#, 4: Mi, 5: Fa, 6: Fa#, 7: Sol, 8: Sol#, 9: La, 10: La#, 11: Si");
        int eleccionUsuario = entrada.nextInt();

        String nota = notas[eleccionUsuario];
        System.out.println("Nota elegida: " + nota);

        System.out.print("Escala Mayor: ");
        imprimirEscalaMayor(notas, eleccionUsuario);

        System.out.print("Acorde Mayor: ");
        imprimirAcordeMayor(notas, eleccionUsuario);

        entrada.close();
    }

    public static void imprimirEscalaMayor(String[] notas, int posicionNotaUsuario) {
        final int MOVIMIENTO_TONO = 2;
        final int MOVIMIENTO_SEMITONO = 1;
        int[] movimientos = { MOVIMIENTO_TONO, MOVIMIENTO_TONO, MOVIMIENTO_SEMITONO, MOVIMIENTO_TONO, MOVIMIENTO_TONO,
                MOVIMIENTO_TONO, MOVIMIENTO_SEMITONO };
        for (int i = 0; i < 7; i++) {
            System.out.print("[" + notas[posicionNotaUsuario] + "] ");
            posicionNotaUsuario = (posicionNotaUsuario + movimientos[i]) % 12;
        }
        System.out.println();
    }

    public static void imprimirAcordeMayor(String[] notas, int posicionNotaUsuario) {
        System.out.println(
                "[" + notas[posicionNotaUsuario] + "] [" + notas[(posicionNotaUsuario + 4) % 12] + "] ["
                        + notas[(posicionNotaUsuario + 7) % 12] + "]");
    }
}