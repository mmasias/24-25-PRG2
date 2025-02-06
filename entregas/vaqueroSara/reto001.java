import java.util.Scanner;

public class reto001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        int[] patron = {2, 2, 1, 2, 2, 2, 1};

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
            
            System.out.print("Escala mayor de " + notaBase + ": ");
            int pos = indice;  
            System.out.print(notas[pos] + " ");  
            for (int i = 0; i < patron.length; i++) {
                pos += patron[i]; 
                pos = pos % 12;  
                System.out.print(notas[pos] + " ");
            }
            System.out.println();

           
            System.out.print("Acorde mayor de " + notaBase + ": ");
            System.out.println(notas[indice] + " " + notas[(indice + 4) % 12] + " " + notas[(indice + 7) % 12]);
        } else {
            System.out.println("Nota no válida. Intente nuevamente.");
        }

        scanner.close();
    }
}