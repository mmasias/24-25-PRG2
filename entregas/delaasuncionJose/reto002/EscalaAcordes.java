package entregas.delaasuncionJose.reto001;

import java.util.Scanner;

class EscalaAcordes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int nota=(obtenerNumeroUsuario(12,1,entrada)-1), escala=(obtenerNumeroUsuario(12,1,entrada))-1;

        String[] notasEscala = calcularEscala(nota,escala);
        String[] notasAcorde = calcularAcorde(notasEscala);
        contarHistoria(notasAcorde, notasEscala, escala);

        entrada.close();
    }

    static int obtenerNumeroUsuario(int maximo, int minimo, Scanner entrada) {
        final String ERROR = "| >  Porfavor introduzca un numero dentro del intervalo de [1,12]∈ N";
        final String EMBELLECEDOR = "| >  ";
        int numeroUsuario;
        boolean taMal;

        do {
            System.out.print(EMBELLECEDOR);
            while(!entrada.hasNextInt()){
                System.out.println(ERROR);
                entrada.next();
                System.out.print(EMBELLECEDOR);
            }
            numeroUsuario = entrada.nextInt();
            taMal = numeroUsuario > maximo || numeroUsuario < minimo;
            if (taMal) {
                System.out.println(ERROR);
            }
        } while(taMal);
        return numeroUsuario;
    }

    static String[] calcularEscala(int nota, int escala) {
        final String[] TONOS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        final int[][] PATRONES = {
            { 2, 2, 1, 2, 2, 2, 1 },
            { 2, 1, 2, 2, 1, 2, 2 },
            { 2, 1, 2, 2, 1, 3, 1 },
            { 2, 1, 2, 2, 2, 2, 1 },
            { 2, 2, 3, 2, 3 },
            { 3, 2, 2, 3, 2 },
            { 2, 1, 2, 2, 2, 1, 2 },
            { 1, 2, 2, 2, 1, 2, 2 },
            { 2, 2, 2, 1, 2, 2, 1 },
            { 2, 2, 1, 2, 2, 1, 2 },
            { 1, 2, 2, 1, 2, 2, 2 },
            { 2, 2, 2, 2, 2, 2 }};
        String[] notasEscala = new String[PATRONES[escala].length];
        for (int i = 0; i < PATRONES[escala].length; i++) {
            notasEscala[i] = TONOS[nota];
            nota = (nota + PATRONES[escala][i]) % 12;
        }
        return notasEscala;
    }

    static String[] calcularAcorde(String[] notasEscala) {
        final int[] GRADOS = {0, 2, 4};
        String[] acorde = new String[GRADOS.length];

        for (int i = 0; i < GRADOS.length; i++) {
            acorde[i] = notasEscala[GRADOS[i]];
        }
        return acorde;
    }
    
    static void contarHistoria(String[] notasAcorde, String[] notasEscala, int escala) {
        final String[] NOMBRES_ESCALA = {
            "Mayor", "Menor natural", "Menor armónica", "Menor melódica",
            "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia",
            "Lidia", "Mixolidia", "Locria", "Por tonos"};

        System.out.print("La escala de " + notasEscala[0] + " " + NOMBRES_ESCALA[escala] + " es: ");
        mostrarSecuencia(notasEscala);
        System.out.println();

        System.out.print("El acorde de " + notasAcorde[0] + " " + NOMBRES_ESCALA[escala] + " está conformado por: ");
        mostrarSecuencia(notasAcorde);
    }

    static void mostrarSecuencia(String[] secuencia) {
        for (int i = 0; i < secuencia.length; i++) {
            System.out.print("[" + secuencia[i] + "]");
            if (i < secuencia.length - 1) {
                System.out.print(" / ");
            }
        }
    }
}