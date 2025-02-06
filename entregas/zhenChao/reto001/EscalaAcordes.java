package reto001;
import java.util.Scanner;

public class EscalaAcordes {
    public static void main(String[] args) {
        int numeroNota = pedirNota();

        
    }
    public static int pedirNota() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Seleccione una nota para construir su escala mayor y su acorde mayor ");
        System.out.println("(1. Do), (2. Do#), (3. Re),(4. Re#), (5. Mi), (6. Fa),(7. Fa#), (8. Sol),(9. Sol#),(10. La),(11. La#), (12. Si)");
       
        System.out.print("Introduce un número entre 1 y 12: ");
        int numeroNota = entrada.nextInt();
        
        return numeroNota;
    }
    
}