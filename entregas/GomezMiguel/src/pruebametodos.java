import java.util.Scanner;
public class pruebametodos {
    public static void main(String[] args) {
        Scanner compu= new Scanner(System.in);

        System.out.println("Ingrese la cantidad e datos de loq ueu quiera su fucking array");
        int longitud= compu.nextInt();

        String[]nombres = new String[longitud];
        for (int i = 0; i < longitud; i++) {
            System.out.println("Ingrese los adtos que dese guardar en el arrays");

            nombres[i]= compu.nextLine();
        }
        for (int i = 0; i < longitud; i++) {

            System.out.println(nombres[i]);
        
            
        }


}
} 
