package reto001;
import java.util.Scanner;

public class EscalaAcordes {
    public static void main(String[] args) {
        int numeroNota = pedirNota();
        String[] escala = construirEscalaMayor(numeroNota);

        
    }
    public static int pedirNota() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Seleccione una nota para construir su escala mayor y su acorde mayor ");
        System.out.println("(1. Do), (2. Do#), (3. Re),(4. Re#), (5. Mi), (6. Fa),(7. Fa#), (8. Sol),(9. Sol#),(10. La),(11. La#), (12. Si)");
       
        System.out.print("Introduce un número entre 1 y 12: ");
        int numeroNota = entrada.nextInt();
        
        return numeroNota;
    }

    public static String[] construirEscalaMayor(int indiceNota) {
        final int NUMERO_DE_NOTAS_MUSICALES = 12;
        String[] notasMusicales = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        
        int indice = indiceNota;
        
        
        int[] pasos = {2, 2, 1, 2, 2, 2, 1}; 
        String[] escala = new String[8];
        
        
        escala[0] = notasMusicales[indice];

        
        for (int i = 1; i < escala.length; i++) {
            
            indice = (indice + pasos[i]) % NUMERO_DE_NOTAS_MUSICALES; 
            
            
            escala[i] = notasMusicales[indice];
        }

        return escala;
    }

    
}