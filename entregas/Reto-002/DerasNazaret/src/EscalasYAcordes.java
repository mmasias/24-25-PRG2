import java.util.*;

class Escala {
    private static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final Map<String, int[]> INTERVALOS = new HashMap<>();
    
    static {
        INTERVALOS.put("Mayor", new int[]{2, 2, 1, 2, 2, 2, 1});
        INTERVALOS.put("Menor natural", new int[]{2, 1, 2, 2, 1, 2, 2});
        INTERVALOS.put("Menor armónica", new int[]{2, 1, 2, 2, 1, 3, 1});
        INTERVALOS.put("Menor melódica", new int[]{2, 1, 2, 2, 2, 2, 1});
        INTERVALOS.put("Pentatónica mayor", new int[]{2, 2, 3, 2, 3});
        INTERVALOS.put("Pentatónica menor", new int[]{3, 2, 2, 3, 2});
        INTERVALOS.put("Dórica", new int[]{2, 1, 2, 2, 2, 1, 2});
        INTERVALOS.put("Frigia", new int[]{1, 2, 2, 2, 1, 2, 2});
        INTERVALOS.put("Lidia", new int[]{2, 2, 2, 1, 2, 2, 1}); 
        INTERVALOS.put("Mixolidia", new int[]{2, 2, 1, 2, 2, 1, 2});
        INTERVALOS.put("Locria", new int[]{1, 2, 2, 1, 2, 2, 2}); 
        INTERVALOS.put("Por tonos", new int[]{2, 2, 2, 2, 2, 2});
    }

    public static List<String> generarEscala(String tipo, String notaBase) {
        List<String> escala = new ArrayList<>();
        int indice = Arrays.asList(NOTAS).indexOf(notaBase);
        if (indice == -1 || !INTERVALOS.containsKey(tipo)) return escala;

        escala.add(NOTAS[indice]);
        for (int intervalo : INTERVALOS.get(tipo)) {
            indice = (indice + intervalo) % NOTAS.length;
            escala.add(NOTAS[indice]);
        }
        return escala;
    }

    public static String generarAcorde(List<String> escala) {
        if (escala.size() < 5) return "";
        return escala.get(0) + "-" + escala.get(2) + "-" + escala.get(4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota base: ");
        String notaBase = scanner.nextLine();
        System.out.print("Ingrese el tipo de escala: ");
        String tipoEscala = scanner.nextLine();
        scanner.close();

        List<String> escala = generarEscala(tipoEscala, notaBase);
        if (escala.isEmpty()) {
            System.out.println("Escala no válida.");
        } else {
            System.out.println("Escala " + tipoEscala + " de " + notaBase + ": " + escala);
            System.out.println("Acorde: " + generarAcorde(escala));
        }
    }
}