package reto001;
import java.util.Scanner;

public class EscalaAcordes {
    public static void main(String[] args) {
        int numeroNota = pedirNota();
        String[] escalaMayor = construirEscalaMayor(numeroNota -1);
        String[] acordeMayor = construirAcordeMayor(escalaMayor);
        System.out.println("Acorde mayor: " + acordeMayor[0] + " - " + acordeMayor[1] + " - " + acordeMayor[2]);
        mostrarEscala(escalaMayor);



        
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

        
        for (int i = 0; i < pasos.length; i++) {
            
            indice = (indice + pasos[i]) % NUMERO_DE_NOTAS_MUSICALES; 
            escala[i+1] = notasMusicales[indice];
        }

        return escala;
    }

    public static String[] construirAcordeMayor(String[] escala) {
        return new String[]{escala[0], escala[2], escala[4]};
    }
    public static void mostrarEscala(String[] escala) {
        System.out.println("Escala mayor:");

        for (int i = 0; i < escala.length; i++) {
            System.out.print(escala[i] + "----" );
           
        }
        System.out.println();
    }

    
}