import java.util.Scanner;

class CalcularAcordes{
    public static void main(String[] args) { 
        final String[] NOTAS_ESCALA = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] escalaAGenerar = new String[6];

    } 
    public static int pedirNotaUsuario(String[] arrayNotas){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < arrayNotas.length; i++){
            System.out.println("Nota # " + i + " " + arrayNotas[i]);
        }
        System.out.println("Introduce el numero de la nota nota que quieras saber la escala mayor");
        final int INDICE_ARRAYS = 1;
        int numeroNota = input.nextInt() - INDICE_ARRAYS;
        input.close();
        return numeroNota;
    }
    public static String[] generarEscalaMayor(String[] arrayNotas, String[] escalaAGenerar, int numeroNota){
        for(int i = 0; i < escalaMayor.length; i++){
           
        }
        return escalaMayor;
    }
}