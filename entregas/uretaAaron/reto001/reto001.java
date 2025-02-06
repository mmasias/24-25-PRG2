import java.util.Scanner;

public class reto001 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] patron = {"T", "T", "S", "T", "T", "T", "S"};

        String notaBase = obtenerNotaBase(entrada, notas);
        if (notaBase == null) return;
        System.out.println("Ha elegido la nota " + notaBase);

        int indiceBase = -1;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equals(notaBase)) {
                indiceBase = i;
            }
        }

        System.out.print("La escala de " + notaBase + " Mayor es: ");
        int indiceActual = indiceBase;
        for (int i = 0; i < 7; i++) {
            System.out.print("[" + notas[indiceActual] + "] ");
            indiceActual = (indiceActual + (patron[i].equals("T") ? 2 : 1)) % 12;
        }
        System.out.println("[" + notas[indiceBase] + "]");

        String nota1 = notas[indiceBase];
        String nota2 = notas[(indiceBase + 4) % 12];
        String nota3 = notas[(indiceBase + 7) % 12];
        
        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        System.out.print("[" + nota1 + "] ");
        System.out.print("[" + nota2 + "] ");
        System.out.print("[" + nota3 + "] ");
        System.out.println();

        entrada.close();
    }

    
    public static String obtenerNotaBase(Scanner scanner, String[] notas) {
        System.out.println("Ingrese la nota a trabajar: ");
        System.out.println("1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");

        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > 12) {
            System.out.println("Opción no válida.");
            return null;
        }
        return notas[opcion - 1];
    }
}
