import java.util.Scanner;

public class Escalasyacordes {

    public static void main(String[] args) {

        String[] acordes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int[] intervalos = {2, 2, 1, 2, 2, 2, 1}; 

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese una nota (Do, Do#, Re, Re#, Mi, ...): ");
        int notaUsuario = scanner.nextInt();
        
        if (notaUsuario < 0 || notaUsuario >= acordes.length) {
            System.out.println("Nota inválida.");
            return;
        }

        String notaElegida = acordes[notaUsuario];
        System.out.println("Ha elegido la nota " + notaElegida);

        String[] escalaMayor = new String[7];
        int indice = notaUsuario;
        for (int i = 0; i < 7; i++) {
            escalaMayor[i] = acordes[indice];
            indice = (indice + intervalos[i]) % acordes.length;
        }

        System.out.print("La escala de " + notaElegida + " Mayor es: ");
        for (String nota : escalaMayor) {
            System.out.print(nota + " ");
        }
        System.out.println();

        String[] acordeMayor = {acordes[notaUsuario], acordes[(notaUsuario + 4) % acordes.length], acordes[(notaUsuario + 7) % acordes.length]};
        System.out.print("El acorde mayor de " + notaElegida + " está conformado por: ");
        for (String nota : acordeMayor) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }
}