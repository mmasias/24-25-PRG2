package entregas.linaresJaime;
import java.util.Scanner;

public class reto001 {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Seleccione la nota base para la escala mayor:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.print((i + 1) + ": " + NOTAS[i] + ", ");
        }
        
        int opcion = scanner.nextInt();
        scanner.close();

        if (opcion < 1 || opcion > NOTAS.length) {
            System.out.println("Opción no válida.");
            return;
        }
        
        String notaBase = NOTAS[opcion - 1];
        System.out.println("Ha elegido la nota " + notaBase);

        String[] escalaMayor = construirEscala(opcion - 1);
        System.out.println("La escala de " + notaBase + " Mayor es: " + String.join(" / ", escalaMayor));

        String[] acordeMayor = {escalaMayor[0], escalaMayor[2], escalaMayor[4]};
        System.out.println("El acorde de " + notaBase + " Mayor está conformado por: " + String.join(" / ", acordeMayor));
    }

    private static String[] construirEscala(int indiceInicial) {
        String[] escala = new String[8]; 
        int indiceActual = indiceInicial;
        
        for (int i = 0; i < 7; i++) {
            escala[i] = NOTAS[indiceActual % NOTAS.length];
            indiceActual += PATRON_ESCALA_MAYOR[i];
        }
        escala[7] = NOTAS[indiceInicial % NOTAS.length]; 
        
        return escala;
    }
}
