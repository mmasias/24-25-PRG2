import java.util.Scanner;
public class llenarunmetodo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Hola usuario de favor de escribir la longitud");
        int longitud= sc.nextInt();
       
        

        String[] nombres = new String[longitud];

        for (int i=0; i<longitud; i++) {
            System.out.println("Ingrese los nombres");

            nombres[i]= sc.nextLine();
}
System.out.println("El la cantidad de datos ingresados fue de "+longitud);
for(int i=0; i<longitud; i++){
    System.out.println("El nombre ingresado fue "+nombres[i]);


}
}
}