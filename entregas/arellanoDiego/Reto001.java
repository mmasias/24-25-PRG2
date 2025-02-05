package entregas.arellanoDiego;

import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] notas = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        String[] patron = { "T", "T", "S", "T", "T", "T", "S" };

        System.out.println("Ingrese una la nota a trabajar: ");
        System.out.println(
                "1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");

        int opcion = entrada.nextInt();
        String notaBase = notas[opcion - 1];
        System.out.println("Ha elegido la nota " + notaBase);

        int indiceBase = 0;
        while (indiceBase < notas.length && !notas[indiceBase].equals(notaBase)) {
            indiceBase++;
        }

        String[] escala = new String[8];
        escala[0] = notas[indiceBase];
        int indiceActual = indiceBase;

        for (int i = 1; i < 7; i++) {
            indiceActual = (indiceActual + (patron[i - 1].equals("T") ? 2 : 1)) % 12;
            escala[i] = notas[indiceActual];
        }
        escala[7] = notas[indiceBase]; 

        System.out.print("La escala de " + notaBase + " Mayor es: ");
        for (String nota : escala) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();

        entrada.close();
    }
    
}
