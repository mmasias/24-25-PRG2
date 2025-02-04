package entregas.perozoDiego;

import java.util.Scanner;

class PrimeraClase {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int nota = Nota(entrada);
        imprimirEscalaYAcordes(nota);
    }

    static int Nota(Scanner entrada) {
        System.out.print("Ingrese la nota que desea trabajar: ");
        System.out.println("(1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si)");
        int nota = entrada.nextInt();
        return nota;
    }

    static void imprimirEscalaYAcordes(int nota) {
        if (nota == 1) {
            System.out.println("Escala de Do: Do, Re, Mi, Fa, Sol, La, Si");
        } else if (nota == 2) {
            System.out.println("Escala de Do#: Do#, Re#, Fa, Fa#, Sol#, La#, Do");
        } else if (nota == 3) {
            System.out.println("Escala de Re: Re, Mi, Fa#, Sol, La, Si, Do#");
        } else if (nota == 4) {
            System.out.println("Escala de Re#: Re#, Fa, Sol, Sol#, La#, Do, Re");
        } else if (nota == 5) {
            System.out.println("Escala de Mi: Mi, Fa#, Sol#, La, Si, Do#, Re#");
        } else if (nota == 6) {
            System.out.println("Escala de Fa: Fa, Sol, La, Sib, Do, Re, Mi");
        } else if (nota == 7) {
            System.out.println("Escala de Fa#: Fa#, Sol#, La#, Si, Do#, Re#, Fa");
        } else if (nota == 8) {
            System.out.println("Escala de Sol: Sol, La, Si, Do, Re, Mi, Fa#");
        } else if (nota == 9) {
            System.out.println("Escala de Sol#: Sol#, La#, Do, Do#, Re#, Fa, Sol");
        } else if (nota == 10) {
            System.out.println("Escala de La: La, Si, Do#, Re, Mi, Fa#, Sol#");
        } else if (nota == 11) {
            System.out.println("Escala de La#: La#, Do, Re, Re#, Fa, Sol, La");
        } else if (nota == 12) {
            System.out.println("Escala de Si: Si, Do#, Re#, Mi, Fa#, Sol#, La#");
        } else {
            System.out.println("Opción inválida. Por favor, elija un número entre 1 y 12.");
        }
    }
}
