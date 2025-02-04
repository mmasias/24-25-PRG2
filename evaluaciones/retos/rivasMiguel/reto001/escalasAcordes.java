import java.util.Scanner;
import java.util.Arrays;

public class escalasAcordes {
    public static void main(String[] args) {    
        String[] acordes = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un acorde: ");
        String acorde = scanner.nextLine().toUpperCase();
        int posicion = Arrays.asList(acordes).indexOf(acorde);

        String[] acordesReordenados = new String[acordes.length];
        
        for (int i = 0; i < acordes.length; i++) {
            acordesReordenados[i] = acordes[(posicion + i) % acordes.length];
        }

        String[] escala = {acordesReordenados[0], acordesReordenados[2], acordesReordenados[4], acordesReordenados[5], acordesReordenados[7], acordesReordenados[9], acordesReordenados[11], acordesReordenados[0]};

        System.out.println("\nEscala:");
        for (String a : escala) {
            System.out.print(a + " ");
        }

        String[] acordeMayor = {acordesReordenados[0], acordesReordenados[4], acordesReordenados[7]};

        System.out.println("\nAcorde mayor:");
        for (String a : acordeMayor) {
            System.out.print(a + " ");
        }

        scanner.close();
    }
}