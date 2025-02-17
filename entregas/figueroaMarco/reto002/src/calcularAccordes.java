import java.util.Scanner;

class CalcularAcordesPlus{
    static final String[] NOTAS_ESCALA = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    static final int INDICE_ELECCION_NOTA = 1;
    static final int INDICE_ELECCION_ESCALA = 0;
    static final int INDICE_ARRAYS = 1;
    public static void main(String[] args) { 
        String [] escalaAGenerar = {};
        int [] elecciones = {};
        String[][] patronesEscala = almacenarPatronesEscala();
        pedirInput(patronesEscala, elecciones);
        generarEscala(patronesEscala, escalaAGenerar, elecciones);
        
    } 
    public static void pedirInput(String[][] escalas, int[] elecciones){
        Scanner input = new Scanner(System.in); 
        elecciones = new int[2];
        for(int i = 0; i < NOTAS_ESCALA.length; i++){
            System.out.println("Nota # " + (i + INDICE_ARRAYS) + " " + NOTAS_ESCALA[i]);
        }
        System.out.println("Introduce el numero de la nota nota que quieras trabaajar");
        int numeroNota = input.nextInt() - INDICE_ARRAYS;
        elecciones[INDICE_ELECCION_NOTA] = numeroNota;
        for(int i = 0; i < escalas[INDICE_ELECCION_ESCALA].length; i++){
            System.out.println("Escala # " + (i + INDICE_ARRAYS) + " " + escalas[i][INDICE_ELECCION_ESCALA]);
        }
        System.out.println("Escoge la escala que quieras generar:");
        int numeroEscala = input.nextInt() - INDICE_ARRAYS;
        elecciones[INDICE_ELECCION_ESCALA] = numeroEscala;
        input.close();
    }
    
    public static String[][] almacenarPatronesEscala(){
        String[][] patronesEscalas = new String[][]{
            {"Mayor","T", "T", "S", "T", "T", "T", "S"},
            {"Menor", "T", "S", "T", "T", "S", "T", "T"},
            {"Menor Armonica", "T", "S", "T", "T", "S", "T.5", "T"},
            {"Menor Melodica", "T", "S", "T", "T", "T", "T", "S"},
            {"Pentatonica Mayor", "T", "T", "T.5", "T", "T.5"},
            {"Pentatonica Menor", "T.5", "T", "T", "T.5", "T"},
            {"Dorica", "T", "S", "T", "T", "T", "S", "T"},
            {"Frigia", "S", "T", "T", "T", "S", "T", "T"},
            {"Mixolidia", "T", "T", "S", "T", "T", "S", "T"},
            {"Locria", "S", "T", "T", "S", "T", "T", "T"},
            {"Por Tonos", "T", "T", "T", "T", "T", "T", "T"}
        };
        return patronesEscalas;
    }
    public static void generarEscala(String[][] arrayPatronesEscala, String[] escalaAGenerar, int[] elecciones){
        int numeroNota = elecciones[INDICE_ELECCION_NOTA];
        int numeroEscala = elecciones[INDICE_ELECCION_ESCALA];
        int variableOperadora = numeroNota;
        escalaAGenerar = new String[arrayPatronesEscala[numeroEscala].length];
        final int SUMA_POSICION_TONO = 2;
        final int SUMA_POSICION_SEMITONO = 1;

        for(int i = INDICE_ARRAYS; i <= arrayPatronesEscala[numeroEscala].length - 1; i++){
           if(arrayPatronesEscala[numeroEscala].equals("T")){
            variableOperadora += SUMA_POSICION_TONO;
           }else if(escalaAGenerar[numeroEscala].equals("T.5")){
            variableOperadora += (SUMA_POSICION_TONO + SUMA_POSICION_SEMITONO);
           } else {
            variableOperadora += SUMA_POSICION_SEMITONO;
              if(variableOperadora >= NOTAS_ESCALA.length){
                variableOperadora = variableOperadora%NOTAS_ESCALA.length;
              }
            }
              escalaAGenerar[i] = NOTAS_ESCALA[variableOperadora];
        }
        imprimirEscala(escalaAGenerar, NOTAS_ESCALA[numeroNota]);
    }

    public static void imprimirEscala(String[] escalaAGenerar, String notaPrincipal){
        System.out.print("La escala del acorde mayor de " + notaPrincipal + " es:");
        for(int i=0; i < escalaAGenerar.length; i++){
            System.out.println(escalaAGenerar[i]);
        }
    }
}

