import java.util.Scanner;

class escalas{
    public static void main(String[] args) {
        
        int[] notas = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        boolean jugando = true;
        do{
             mostrarNota(notas);
             determinarEscalaAcorde(notas);
             }while(jugando);
    }
    
    static void mostrarNota(int[] notas){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nota a trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: So, 9: So#, 10: La, 11: La#, 12: Si  ");
        notas[0] = scanner.nextInt();
        System.out.println("elegiste");
        System.out.println(parse(notas[0]));
        scanner.close();
    }
    static String parse(int value){
        return switch(value){
            case 1 -> "Do";
            case 2 -> "Do#";
            case 3 -> "Re";
            case 4 -> "Re#";
            case 5 -> "Mi";
            case 6 -> "Fa";
            case 7 -> "Fa#";
            case 8 -> "So";
            case 9 -> "So#";
            case 10 -> "La";
            case 11 -> "La#";
            case 12 -> "Si";
            default -> "???";
        };

     }

     static void determinarEscalaAcorde(int[] notas){
         int not1 = notas[0]+2;
         int not2 = not1 + 2;
         int not3 = not2+1;
         int not4 = not3+2;
         int not5 = not4+2;
         int not6 = not5+2;
         int not7 = not6+1;
         System.out.println("la escla de" + parse(notas[0]) + "Mayor es: " +parse(notas[not1])+"/"+parse(notas[not2])+"/"+parse(notas[not3])+ "/"+parse(notas[not4])+"/"+parse(notas[not5])+"/"+parse(notas[not6])+"/"+parse(notas[not7]) );

         System.out.println("El acorde esta conformado por:"+parse(notas[not1])+"/"+parse(notas[not3])+"/"+parse(notas[not5]) );

     }
 }
        
        
        
       


         


         

     


        
    



    

