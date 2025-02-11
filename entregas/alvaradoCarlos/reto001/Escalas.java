import java.util.Scanner;

class escalas {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, introduce el número entero de la nota correspondiente: \n(Do: 0, Do#: 1, Re: 2, Re#: 3, Mi: 4, Fa: 5, Fa#: 6, Sol: 7, Sol#: 8, La: 9, La#: 10, Si: 11)");
        System.out.println();
        int tono = sc.nextInt();

        String[] arrayNotas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        escalaMayor(arrayNotas, tono);
        acordeMayor(arrayNotas, tono);
    }

    public static void escalaMayor(String[] arrayNotas, int tono) {
        System.out.println("Escala mayor de " + arrayNotas[tono] + " mayor:");
        int[] intervalos = {0, 2, 4, 5, 7, 9, 11, 12};

        for (int i = 0; i < intervalos.length; i++) {
            System.out.print(arrayNotas[(tono + intervalos[i]) % arrayNotas.length] + " / ");
        }
        System.out.println();
    }

    public static void acordeMayor(String[] arrayNotas, int tono) {
        System.out.println("Acorde mayor de " + arrayNotas[tono] + " mayor:");
        int[] intervalos = {0, 4, 7};

        for (int i = 0; i < intervalos.length; i++) {
            System.out.print(arrayNotas[(tono + intervalos[i]) % arrayNotas.length] + " / ");
        }
        System.out.println();
    }
}