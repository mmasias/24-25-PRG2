import java.util.Scanner;

public class EscalaAcordes {

    public static int askNote() {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Selecciona una nota para construir su scale mayor: 1. Do, 2. Do#, 3. Re, 4. Re#, 5. Mi, 6. Fa, 7. Fa#, 8. Sol, 9. Sol#, 10. La, 11. La#, 12. Si");    
        System.out.print("Introduce un número entre 1 y 12: ");
        int noteValue = scanner.nextInt();
        return noteValue;
    }
    
    public static String[] buildScale(int noteIndex) {
        String[] noteBank = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        
        if (noteIndex < 1 || noteIndex > 12) {
            System.out.println("Número de nota inválido.");
            return null;
        }
    
        int index = noteIndex - 1;
        
        int[] skips = {2, 2, 1, 2, 2, 2, 1}; 
        String[] scale = new String[8];
        
        scale[0] = noteBank[index];
        
        for (int i = 1; i < 8; i++) {
            index = (index + skips[i - 1]) % 12; 
            scale[i] = noteBank[index];}
        return scale;
    }

    public static void printScale(String[] scale) {
        if (scale != null) {
            System.out.print("La scale mayor es: ");
            for (String nota : scale) {
                System.out.print(nota + " ");}
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int noteValue = askNote();
        String[] scale = buildScale(noteValue);
        printScale(scale);
    }
}
