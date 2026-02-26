import java.util.Scanner;

class EscalasyAcordes {

    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int[] INTERVALOS_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una nota base ingresando un número entre 1 y 12: ");
        System.out.println("1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");

        int notaescogidausuario = scanner.nextInt() - 1;

        if (notaescogidausuario < 0 || notaescogidausuario >= NOTAS.length) {
            System.out.println("Selección no válida. Intente nuevamente con un número entre 1 y 12.");
            return;
        }

        String notaBase = NOTAS[notaescogidausuario];
        System.out.println("Has seleccionado la nota: " + notaBase);

        String[] escalaMayor = generarEscalaMayor(notaescogidausuario);
        String[] acordeMayor = obtenerAcordeMayor(escalaMayor);

        System.out.println("Escala mayor de " + notaBase + ":");
        mostrarNotas(escalaMayor);

        System.out.println("Acorde mayor de " + notaBase + " compuesto por:");
        mostrarNotas(acordeMayor);
    }

    static String[] generarEscalaMayor(int indiceNotaBase) {
        String[] escala = new String[8];
        int posicionActual = indiceNotaBase;

        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[posicionActual];
            posicionActual = (posicionActual + INTERVALOS_MAYOR[i]) % NOTAS.length;
        }

        escala[7] = NOTAS[indiceNotaBase]; 
        return escala;
    }

    static String[] obtenerAcordeMayor(String[] escalaMayor) {
        return new String[]{escalaMayor[0], escalaMayor[2], escalaMayor[4]};
    }

    static void mostrarNotas(String[] notas) {
        for (String nota : notas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }
}