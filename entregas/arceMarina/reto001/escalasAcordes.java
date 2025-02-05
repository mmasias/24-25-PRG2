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
            imprimirAcordeMayor(notaSeleccionada, escalaMayor);
        } else {
            System.out.println("Número de nota no válido. Ingresa un valor entre 1 y 12.");
        }

        scanner.close();
    }

    public static String[] obtenerEscalaMayor(String notaBase, String[] tonos) {
        int[] intervalosEscalaMayor = { 2, 2, 1, 2, 2, 2, 1 };
        int posicionNotaBase = encontrarPosicion(notaBase, tonos);
        String[] escalaMayor = new String[8];
        escalaMayor[0] = notaBase;

        for (int indiceNota = 1; indiceNota < escalaMayor.length; indiceNota++) {
            posicionNotaBase = (posicionNotaBase + intervalosEscalaMayor[indiceNota - 1]) % tonos.length;
            escalaMayor[indiceNota] = tonos[posicionNotaBase];
        }

        return escalaMayor;

    }

    public static int encontrarPosicion(String notaBase, String[] tonos) {
        int posicion = 0;
        while (posicion < tonos.length) {
            if (tonos[posicion].equals(notaBase)) {
                return posicion;
            }
            posicion++;
        }
        return -1;
    }

    public static void imprimirEscalaMayor(String[] escalaMayor, String notaBase) {
        System.out.print("Escala mayor de " + notaBase + " es: ");
        for (int indiceNota = 0; indiceNota < escalaMayor.length; indiceNota++) {
            System.out.print("[" + escalaMayor[indiceNota] + "]");
            if (indiceNota < escalaMayor.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
    }

    public static void imprimirAcordeMayor(String notaBase, String[] escalaMayor) {
        String[] acordeMayor = { escalaMayor[0], escalaMayor[2], escalaMayor[4] };
        System.out.print("Acorde mayor de " + notaBase + " está conformado por:");
        for (String nota : acordeMayor) {
            System.out.print(" [" + nota + "]");
        }
        System.out.println();
    }
}
