import java.util.Scanner;

class CalcularAcordes{
    public static void main(String[] args) { 
        final String[] notasEscala = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] escalaAGenerar = new String[7];
        generarEscalaMayor(notasEscala, escalaAGenerar, pedirNotaUsuario(notasEscala));
    } 
    public static int pedirNotaUsuario(String[] arrayNotas){
        Scanner input = new Scanner(System.in);
        final int INDICE_ARRAYS = 1;
        for(int i = 0; i < arrayNotas.length; i++){
            System.out.println("Nota # " + (i + INDICE_ARRAYS) + " " + arrayNotas[i]);
        }
        System.out.println("Introduce el numero de la nota nota que quieras saber la escala mayor");
        int numeroNota = input.nextInt() - INDICE_ARRAYS;
        input.close();
        return numeroNota;
    }
    public static void generarEscalaMayor(String[] arrayNotas, String[] escalaAGenerar, int numeroNota){
        boolean[] esTono = {true, true, false, true, true, true, false};
        int variableOperadora = numeroNota;
        final int SUMA_POSICION_TONO = 2;
        final int SUMA_POSICION_SEMITONO = 1;
        for(int i = 0; i <= esTono.length - 1; i++){
           if(esTono[i]){
            variableOperadora += SUMA_POSICION_TONO;
           }else{
            variableOperadora += SUMA_POSICION_SEMITONO;
           }
              if(variableOperadora >= arrayNotas.length){
                variableOperadora = variableOperadora%arrayNotas.length;
              }
              escalaAGenerar[i] = arrayNotas[variableOperadora];
        }
        imprimirEscala(escalaAGenerar, arrayNotas[numeroNota]);
    }

    public static void imprimirEscala(String[] escalaAGenerar, String notaPrincipal){
        System.out.print("La escala del acorde mayor de " + notaPrincipal + " es:");
        for(int i = 0; i < escalaAGenerar.length; i++){
            System.out.println(escalaAGenerar[i]);
        }
    }

}

