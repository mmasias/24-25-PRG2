import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Escalas {
    private static final String[] NOTAS = 
        {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    private static final int[] PATRON_ESCALA_MAYOR = {2, 2, 1, 2, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indiceNota;

        do {
            System.out.println("Ingrese el número de la nota base (1: Do, 2: Do#, ..., 12: Si):");
            indiceNota = scanner.nextInt() - 1;
        } while (indiceNota < 0 || indiceNota >= NOTAS.length);

        String notaBase = NOTAS[indiceNota];
        List<String> escalaMayor = construirEscalaMayor(indiceNota);
        List<String> acordeMayor = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            acordeMayor.add(escalaMayor.get(i * 2));
        }

        System.out.println("Ha elegido la nota " + notaBase);
        System.out.println("La escala de " + notaBase + " Mayor es: " + String.join(" / ", escalaMayor));
        System.out.println("El acorde de " + notaBase + " Mayor está conformado por: " + String.join(" / ", acordeMayor));

        scanner.close();
    }

    private static List<String> construirEscalaMayor(int indiceBase) {
        List<String> escala = new ArrayList<>();
        int indiceActual = indiceBase;

        for (int paso : PATRON_ESCALA_MAYOR) {
            escala.add(NOTAS[indiceActual % NOTAS.length]);
            indiceActual += paso;
        }
        escala.add(NOTAS[indiceBase]);
        return escala;
    }
}


    