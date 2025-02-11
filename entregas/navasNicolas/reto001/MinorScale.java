import java.util.Scanner;

class MinorScale {
    public static void main(String[] args) {
        int noteValue = askNote();
        String[] scale = buildScale(noteValue);
        printScale(scale);
    }
    
    public static int askNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una nota para construir su escala Menor: 1. Do, 2. Reb, 3. Re, 4. Mib, 5. Mi, 6. Fa, 7. Solb, 8. Sol, 9. Lab, 10. La, 11. Sib, 12. Si");    
        System.out.print("Introduce un número entre 1 y 12: ");
        int noteValue = scanner.nextInt();
        return noteValue;
    }
    
    public static String[] buildScale(int noteIndex) {
        String[] noteBank = {"Do", "REb", "Re", "Mib", "Mi", "Fa", "Solb", "Sol", "Lab", "La", "Sib", "Si"};
        
        if (noteIndex < 1 || noteIndex > 12) {
            System.out.println("Número de nota inválido.");
            return null;
        }
    
        int index = noteIndex - 1;
        final int TONE = 2, HALFTONE = 1;
        int[] skips = {TONE, HALFTONE, TONE, TONE, HALFTONE, TONE, TONE}; 
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
}
