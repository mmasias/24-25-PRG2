import java.util.Scanner;

public class EscalasYAcordesExtendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        
        int[][] patrones = {
            {2, 2, 1, 2, 2, 2, 1}, // Mayor
            {2, 1, 2, 2, 1, 2, 2}, // Menor natural
            {2, 1, 2, 2, 1, 3, 1}, // Menor armónica
            {2, 1, 2, 2, 2, 2, 1}, // Menor melódica
            {2, 2, 3, 2, 3},       // Pentatónica mayor
            {3, 2, 2, 3, 2},       // Pentatónica menor
            {2, 1, 2, 2, 2, 1, 2}, // Dórica
            {1, 2, 2, 2, 1, 2, 2}, // Frigia
            {2, 2, 2, 1, 2, 2, 1}, // Lidia
            {2, 2, 1, 2, 2, 1, 2}, // Mixolidia
            {1, 2, 2, 1, 2, 2, 2}, // Locria
            {2, 2, 2, 2, 2, 2}     // Por tonos
        };
        
        String[] nombresEscalas = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"
        };
        
        System.out.print("Ingrese una nota (Do, Re, Mi, etc.): ");
        
        String notaBase = scanner.nextLine();
        
        int indice = getIndiceNota(notaBase, notas);
        
        
        for (int i = 0; i < patrones.length; i++) {
            imprimirEscala(notaBase, indice, notas, patrones[i], nombresEscalas[i]);
        }
        
        scanner.close();
    }
    
    static int getIndiceNota(String nota, String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(nota)) 
            return i;
        }
        return -1;
    }
    
    static void imprimirEscala(String notaBase, int indice, String[] notas, int[] patron, String nombreEscala) {
        System.out.println("Escala " + nombreEscala + " de " + notaBase + ":");
        System.out.print(notaBase + ", ");
        
        for (int i = 0; i < patron.length; i++) {
            int paso = patron[i];
            indice = (indice + paso) % 12;
            System.out.print(notas[indice] + ", ");
        }
        System.out.println("");
    }
}
