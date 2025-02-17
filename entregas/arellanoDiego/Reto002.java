package entregas.arellanoDiego;

import java.util.Scanner;

public class Reto002 {
    static String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static String[] nombresEscalas = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };
    static String[][] patronesEscalas = {
        {"T", "T", "S", "T", "T", "T", "S"},
        {"T", "S", "T", "T", "S", "T", "T"},
        {"T", "S", "T", "T", "S", "T½", "S"},
        {"T", "S", "T", "T", "T", "T", "S"},
        {"T", "T", "T½", "T", "T½"},
        {"T½", "T", "T", "T½", "T"},
        {"T", "S", "T", "T", "T", "S", "T"},
        {"S", "T", "T", "T", "S", "T", "T"},
        {"T", "T", "T", "S", "T", "T", "S"},
        {"T", "T", "S", "T", "T", "S", "T"},
        {"S", "T", "T", "S", "T", "T", "T"},
        {"T", "T", "T", "T", "T", "T"}
    };

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String notaBase = obtenerNotaBase(entrada);
        int indiceBase = obtenerIndiceNota(notaBase);

        String nombreEscala = obtenerEscala(entrada);
        String[] patronSeleccionado = patronesEscalas[obtenerIndiceEscala(nombreEscala)];

        String[] escala = generarEscala(indiceBase, patronSeleccionado);
        imprimirEscala(nombreEscala, escala);

        String[] acorde = generarAcorde(nombreEscala, escala);
        imprimirAcorde(nombreEscala, acorde);

        entrada.close();
    }

    public static String obtenerNotaBase(Scanner entrada) {
        System.out.println("Ingrese la nota a trabajar (1-12):");
        int opcion = entrada.nextInt();
        return notas[opcion - 1];
    }

    public static int obtenerIndiceNota(String notaBase) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equals(notaBase)) return i;
        }
        return -1;
    }

    public static String obtenerEscala(Scanner entrada) {
        System.out.println("Seleccione la escala a generar:");
        for (int i = 0; i < nombresEscalas.length; i++) {
            System.out.println((i + 1) + ": " + nombresEscalas[i]);
        }
        int opcion = entrada.nextInt();
        return nombresEscalas[opcion - 1];
    }

    public static int obtenerIndiceEscala(String nombreEscala) {
        for (int i = 0; i < nombresEscalas.length; i++) {
            if (nombresEscalas[i].equals(nombreEscala)) return i;
        }
        return -1;
    }

    public static String[] generarEscala(int indiceBase, String[] patron) {
        String[] escala = new String[patron.length + 1];
        escala[0] = notas[indiceBase];
        int indiceActual = indiceBase;

        for (int i = 1; i < patron.length; i++) {
            if (patron[i - 1].equals("T")) indiceActual = (indiceActual + 2) % 12;
            else if (patron[i - 1].equals("S")) indiceActual = (indiceActual + 1) % 12;
            else if (patron[i - 1].equals("T½")) indiceActual = (indiceActual + 3) % 12;
            escala[i] = notas[indiceActual];
        }
        escala[patron.length] = notas[indiceBase];
        return escala;
    }

    public static String[] generarAcorde(String nombreEscala, String[] escala) {
        String[] acorde = {escala[0], escala[2], escala[4]};
        if (nombreEscala.contains("Locria")) acorde[2] = escala[4] + "b";
        else if (nombreEscala.contains("Por tonos")) acorde[2] = escala[4] + "#";
        return acorde;
    }

    public static void imprimirEscala(String nombreEscala, String[] escala) {
        System.out.print("La escala " + nombreEscala + " es: ");
        for (String nota : escala) System.out.print("[" + nota + "] ");
        System.out.println();
    }

    public static void imprimirAcorde(String nombreEscala, String[] acorde) {
        System.out.print("El acorde de " + nombreEscala + " es: ");
        for (String nota : acorde) System.out.print("[" + nota + "] ");
        System.out.println();
    }
}
