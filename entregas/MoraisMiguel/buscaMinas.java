import java.util.Scanner;

class buscaMinas{

    public static void main(String[]args){

        boolean jugando = true;

        while(jugando){

            System.out.println("BUSCAMINAS");
            System.out.println(tablero());



        }


    }

    static int[][] tablero(){

        // haz que sea al destapar que se genere la mina con un 10% de probabilidades, es mas facil

        int[][] tablero1 = {

            {"", "1", "2", "3", "4", "5", "6"},
            {"1", 2, 3, 4, 5, 6, 7},
            {"2", 2, 3, 4, 5, 6, 7},
            {"3", 2, 3, 4, 5, 6, 7},
            {"4", 2, 3, 4, 5, 6, 7},
            {"5", 2, 3, 4, 5, 6, 7},
            {"6", 2, 3, 4, 5, 6, 7},

        };

        String[] valorCasilla = {"-", "M", "D", "*"};

        return tablero1;

    }

}