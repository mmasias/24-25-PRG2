package entregas.coboIsmael.reto001;

import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {


        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, ...");
        int notaBase = entradaUsuario.nextInt() - 1;

        if (notaBase < 0 || notaBase >= notas.length) {
            System.out.println("Nota no válida.");
        }   return;

        System.out.println("Ha elegido la nota " + notas[notaBase]);
    
        String[] escalaMayor = construirEscalaMayor(notaBase, notas);

        construirAcordeMayor(escalaMayor, notas[notaBase]);

    }

    public static String[] construirEscalaMayor(int notaBase, String[] notas) {
        int[] patron = {2, 2, 1, 2, 2, 2, 1};

        String[] escalaMayor = new String[8];
        escalaMayor[0] = notas[notaBase];
        int indiceActual = notaBase;

        for (int posicionEscala = 1; posicionEscala < 8; posicionEscala++) {
            indiceActual = (indiceActual + patron[posicionEscala - 1]) % notas.length;
            escalaMayor[posicionEscala] = notas[indiceActual];
        }

        System.out.print("La escala de " + notas[notaBase] + " Mayor es: ");
        for (int posicionEscala = 0; posicionEscala < escalaMayor.length; posicionEscala++) {
            System.out.print("[" + escalaMayor[posicionEscala] + "] / ");
        }
        System.out.println();

        return escalaMayor;
    }

    public static void construirAcordeMayor(String[] escalaMayor, String notaBase) {

        String[] acordeMayor = {escalaMayor[0], escalaMayor[2], escalaMayor[4]};

        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        for (int posicionAcorde = 0; posicionAcorde < acordeMayor.length; posicionAcorde++) {
            System.out.print("[" + acordeMayor[posicionAcorde] + "] / ");
        }
        System.out.println();
    }

    entradaUsuario.close();

}