import java.util.Scanner;

public class reto001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] patron = {"T", "T", "S", "T", "T", "T", "S"};

        String notaBase = obtenerNotaBase(entrada, notas);
        if (notaBase == null) return;
        System.out.println("Ha elegido la nota " + notaBase);