import java.util.*;

public class Escalas_Y_Acordes {
    private static final String[][] notas = {
        {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"}
    };
    private static final int[] patron_escala_mayor = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indice_nota;
        
        do {
            System.out.println("Ingrese el número de la nota base (1: Do, 2: Do#, ..., 12: Si):");
            indice_nota = scanner.nextInt() - 1;
        } while (indice_nota < 0 || indice_nota >= notas[0].length);
        
        String nota_base = notas[0][indice_nota];
        System.out.println("Ha elegido la nota " + nota_base);
    }
}
