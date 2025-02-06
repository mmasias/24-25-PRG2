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
        
        
