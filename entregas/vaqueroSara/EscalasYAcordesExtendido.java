import java.util.Scanner;

public class EscalasYAcordesExtendido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int TONO = 2;
        final int SEMITONO = 1;
        final int TONOYMEDIO = 3;

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        
        int[][] patrones = {
            {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO}, 
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO}, 
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO}, 
            {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO}, 
            {TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO},
            {TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO},
            {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO}, 
            {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO}, 
            {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO}, 
            {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO}, 
            {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO}, 
            {TONO, TONO, TONO, TONO, TONO, TONO}
        };
        
        String[] nombresEscalas = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"
        };
        
        System.out.print("Ingrese una nota (Do, Re, Mi, etc.): ");
        
        String notaBase = scanner.nextLine();
        
        int indice = getIndiceNota(notaBase, notas);
        
        
        for (int i = 0; i < patrones.length; i++) {
            imprimirEscala(notaBase, indice, notas, patrones[i], nombresEscalas[i]);
            imprimirAcordes(notaBase, indice, notas, patrones[i], nombresEscalas[i]);
        }
        
        scanner.close();
    }
    
    static int getIndiceNota(String nota, String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(nota)) 
            return i;
        }
        return -1;
    }
    
    static void imprimirEscala(String notaBase, int indice, String[] notas, int[] patron, String nombreEscala) {
        System.out.println("Escala " + nombreEscala + " de " + notaBase + ":");
        System.out.print(notaBase + ", ");
        
        for (int i = 0; i < patron.length; i++) {
            int paso = patron[i];
            indice = (indice + paso) % 12;
            System.out.print(notas[indice] + ", ");
        }
        System.out.println("");
    }

    static void imprimirAcordes(String notaBase, int indice, String[] notas, int[] patron, String nombreEscala) {
        System.out.println("Acordes de la escala " + nombreEscala + " de " + notaBase + ":");
        int[] grados = {0, 2, 4}; // Tónica, tercera y quinta
        
        for (int i = 0; i < patron.length; i++) {
            String acorde = "";
            int indiceNota = indice;
            for (int grado : grados) {
                indiceNota = (indice + sumaPasos(patron, grado)) % 12;
                acorde += notas[indiceNota] + " ";
            }
            System.out.println(notas[indice] + " -> " + acorde.trim());
            indice = (indice + patron[i]) % 12;
        }
        System.out.println("");
    }

    static int sumaPasos(int[] patron, int hasta) {
        int suma = 0;
        for (int i = 0; i < hasta; i++) {
            suma += patron[i % patron.length];
        }
        return suma;
    }
}
