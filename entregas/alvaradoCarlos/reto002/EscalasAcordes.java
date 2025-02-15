package entregas.alvaradoCarlos.reto002;
import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_SEMITONO = TONO + SEMITONO;
    static final int[][] ESCALA = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO + SEMITONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
        {TONO, TONO, TONO_Y_SEMITONO, TONO, TONO_Y_SEMITONO},
        {TONO_Y_SEMITONO, TONO, TONO, TONO_Y_SEMITONO, TONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
        {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
        {TONO, TONO, TONO, TONO, TONO, TONO}
    };

    public static void main(String[] args) {
        int[] intervalo = obtenerIndiceEscala();
        int indiceNota = obtenerIndiceNota();
        String[] escala = construirEscala(indiceNota, intervalo);
        String[] acorde = construirAcorde(escala);
        mostrarSecuencia(escala);
        mostrarSecuencia(acorde);
    }

    static int obtenerIndiceNota() {
        System.out.println("Ingrese la nota a trabajar: 0: Do 1: Do# 2: Re 3: Re# 4: Mi 5: Fa 6: Fa# 7: Sol 8: Sol# 9: La 10: La# 11: Si");
        Scanner sc = new Scanner(System.in);
        int indice = sc.nextInt();
        sc.close();
        System.out.println("La nota es: " + NOTAS[indice]);
        return indice;
    }

    static int[] obtenerIndiceEscala() {
        System.out.println("Ingrese el tipo de escala a trabajar: ");
        System.out.println("1: Mayor");
        System.out.println("2: Menor");
        System.out.println("3: Menor Armónica");
        System.out.println("4: Menor melódica");
        System.out.println("5: Pentatónica mayor");
        System.out.println("6: Penatónica menor");
        System.out.println("7: Dórica");
        System.out.println("8: Frigia");
        System.out.println("9: Lidia");
        System.out.println("10: Mixolidia");
        System.out.println("11: Locria");
        System.out.println("12: Por tonos");
        Scanner sc = new Scanner(System.in);
        int indice = sc.nextInt();
        return ESCALA[indice - 1];
    }

    static String[] construirEscala(int indice, int[] intervalo) {
        String[] escala = new String[8];
        escala[0] = NOTAS[indice];
        for (int i = 0; i < intervalo.length; i++) {
            indice = (indice + intervalo[i]) % NOTAS.length;
            escala[i + 1] = NOTAS[indice];
        }
        return escala;
    }

    static String[] construirAcorde(String[] escala) {
        int I = 0, III = 2, V = 4;
        return new String[] {escala[I], escala[III], escala[V]};
    }

    static void mostrarSecuencia(String[] secuencia) {
        for (String nota : secuencia) {
            System.out.print("[ " + nota + " ]");
        }
        System.out.println();
    }
}