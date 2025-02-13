package entregas.alvaradoCarlos.reto002;
import java.util.Scanner;

public class EscalasAcordes {
    static final int[] INTERVALO_MAYOR = { 0, 2, 4, 5, 7, 9, 11, 12};

    public static void main(String[] args) {
        final String[] NOTAS = { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
        int indiceNota = ObtenerIndiceNota(NOTAS);
        construirEscala(indiceNota, NOTAS, INTERVALO_MAYOR);
    }

    static int ObtenerIndiceNota(String[] arrayNotas) {
        System.out.println("Ingrese la nota a trabajar: 1: Do 2: Do# 3: Re 4: Re# 5.Mi 6.Fa 7.Fa# 8.Sol 9.Sol# 10.La 11.La# 12.Si");
        Scanner sc = new Scanner(System.in);
        final int INDICE = sc.nextInt();
        sc.close();
        System.out.println("La nota es: " + arrayNotas[INDICE]);

        return INDICE;
    }
}
