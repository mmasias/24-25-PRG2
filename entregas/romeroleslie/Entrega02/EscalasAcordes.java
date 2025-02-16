import java.util.Scanner;

public class EscalasAcordes {

    private static final String[] NOTAS = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", 
        "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final int[][] PATRONES = {
        {2, 2, 1, 2, 2, 2, 1}, 
        {2, 1, 2, 2, 1, 2, 2}, 
        {2, 1, 2, 2, 1, 3, 1}, 
        {2, 1, 2, 2, 2, 2, 1}, 
        {2, 3, 2, 3},         
        {3, 2, 2, 3},         
        {2, 1, 2, 2, 2, 1, 2}, 
        {1, 2, 2, 2, 1, 2, 2}, 
        {2, 2, 2, 1, 2, 2, 1}, 
        {2, 2, 1, 2, 2, 2, 1}, 
        {1, 2, 2, 2, 2, 1, 2}, 
        {2, 2, 2, 2, 2, 2}   
    };

    private static final String[] TIPOS_ESCALAS = {
        "Mayor", "Menor natural", "Menor armónica", "Menor melódica", 
        "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", 
        "Lidia", "Mixolidia", "Locria", "Por tonos"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int indiceNota = seleccionarOpcion(scanner, "nota", NOTAS);
        int tipoEscala = seleccionarOpcion(scanner, "escala", TIPOS_ESCALAS);
            
        String[] escala = elaborarEscala(indiceNota, PATRONES[tipoEscala]);
        String[] acorde = new String[]{escala[0], escala[2], escala[4]};
        
        mostrarResultados(NOTAS[indiceNota], TIPOS_ESCALAS[tipoEscala], escala, acorde);
        scanner.close();
    }

    private static int seleccionarOpcion(Scanner scanner, String tipo, String[] opciones) {
        System.out.println("Seleccione una " + tipo + ":");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ": " + opciones[i]);
        }
        return leerEntrada(scanner, opciones.length) - 1;
    }

    private static int leerEntrada(Scanner scanner, int limite) {
        int opcion = 0;
        while (opcion < 1 || opcion > limite) {
            System.out.print("Ingrese un número (1-" + limite + "): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            }
            scanner.nextLine(); 
        }
        return opcion;
    }

    private static String[] elaborarEscala(int indiceNota, int[] patron) {
        String[] escala = new String[patron.length + 1];
        for (int i = 0; i < patron.length; i++) {
            escala[i] = NOTAS[indiceNota];
            indiceNota = (indiceNota + patron[i]) % NOTAS.length;
        }
        escala[patron.length] = NOTAS[indiceNota];
        return escala;
    }

    private static void mostrarResultados(String nota, String escala, String[] notasEscala, String[] acorde) {
        System.out.println("Eligió la nota " + nota + " en la escala " + escala);
        System.out.print("Escala: ");
        mostrarNotas(notasEscala);
        System.out.print("Acorde: ");
        mostrarNotas(acorde);
    }

    private static void mostrarOpciones() {
        System.out.println("Ingrese el número de la nota a evaluar:");
        for (int i = 0; i < NOTAS.length; i++) {
            System.out.println((i + 1) + ": " + NOTAS[i]);
        }
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = 0;
        while (opcion < 1 || opcion > NOTAS.length) {
            System.out.print("\nElija el número de la nota musical (1-" + NOTAS.length + "): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            }
            scanner.nextLine(); 
        }
        return opcion;
    }

    private static String[] elaborarEscalaMayor(int indiceNota) {
        String[] escala = new String[8];
        for (int i = 0; i < PATRON_ESCALA_MAYOR.length; i++) {
            escala[i] = NOTAS[indiceNota];
            indiceNota = (indiceNota + PATRON_ESCALA_MAYOR[i]) % NOTAS.length;
        }
        escala[7] = NOTAS[indiceNota];  
        return escala;
    }

    private static String[] elaborarAcordeMayor(String[] escalaMayor) {
        return new String[]{escalaMayor[0], escalaMayor[2], escalaMayor[4]};
    }

    private static void mostrarResultados(String notaBase, String[] escalaMayor, String[] acordeMayor) {
        System.out.println("Eligió la nota " + notaBase);
        System.out.print("La escala de " + notaBase + " Mayor es: ");
        mostrarNotas(escalaMayor);
        System.out.print("El acorde de " + notaBase + " Mayor está conformado por: ");
        mostrarNotas(acordeMayor);
    }

    private static void mostrarNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]");
            if (i < notas.length - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
    }
}