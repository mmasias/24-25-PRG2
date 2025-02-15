
import java.util.Scanner;

public class EscalasYAcordesExtendido{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        int[] patronEscalaMayor = {2, 2, 1, 2, 2, 2, 1};

        String notaEscalaMayor;

        System.out.print("Ingrese una nota (Do, Re, Mi, etc.): ");

        String notaBase = scanner.nextLine();

        int indice = -1;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(notaBase)) {
                indice = i;
            }
        }

        System.out.println("Escala mayor de "+notaBase);
        System.out.println(notaBase);

        for (int i = 0; i < patronEscalaMayor.length; i++) {
            indice += (patronEscalaMayor[i]);
            notaEscalaMayor = CalcularEscala(i, notas, patronEscalaMayor, indice);
            System.out.println(notaEscalaMayor);
        }

        scanner.close();

    }

    static String CalcularEscala(int i, String[] notas, int[] patron, int indice) {

        indice = indice % 12;
        return (notas[indice]);

    }

}
