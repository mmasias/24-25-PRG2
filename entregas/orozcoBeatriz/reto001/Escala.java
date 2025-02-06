import java.util.Scanner;

public class Escala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String notasEscalaCompleta [] = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int notaInicial, numeroUsuario;
        
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        numeroUsuario = scanner.nextInt();
        notaInicial = numeroUsuario - 1;
        System.out.println("Ha elegido la nota " + notasEscalaCompleta[notaInicial]);

    }
}
