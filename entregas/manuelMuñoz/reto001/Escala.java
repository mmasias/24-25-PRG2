import java.util.Scanner;

public class Escala{
    String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    int[] sequence = {2,2,1,2,2,2,1};

    String startingNote;
    public static void main(String[] args){
        System.out.print("Dime una nota y te dare su escala mayor: ");
        
        Scanner input = new Scanner(System.in);
        String startingNote = input.nextLine();



        
        input.close();
    }
    
    public String getChord(){
        
        for (int i = 0; i < notes.length; i++){
            if (notes[i].equals(startingNote)){
                System.out.println(notes[i]);
                String key = notes[i];
                return key;
            }
        }
    }
}