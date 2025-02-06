import java.util.Scanner;

public class EscalasAcordes {
    private static final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
    private static final int[] PATRON_ESCALA_MAYOR = { 2, 2, 1, 2, 2, 2, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int eleccion = scanner.nextInt();

        if (eleccion < 1 || eleccion > 12) {
            System.out.println("Nota inválida. Por favor ingrese un número entre 1 y 12.");
            return;
        }

        String notaBase = NOTAS[eleccion - 1];
        System.out.println("Ha elegido la nota " + notaBase);

        String[] escalaMayor = construirEscalaMayor(eleccion - 1);
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        imprimirNotas(escalaMayor);

        String[] acordeMayor = construirAcordeMayor(escalaMayor);
        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        imprimirNotas(acordeMayor);
    }

    private static String[] construirEscalaMayor(int indiceNotaBase) {
        String[] escala = new String[8];
        int indiceActual = indiceNotaBase;

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[indiceActual];
            indiceActual = (indiceActual + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
        }
        escala[7] = NOTAS[indiceNotaBase];
        return escala;
    }

    private static String[] construirAcordeMayor(String[] escalaMayor) {
        return new String[] { escalaMayor[0], escalaMayor[2], escalaMayor[4] };
    }

    private static void imprimirNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]");
            if (i < notas.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
    }
}