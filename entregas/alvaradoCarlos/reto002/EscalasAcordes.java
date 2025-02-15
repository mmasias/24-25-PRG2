package entregas.alvaradoCarlos.reto002;
import java.util.Scanner;

public class EscalasAcordes {
    static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int SEMITONO = 1, TONO = SEMITONO * 2, TONO_Y_SEMITONO = TONO + SEMITONO;
    static final int[][] ESCALA = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
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
        System.out.println("Ingrese el tipo de escala a trabajar: 0: Mayor 1: Menor");
        Scanner sc = new Scanner(System.in);
        int indice = sc.nextInt();
        return ESCALA[indice];
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