import java.util.Scanner;

public class Escalasyacordes {

    private static final int[] patron = {2, 2, 1, 2, 2, 2, 1};

    private static final String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce la nota base (por ejemplo, Do, Re#, Mi): ");
            String notaBase = scanner.nextLine(); 

            int indiceNotaBase = -1;
            for (int i = 0; i < notas.length; i++) {
                if (notas[i].equals(notaBase)) {
                    indiceNotaBase = i;
                }
            }

            if (indiceNotaBase == -1) {
                System.out.println("Nota inválida. Por favor, intenta de nuevo.");
                continue; 
            }

            String[] escalaMayor = construirEscalaMayor(indiceNotaBase);

            System.out.print("Escala mayor de " + notas[indiceNotaBase] + ": ");
            for (String nota : escalaMayor) {
                System.out.print(nota + " ");
            }
            System.out.println();

            System.out.println("Acorde mayor de " + notas[indiceNotaBase] + ": " + escalaMayor[0] + " " + escalaMayor[2] + " " + escalaMayor[4]);

            System.out.print("¿Quieres introducir otra nota? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")) {
                return; 
        }
    }
    }

    private static String[] construirEscalaMayor(int indiceNotaBase) {
        String[] escala = new String[7];
        int indiceActual = indiceNotaBase;

        for (int i = 0; i < 7; i++) {
            escala[i] = notas[indiceActual];
            indiceActual = (indiceActual + patron[i]) % notas.length;
        }

        return escala;
    }
}