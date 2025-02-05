import java.util.Scanner;

public class Escalas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] intervalos = {2, 2, 1, 2, 2, 2, 1}; 
        
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        int opcion = scanner.nextInt();
        
        if (opcion < 1 || opcion > 12) {
            System.out.println("Opción no válida.");
        } else {
            String notaBase = notas[opcion - 1];
            System.out.println("Ha elegido la nota " + notaBase);
            
            
            System.out.print("La escala de " + notaBase + " Mayor es: ");
            int indice = opcion - 1;
            System.out.print("[" + notas[indice] + "]");
            for (int i=0; i<notas.length; i++) {
                indice = (indice + i) % 12;
                System.out.print(" / [" + notas[indice] + "]");
            }
            System.out.println();
            
            
            int tercera = (opcion - 1 + 4) % 12; 
            int quinta = (opcion - 1 + 7) % 12; 
            
            System.out.println("El acorde de " + notaBase + " Mayor está conformado por: [" + notas[opcion - 1] + "] / [" + notas[tercera] + "] / [" + notas[quinta] + "]");
        }
        
        scanner.close();
    }
}
