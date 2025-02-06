import java.util.Scanner;

public class EscalaAcordeMayor {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[] PATRON_ESCALA_MAYOR = {0, 2, 4, 5, 7, 9, 11, 12};
    private static final int[] PATRON_ACORDE_MAYOR = {0, 4, 7};
    private static final int NOTA_MIN = 1;
    private static final int NOTA_MAX = 12;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota a trabajar (1: Do, 2: Do#, 3: Re, ..., 12: Si): ");
        
        if (scanner.hasNextInt()) {
            int notaUsuario = scanner.nextInt();
            if (notaUsuario >= NOTA_MIN && notaUsuario <= NOTA_MAX) {
                String notaBase = NOTAS[notaUsuario - 1];
                System.out.println("Ha elegido la nota " + notaBase);

                System.out.print("La escala de " + notaBase + " Mayor es: ");
                for (int intervalo : PATRON_ESCALA_MAYOR) {
                    System.out.print("[" + NOTAS[(notaUsuario - 1 + intervalo) % 12] + "] ");
                }
                System.out.println();

                System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
                for (int intervalo : PATRON_ACORDE_MAYOR) {
                    System.out.print("[" + NOTAS[(notaUsuario - 1 + intervalo) % 12] + "] ");
                }
                System.out.println();
            } else {
                System.out.println("Número inválido. Ingrese un número entre " + NOTA_MIN + " y " + NOTA_MAX + ".");
            }
        } else {
            System.out.println("Entrada inválida. Debe ingresar un número entero entre " + NOTA_MIN + " y " + NOTA_MAX + ".");
        }
        
        scanner.close();
    }
}
