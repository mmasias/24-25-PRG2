import java.util.Scanner;

class EscalasYAcordes {

    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int eleccion = scanner.nextInt() - 1;

        if (eleccion < 0 || eleccion >= NOTAS.length) {
            System.out.println("Elección inválida. Por favor ingrese un número entre 1 y 12.");
            return;
        }

        String notaBase = NOTAS[eleccion];
        System.out.println("Ha elegido la nota " + notaBase);
        String[] escalaMayor = construirEscalaMayor(eleccion);
        String[] acordeMayor = construirAcordeMayor(escalaMayor);

        System.out.println("La escala de " + notaBase + " Mayor es: ");
        imprimirNotas(escalaMayor);
        System.out.println("El acorde de " + notaBase + " Mayor está conformado por: ");
        imprimirNotas(acordeMayor);
    }

    static String[] construirEscalaMayor(int notaBase) {
        String[] escala = new String[8];
        int notaActual = notaBase;

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[notaActual];
            notaActual = (notaActual + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
        }

        escala[7] = NOTAS[notaBase]; // agregar la nota base al final para completar la octava
        return escala;
    }

    static String[] construirAcordeMayor(String[] escalaMayor) {
        return new String[]{escalaMayor[0], escalaMayor[2], escalaMayor[4]};
    }

    static void imprimirNotas(String[] notas) {
        for (String nota : notas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }
}
