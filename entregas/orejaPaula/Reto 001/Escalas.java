import java.util.*;

public class Escalas {
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
        List<String> escala_mayor = construir_escala_mayor(indice_nota);
        
        System.out.println("Ha elegido la nota " + nota_base);
        System.out.println("La escala de " + nota_base + " Mayor es: " + String.join(" / ", escala_mayor));
    }
    
    private static List<String> construir_escala_mayor(int indice_base) {
        List<String> escala = new ArrayList<>();
        int indice_actual = indice_base;
        int i = 0;
        
        while (i < patron_escala_mayor.length) {
            escala.add(notas[0][indice_actual % notas[0].length]);
            indice_actual += patron_escala_mayor[i];
            i++;
        }
        
        return escala;
    }
}
