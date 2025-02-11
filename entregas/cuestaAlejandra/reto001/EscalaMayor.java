import java.util.Scanner;

public class EscalaMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] tonos = {2, 2, 1, 2, 2, 2, 1}; 
        System.out.println("Ingrese una nota:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println(i + 1 + ": " + notas[i]);
        }
        
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > notas.length) {
            System.out.println("Opcion no valida.");
            return;
        }

        String notaBase = notas[opcion - 1];
        System.out.println("Ha elegido la nota " + notaBase);
        
        String[] escala = new String[7];
        int indice = opcion - 1;
        for (int i = 0; i < 7; i++) {
            escala[i] = notas[indice % notas.length];
            indice += tonos[i];
        }

        System.out.println("La escala de " + notaBase + " Mayor es: " + String.join(" ", escala));

        System.out.println("El acorde de " + notaBase + " Mayor está conformado por: [" + 
                           escala[0] + ", " + escala[2] + ", " + escala[4] + "]");

        scanner.close();
    }
}
