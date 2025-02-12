package entregas.martinezDiego.reto002.src;
import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Selecciona una nota ");
        String[] notas = { "do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si" };
        imprimirNotas(notas);
        String eleccion = scanner.nextLine().toLowerCase();


    }

    static String[] construirEscalaMayor(String[] notas, String eleccion){
        int posicion = buscarNota(notas, eleccion);


    }
    static int buscarNota(String[] notas, String eleccion){
        for(int i= 0; i<notas.length; i++){
            if(notas[i].equals(eleccion)){
                return i;
        }else {
            return -1;
        }
    }

    static void imprimirNotas(String[] notas) {
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }

    }
}
