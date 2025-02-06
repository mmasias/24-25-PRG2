import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) {

        String[] acordes = { "Do", "Do#", "Re", "Re#",
                            "Mi", "Fa", "Fa#", "Sol",
                            "Sol#", "La", "La#", "Si" };

        int[] intervalos = { 2, 2, 1, 2, 2, 2, 1 };

        Scanner scanner = new Scanner(System.in);
        int imputUsuario = preguntarNotaUsuario(scanner);

        String notaElegida = acordes[imputUsuario];
        System.out.println("Ha elegido la nota " + notaElegida);

        String[] escalaMayor = obtenerEscalaMayor(acordes, intervalos, imputUsuario);
        mostrarEscalaMayor(acordes, escalaMayor);

        String[] acordeMayor = obtenerAcordeMayor(acordes, imputUsuario);
        mostrarAcordeMayor(notaElegida, acordeMayor);
    }

    private static int preguntarNotaUsuario(Scanner scanner) {
        System.out.println("Ingrese una nota a trabajar: 0: Do, 1: Do#, 2: Re, 3: Re#, 4: Mi, ...");
        return scanner.nextInt();
    }

    private static String[] obtenerEscalaMayor(String[] acordes, int[] intervalos, int imputUsuario) {
        String[] escalaMayor = new String[8];
        int indice = imputUsuario;
        for (int i = 0; i < 7; i++) {
            escalaMayor[i] = acordes[indice];
            indice = (indice + intervalos[i]) % 12;
        }
        escalaMayor[7] = escalaMayor[0];
        return escalaMayor;
    }

    private static void mostrarEscalaMayor(String[] notaElegida, String[] escalaMayor) {
        System.out.print("La escala de " + notaElegida + " Mayor es: ");
        for (String nota : escalaMayor) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();
    }

    public static String[] obtenerAcordeMayor(String[] acordes, int imputUsuario) {
        return new String[] 
        {
                acordes[imputUsuario],
                acordes[(imputUsuario + 4) % 12],
                acordes[(imputUsuario + 7) % 12]
        };
    }

    private static void mostrarAcordeMayor(String notaElegida, String[] acordeMayor) {
        System.out.print("El acorde de " + notaElegida + " Mayor está conformado por: ");
        for (String nota : acordeMayor) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();
    }
}
