import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONO_Y_MEDIO = TONO + SEMITONO;

    static final String[][] ESCALAS = {
        {"Mayor", "2212221"},
        {"Menor natural", "2122122"},
        {"Menor armónica", "2122131"},
        {"Menor melódica", "2122221"},
        {"Pentatónica mayor", "22323"},
        {"Pentatónica menor", "32232"},
        {"Dórica", "2122212"},
        {"Frigia", "1222122"},
        {"Lidia", "2221221"},
        {"Mixolidia", "2212212"},
        {"Locria", "1221222"},
        {"Por tonos", "222222"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escalas disponibles:");
        for (int i = 0; i < ESCALAS.length; i++) {
            System.out.println((i + 1) + ". " + ESCALAS[i][0]);
        }

        System.out.print("Elige una escala (1-" + ESCALAS.length + "): ");
        int opcion = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Ingresa una nota (Do, Re, Mi, etc.): ");
        String nota = scanner.nextLine();

        int indice = getIndiceNota(nota);
        if (indice == -1) {
            System.out.println("Nota no válida.");
        }

        String[] escala = construirEscala(indice, ESCALAS[opcion][1]);

        String escalaStr = "";
        int j = 0;
        while (j < escala.length) {
            escalaStr += escala[j];
            if (j < escala.length - 1) {
                escalaStr += " - ";
            }
            j++;
        }

        System.out.println("Escala " + ESCALAS[opcion][0] + ": " + escalaStr);
        System.out.println("Acorde: " + escala[0] + " - " + escala[2] + " - " + escala[4]);

        scanner.close();
    }

    static int getIndiceNota(String nota) {
        int i = 0;
        while (i < NOTAS.length) {
            if (NOTAS[i].equalsIgnoreCase(nota)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static String[] construirEscala(int indice, String intervalos) {
        String[] escala = new String[intervalos.length() + 1];
        int i = 0;
        
        while (i < escala.length) {
            escala[i] = NOTAS[indice % NOTAS.length];

            if (i < intervalos.length()) {
               
                int intervalo = 0;
                int k = 0;
                while (k < 10) { 
                    if (intervalos.substring(i, i + 1).equals("" + k)) {
                        intervalo = k;
                    }
                    k++;
                }

                indice += intervalo;
            }
            i++;
        }
        return escala;
    }
}