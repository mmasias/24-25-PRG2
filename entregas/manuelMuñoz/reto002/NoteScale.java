import java.util.Scanner;

public class NoteScale{
    final static int TONE = 2, SEMI_TONE = 1;
    public static void main(String[] args){
        String keyNote = userInput();
        String[] upperScaleMap = twelveNoteMap(keyNote);
        mayorScale(upperScaleMap);
        minorScale(upperScaleMap);
    }
    
    static String userInput(){
        System.out.println("Notas: Do, Do#, Re, Re#, Mi, Fa, Fa#, Sol, Sol#, La, La#, Si");
        System.out.print("Dime una nota y te dare su escala mayor y acorde mayor: ");
        
        Scanner input = new Scanner(System.in);
        String keyNote = input.nextLine();
        input.close();
        
        return keyNote;
    }
    
    static String[] twelveNoteMap(String keyNote){
        String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] upperScaleMap = new String[12];

        for(int i = 0; i < notes.length; i++){
            if (notes[i].equals(keyNote)){
                System.arraycopy(notes, i, upperScaleMap, 0, notes.length-i);
            }
        }
        
        for(int i = 0; i < notes.length; i++){
            if (upperScaleMap[i] == null){
                System.arraycopy(notes, 0, upperScaleMap, i, notes.length-i);
            }
        }
        return upperScaleMap;
    }

    static void mayorScale(String[] upperScaleMap){
        int[] mayorScaleTempo = {TONE,TONE,SEMI_TONE,TONE,TONE,TONE,SEMI_TONE};
        int i = 0, j = 0;
        
        do{
            System.out.print(upperScaleMap[i] + " ");
            i += mayorScaleTempo[j];
            j++;
        }while(i < upperScaleMap.length);
        System.out.println("\nEsta es la escala mayor\n");
    }

    static void minorScale(String[] upperScaleMap){
        int[] minorScaleTempo = {TONE, SEMI_TONE, TONE, TONE, SEMI_TONE, TONE, TONE};
        int i = 0, j = 0;
        
        do{
            System.out.print(upperScaleMap[i] + " ");
            i += minorScaleTempo[j];
            j++;
        }while(i < upperScaleMap.length);
        System.out.println("\nEste es el escala menor\n");
    }
}