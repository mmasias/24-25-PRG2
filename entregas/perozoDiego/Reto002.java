  package entregas.perozoDiego;

import java.util.Scanner;

public class Reto002 {
    static String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

    static int[] mayor = {2, 2, 1, 2, 2, 2, 1};
    static int[] menor = {2, 1, 2, 2, 1, 2, 2};
    static int[] armonica = {2, 1, 2, 2, 1, 3, 1};
    static int[] melodica = {2, 1, 2, 2, 2, 2, 1};
    static int[] pentatonicaMayor = {2, 2, 3, 2, 3};
    static int[] pentatonicaMenor = {3, 2, 2, 3, 2};
    static int[] doria = {2, 1, 2, 2, 2, 1, 2};
    static int[] frigia = {1, 2, 2, 2, 1, 2, 2};
    static int[] lidia = {2, 2, 2, 1, 2, 2, 1};
    static int[] mixolidia = {2, 2, 1, 2, 2, 1, 2};
    static int[] locria = {1, 2, 2, 1, 2, 2, 2};
    static int[] porTonos = {2, 2, 2, 2, 2, 2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la nota base:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println((i + 1) + ": " + notas[i]);
        }
        int opcion = scanner.nextInt();

        if (opcion < 1 || opcion > 12) {
            System.out.println("Opción inválida.");
            return;
        }

        String notaBase = notas[opcion - 1];
        System.out.println("Ha elegido la nota: " + notaBase);

        mostrarEscala("Mayor", notaBase, mayor);
        mostrarEscala("Menor Natural", notaBase, menor);
        mostrarEscala("Menor Armónica", notaBase, armonica);
        mostrarEscala("Menor Melódica", notaBase, melodica);
        mostrarEscala("Pentatónica Mayor", notaBase, pentatonicaMayor);
        mostrarEscala("Pentatónica Menor", notaBase, pentatonicaMenor);
        mostrarEscala("Dórica", notaBase, doria);
        mostrarEscala("Frigia", notaBase, frigia);
        mostrarEscala("Lidia", notaBase, lidia);
        mostrarEscala("Mixolidia", notaBase, mixolidia);
        mostrarEscala("Locria", notaBase, locria);
        mostrarEscala("Por Tonos", notaBase, porTonos);
        
        scanner.close();
    }

    static void mostrarEscala(String nombre, String notaBase, int[] secuencia) {
        String[] escala = construirEscala(notaBase, secuencia);
        String acorde = construirAcorde(escala[0], escala[2 % escala.length], escala[4 % escala.length]);
        System.out.println("La escala de " + notaBase + " " + nombre + " es: " + String.join(" - ", escala));
        System.out.println("El acorde de " + notaBase + " " + nombre + " está conformado por: " + acorde + "\n");
    }

    static String[] construirEscala(String notaBase, int[] secuencia) {
        int index = obtenerIndiceNota(notaBase);
        String[] escala = new String[secuencia.length + 1];
        escala[0] = notas[index];

        for (int i = 0; i < secuencia.length; i++) {
            index = (index + secuencia[i]) % 12;
            escala[i + 1] = notas[index];
        }
        return escala;
    }

    static String construirAcorde(String primera, String tercera, String quinta) {
        return "[" + primera + "] - [" + tercera + "] - [" + quinta + "]";
    }

    static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equals(nota)) return i;
        }
        return -1;
    }
}
