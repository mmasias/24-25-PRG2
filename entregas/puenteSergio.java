import java.util.Scanner;

public class EscalasAcordes {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        mostrarOpciones();
        int opcion = obtenerEntradaUsuario(scanner);
        
        if (opcion == -1) {
            scanner.close();
            return;
        }
        
        int indiceNota = opcion - 1;
        String[] escalaMayor = construirEscalaMayor(indiceNota);
        String[] acordeMayor = {escalaMayor[0], escalaMayor[2], escalaMayor[4]};
        
        System.out.println("La escala de " + NOTAS[indiceNota] + " Mayor es: " + String.join(" / ", escalaMayor));
        System.out.println("El acorde de " + NOTAS[indiceNota] + " Mayor está conformado por: " + String.join(" / ", acordeMayor));
        
        scanner.close();
    }

    private static void mostrarOpciones() {
        System.out.println("Ingrese la nota a trabajar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
        System.out.print("Opción: ");
    }

    private static int obtenerEntradaUsuario(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return -1;
        }
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > NOTAS.length) {
            System.out.println("Opción inválida. Debe ingresar un número entre 1 y " + NOTAS.length + ".");
            return -1;
        }
        return opcion;
    }

    private static String[] construirEscalaMayor(int indiceNota) {
        String[] escalaMayor = new String[8];
        escalaMayor[0] = NOTAS[indiceNota];
        int posicion = indiceNota;
        for (int i = 0; i < PATRON_ESCALA_MAYOR.length; i++) {
            posicion = (posicion + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
            escalaMayor[i + 1] = NOTAS[posicion];
        }
        return escalaMayor;
    }
}

