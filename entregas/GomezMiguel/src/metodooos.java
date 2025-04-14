import java.util.Scanner;
public class metodooos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numero = new int[4];

        numero[0]= 7;
        numero[1]= 3;
        numero[2]= 9;
        numero[3]= 1;

        System.out.println(numero[0]);

        for(int contador=0; contador<4;contador++){
            System.out.println(numero[contador]);
        }

        
       

        String[] nombre_de_los_sujetos=new String[8];

        nombre_de_los_sujetos[0]= "Javir";
        nombre_de_los_sujetos[1]= "Lalo";
        nombre_de_los_sujetos[2]=  "Fernando";
        nombre_de_los_sujetos[3]= "Ximena";
        nombre_de_los_sujetos[4]= "Perez";
        nombre_de_los_sujetos[5]= "alooo";
        nombre_de_los_sujetos[6]= "Liza";
        nombre_de_los_sujetos[7]= "pepe";

        for(int i=0;i<8; i++){
            System.out.println(nombre_de_los_sujetos[i]);
        }

        int [] numeros = {1,2,3,4,5,6,7,8,9,10};

        for(int v=0; v<10; v++){
            System.out.println(numeros[v]);
        }
    
}
}