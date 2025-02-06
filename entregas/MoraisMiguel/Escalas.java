import java.util.Scanner;

class Escalas{

    public static void main(String[] args) {

        int notaUsuario = pedirNota();

        String[] escala = crearEscala(notaUsuario);

        String[] acorde = crearAcorde(escala);

        printEscala(notaUsuario, escala);

        printAcorde(notaUsuario, acorde);
    }

    static void printEscala(int notaUsuario, String[] escala) {

            String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

            System.out.print("El acorde de " + notas[notaUsuario] + " Mayor es: ");

            for (int i = 0; i < escala.length; i++) {

                System.out.print("[" + escala[i] + "]");

                if (i < escala.length - 1) {System.out.print(" / ");};
            }

            System.out.println();

    }

    static void printAcorde(int notaUsuario, String[] acorde) {

            String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

            System.out.print("La escala de " + notas[notaUsuario] + " Mayor es: ");

            for (int i = 0; i < acorde.length; i++) {

                System.out.print("[" + acorde[i] + "]");

                if (i < acorde.length - 1){System.out.print(" / ");};

            }

            System.out.println();

    }

    static String[] crearEscala(int notaUsuario) {

        String[] escala = new String[8];

        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };

        int[] posiciones = { 0, 2, 4, 5, 7, 9, 11, 12 };

        int anchoEscala = escala.length;

        int anchoNotas = notas.length;

        for (int i = 0; i < anchoEscala; i++) {

            escala[i] = notas[(notaUsuario + posiciones[i]) % anchoNotas];

        }

        return escala;
    }

    static String[] crearAcorde(String[] escala) {

            String[] acorde = new String[3];

        int[] posiciones = { 0, 2, 4 };

        int anchoAcorde = acorde.length;

        for (int i = 0; i < anchoAcorde; i++) {

            acorde[i] = escala[posiciones[i]];

        }

        return acorde;
    }

    static int pedirNota() {

        System.out.println("Escoge la nota que desees: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");

        Scanner input = new Scanner(System.in);

        int notaUsuario = input.nextInt() - 1;

        if(notaUsuario > 12) {System.out.println("Error: nota no valida.");}
        
        input.close();

        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        
        System.out.println("Has elegido " + notas[notaUsuario]);

        

        return notaUsuario;
    }
}