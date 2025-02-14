package entregas.alvaradoCarlos.reto002;
import java.util.Scanner;

public class EscalasAcordes {
    static final int TONO = 2, SEMITONO = 1, TONO_Y_SEMITONO = 3;
    static final int[] INTERVALO_MAYOR = {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO};

    public static void main(String[] args) {
        final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        int indiceNota = obtenerIndiceNota(NOTAS);
        construirEscala(indiceNota, NOTAS, INTERVALO_MAYOR);
    }

    static int obtenerIndiceNota(String[] arrayNotas) {
        System.out.println("Ingrese la nota a trabajar: 0: Do 1: Do# 2: Re 3: Re# 4: Mi 5: Fa 6: Fa# 7: Sol 8: Sol# 9: La 10: La# 11: Si");
        Scanner sc = new Scanner(System.in);
        int indice = sc.nextInt();
        sc.close();
        System.out.println("La nota es: " + arrayNotas[indice]);
        return indice;
    }

    static String[] construirEscala(int indice, String[] arrayNotas, int[] intervalo) {
        String[] escala = new String[7];
        escala[0] = arrayNotas[indice];
        System.out.print(arrayNotas[indice] + " / ");
        for (int i = 0; i < intervalo.length; i++) {
            indice = (indice + intervalo[i]) % arrayNotas.length;
            escala[i] = arrayNotas[indice];
            System.out.print(arrayNotas[indice] + " / ");
        }
        System.out.println();
        return escala;
    }
}