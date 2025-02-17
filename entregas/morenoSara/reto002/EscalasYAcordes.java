import java.util.Scanner;

public class EscalasYAcordes {
    
    private static final int SEMITONO = 1;
    private static final int TONO = SEMITONO + SEMITONO;
    private static final int TONO_Y_MEDIO = 3;

    private static final String[] ESCALA = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};
    
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        
        int eleccionUsuario = preguntarEscalaUsuario(entradaUsuario);
        int notaBase = seleccionarNotaBase(entradaUsuario);
        
        if (eleccionUsuario < 1 || eleccionUsuario > 4) {
            System.out.println("Opción no válida");
        }
        
        int[] intervalos = obtenerIntervalos(eleccionUsuario);
        String[] escalaConstruida = construirEscala(notaBase, intervalos);
        
        escala(escalaConstruida);
        acorde(escalaConstruida);
    }

    static int preguntarEscalaUsuario(Scanner entradaUsuario) {
        System.out.println("Seleccione la escala que quiere: 1. Mayor 2. Menor natural 3. Menor armónica 4. Menor melódica");
        return entradaUsuario.nextInt();
    }

    static int seleccionarNotaBase(Scanner entradaUsuario) {
        int escalaEligeUsuario;

        System.out.println("Ingrese la nota a trabajar: 1.DO 2.DO# 3.RE 4.RE# 5.MI 6.FA 7.FA# 8.SOL 9.SOL# 10.LA 11.LA# 12.SI");
        escalaEligeUsuario = entradaUsuario.nextInt();

        return escalaEligeUsuario - 1;
    }

    static int[] obtenerIntervalos(int eleccionUsuario) {
        int[][] intervalosEscalas = {
            {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO}, 
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO}, 
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO}, 
            {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO} 
        };
        return intervalosEscalas[eleccionUsuario - 1];
    }

    static String[] construirEscala(int notaBase, int[] intervalos) {
        String[] escalaConstruida = new String[8];
        escalaConstruida[0] = ESCALA[notaBase];
        
        int posicion = notaBase;
        for (int i = 0; i < intervalos.length; i++) {
            posicion = (posicion + intervalos[i]) % 12;
            escalaConstruida[i + 1] = ESCALA[posicion];
        }
        return escalaConstruida;
    }

    static void escala(String[] escalaConstruida) {
        System.out.print("La escala "+escalaConstruida[0]+" Mayor es: ");
        
        for(int fila=0; fila<escalaConstruida.length; fila++){
            System.out.print( " ["+escalaConstruida[fila]+ "] ");       
        }
        System.out.println();
    }

    private static void acorde(String[] escalaConstruida) {
        System.out.println("El acorde de "+ escalaConstruida[0] + " Mayor esta conformado por: ["+ escalaConstruida[0]+ "] ["+ escalaConstruida[2] + "] ["+ escalaConstruida[4]+ "]");
    }
    
}
