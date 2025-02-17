import java.util.Scanner;

public class metodos {
    public static void main(String[] args) {
        Scanner compu= new Scanner(System.in);
        int contador=1;
        int numer_positivos=0;
        int numero_negativos=0;

       

        do { 
            System.out.println("Ingrese uno de los 10 datos");
            double numero=compu.nextDouble();
            contador ++;
        

            if(numero>=0 ){
                numer_positivos++;

            }
            else{
                numero_negativos++;
            }
            if(numer_positivos>=10){
                System.out.println("Solo hay numeros positivo");

            }
            else{
                System.out.println("Si hay numeros negativos");
            }


        } while (contador <=10);

        System.out.println("Numeros positivos: "+numer_positivos);
        System.out.println("Numeros negativos: "+numero_negativos);



}
}