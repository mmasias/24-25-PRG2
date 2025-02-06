import java.util.Scanner;

public class NoteScale{
    public static void main(String[] args){
        String[] upperScaleMap = new String[12];

        System.out.println("Notas: Do, Do#, Re, Re#, Mi, Fa, Fa#, Sol, Sol#, La, La#, Si");
        System.out.print("Dime una nota y te dare su escala mayor y acorde mayor: ");
        
        Scanner input = new Scanner(System.in);
        String keyNote = input.nextLine();
        
        TwelveNoteMap(keyNote, upperScaleMap);
        TwelveToneScale(upperScaleMap);
        MajorCord(upperScaleMap);

        input.close();
    }
    
    public static void TwelveNoteMap(String keyNote, String[] upperScaleMap){
        String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

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
    }

    public static void TwelveToneScale(String[] upperScaleMap){
        int j = 0, i = 0;
        int[] sequence = {2,2,1,2,2,2,1};

        do{
            System.out.println(upperScaleMap[i] + " ");
            i += sequence[j];
            j++;
        }while(i < upperScaleMap.length);
        System.out.println("Esta es la escala dodecafonica\n");
    }

    public static void MajorCord(String[] upperScaleMap){
        for(int i = 0; i < 5; i += 2){
            System.out.println(upperScaleMap[i]);
        }
        System.out.println("Este es el acorde mayor");
    }
}