package morenoSara.reto001;

import java.util.Scanner;

public class EscalasYAcordes {
    public static void main(String[] args) {

        final int TONO= 2;
        final int SEMITONO = 1;

        String[] escala = new String[] {"DO", "DO#","RE", "RE#","MI","FA","FA#","SOL","SOL#","LA","LA#","SI","DO", "DO#","RE", "RE#","MI","FA","FA#","SOL","SOL#","LA","LA#","SI"};
        String[] escalaMayor =new String [8];

        int eleccionUsuario = preguntarEscalaUsuario();
        
        int primeraPosicion = eleccionUsuario - 1; 
        int segundaPosicion = primeraPosicion + TONO;
        int terceraPosicion = segundaPosicion + TONO;
        int cuartaPosicion =  terceraPosicion + SEMITONO;
        int quintaPosicion = cuartaPosicion + TONO;
        int sextaPosicion = quintaPosicion + TONO ;
        int septimaPosicion = sextaPosicion + TONO ;
        int octavaPosicion = septimaPosicion + SEMITONO ;

        escalaMayor [0]= escala [primeraPosicion];
        escalaMayor [1]= escala [segundaPosicion];
        escalaMayor [2]= escala [terceraPosicion];
        escalaMayor [3]= escala [cuartaPosicion];
        escalaMayor [4]= escala [quintaPosicion];
        escalaMayor [5]= escala [sextaPosicion];
        escalaMayor [6]= escala [septimaPosicion];
        escalaMayor [7]= escala [octavaPosicion];   
    
        escalaMayor(escalaMayor);
        acorde(escalaMayor);
    }
    static int preguntarEscalaUsuario (){
        Scanner entradaUsuario = new Scanner(System.in);

        int escalaEligeUsuario;

        System.out.println("Ingrese la nota a trabajar: 1.DO 2.DO# 3.RE 4.RE# 5.MI 6.FA 7.FA# 8.SOL 9.SOL# 10.LA 11.LA# 12.SI");
        escalaEligeUsuario = entradaUsuario.nextInt();

        return escalaEligeUsuario;
    }
    static void escalaMayor (String[] escalaMayor){
        System.out.print("La escala "+escalaMayor[0]+" Mayor es: ");
        
        for(int fila=0; fila<escalaMayor.length; fila++){
            System.out.print( " ["+escalaMayor[fila]+ "] ");       
        }
        System.out.println();
    }
    static void acorde (String[] escalaMayor){
        System.out.println("El acorde de "+ escalaMayor[0] + " Mayor esta conformado por: ["+ escalaMayor[0]+ "] ["+ escalaMayor[2] + "] ["+ escalaMayor[4]+ "]");
    }
}


