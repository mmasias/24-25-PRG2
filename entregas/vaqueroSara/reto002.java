
import java.util.Scanner;

public class reto002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        int[] patronEscalaMayor = {2, 2, 1, 2, 2, 2, 1};

        System.out.print("Ingrese una nota (Do, Re, Mi, etc.): ");

        String notaBase = scanner.nextLine();

        int indice = -1;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(notaBase)) {
                indice = i;
            }
        }

        boolean notaValida = indice != -1;

        if (notaValida) {
            
            for (int j = 0; j < patronEscalaMayor.length; j++) {

                String notaEscalaMayor = CalcularEscala(j, notas, patronEscalaMayor, indice);
                System.out.println(notaEscalaMayor);
            }

        }

        scanner.close();

    }

    static String CalcularEscala(int j, String[] notas, int[] patron, int indice) {

        indice += patron[j];
        indice = indice % 12;
        return (notas[indice]);

    }

}
