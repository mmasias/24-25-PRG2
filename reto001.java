import java.util.Scanner;
public class reto001 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        System.out.println("Ingrese una la nota a trabajar: ");
        System.out.println("1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        
        int opcion = entrada.nextInt();





        entrada.close();
    }
}
