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


        String[] escalaMayor = elaborarEscalaMayor(indiceNota);
        String[] acordeMayor = elaborarAcordeMayor(escalaMayor);

        mostrarResultados(NOTAS[indiceNota], escalaMayor, acordeMayor);

        scanner.close();
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