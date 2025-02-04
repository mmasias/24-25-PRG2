import java.util.Scanner;
import java.util.Arrays;

public class Escala{
    String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    int[] sequence = {2,2,1,2,2,2,1};

    String startingNote;
    public static void main(String[] args){
        System.out.print("Dime una nota y te dare su escala mayor: ");
        
        Scanner input = new Scanner(System.in);

        Escala noteScale = new Escala();

        String startingNote = input.nextLine();
        
        noteScale.getChord(startingNote);
        
        noteScale.upperScale(startingNote);

        input.close();
      
    }

    public Escala(){

    }
    
    public String getChord(String startingNote){
        String note = "";

        for (int i = 0; i < notes.length; i++){
            if (notes[i].equals(startingNote)){
                note = notes[i];
            }
        }
        return note;  
    }

    public void upperScale(String note){
        String[] upperScale = new String[12];
        upperScale[0] = note;
        while(note != upperScale[upperScale.length - 1]){
            for(int i = 0; i < upperScale.length; i++){
                int tempo = sequence[i];
                // do{}while()

            }
        }
    }
}