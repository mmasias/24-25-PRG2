import java.util.Scanner;
import java.util.Arrays;

public class Escala{
    String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    int[] sequence = {2,2,1,2,2,2,1};

    
    public static void main(String[] args){
        String[] upperScale = new String[12];

        System.out.print("Dime una nota y te dare su escala mayor: ");
        
        Scanner input = new Scanner(System.in);

        Escala noteScale = new Escala();

        String keyNote = input.nextLine();
        
        noteScale.upperScaleMap(keyNote, upperScale);
        
        // noteScale.upperScale(startingNote);

        input.close();
      
    }

    public Escala(){
    }
    
    public void upperScaleMap(String keyNote, String[] upperScale){
        
        for(int i = 0; i < notes.length; i++){
            if (notes[i].equals(keyNote)){
                System.arraycopy(notes, i, upperScale, 0, notes.length-i);
                System.out.println(Arrays.toString(upperScale));
            }
        }

        for(int k = 0; k < notes.length; k++){
            if (upperScale[k] == null){
                System.arraycopy(notes, 0, upperScale, k, notes.length-k);
            }
        }
        System.out.println(Arrays.toString(upperScale));
    }

    public void upperScale(String note){
        String[] upperScale = new String[12];
        upperScale[0] = note;
        while(note != upperScale[upperScale.length - 1]){
            for(int i = 0; i < upperScale.length; i++){
                int tempo = sequence[i];
                try {
                    // do{

                    // }while()
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }
    }
}