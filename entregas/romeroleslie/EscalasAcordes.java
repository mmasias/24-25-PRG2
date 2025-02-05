import java.util.Scanner;

public class EscalasAcordes {

    private static final String[] NOTAS = {
        "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", 
        "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarOpciones();
        int indiceNota = leerOpcion(scanner) - 1;

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
 

}

