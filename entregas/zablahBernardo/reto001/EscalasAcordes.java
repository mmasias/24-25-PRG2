import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tonos = {
                "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
        };

        System.out.print("Ingrese una la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");
        System.out.println();
        int notaBase = scanner.nextInt();
        
        if (notaBase >= 1 && notaBase <= 12) {
            String notaSeleccionada = tonos[notaBase - 1];
            System.out.println("La nota seleccionada es: " + notaSeleccionada);
            String[] escalaMayor = obtenerEscalaMayor(notaSeleccionada, tonos);
            imprimirEscalaMayor(escalaMayor, notaSeleccionada);
            obtenerAndImprimirAcordeMayor(notaSeleccionada, escalaMayor);
        } else {
            System.out.println("Número de nota no válido. Ingresa un valor entre 1 y 12.");
        }

    }

    public static String[] obtenerEscalaMayor(String notaBase, String[] tonos) {
        int[] intervalosEscalaMayor = { 2, 2, 1, 2, 2, 2, 1 };
        int posicionNotaBase = -1;
        int posicionActual = 0;
        int contadorNotas = 1;

        String[] escalaMayor = new String[8];
        escalaMayor[0] = notaBase;

        while (posicionActual < tonos.length) {
            if (tonos[posicionActual] == notaBase) {
                posicionNotaBase = posicionActual;
            }
            posicionActual++;
        }

        while (contadorNotas < escalaMayor.length) {
            posicionNotaBase = (posicionNotaBase + intervalosEscalaMayor[contadorNotas - 1]) % tonos.length;
            escalaMayor[contadorNotas] = tonos[posicionNotaBase];
            contadorNotas++;
        }

        return escalaMayor;

    }

    public static void imprimirEscalaMayor(String[] escalaMayor, String notaBase) {
        int variableImprimir = 0;
        System.out.print("Escala mayor de " + notaBase + " es :");
        while (variableImprimir < escalaMayor.length) {
            System.out.print(" [" + escalaMayor[variableImprimir] + "] / ");
            variableImprimir++;
        }
        System.out.println();
    }

    public static String[] obtenerAndImprimirAcordeMayor(String notaBase, String[] escalaMayor) {
        String[] acordeMayor = new String[3];
        int variableImprimir = 0;

        acordeMayor[0] = escalaMayor[0];
        acordeMayor[1] = escalaMayor[2];
        acordeMayor[2] = escalaMayor[4];

        System.out.print("Acorde mayor de " + notaBase + " esta conformado por:");
        for (variableImprimir = 0; variableImprimir < acordeMayor.length; variableImprimir++) {
            System.out.print(" [" + acordeMayor[variableImprimir] + "] / ");
        }
        System.out.println();

        return acordeMayor;
    }
}