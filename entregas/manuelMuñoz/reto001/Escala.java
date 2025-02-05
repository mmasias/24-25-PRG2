import java.util.Scanner;
import java.util.Arrays;

public class Escala{
    String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    
    int[] sequence = {2,2,1,2,2,2,1};

    public static void main(String[] args){
        String[] upperScaleMap = new String[12];

        System.out.print("Dime una nota y te dare su escala mayor: ");
        
        Scanner input = new Scanner(System.in);

        Escala noteScale = new Escala();

        String keyNote = input.nextLine();
        
        noteScale.upperScaleMap(keyNote, upperScaleMap);
        
        noteScale.upperScale(upperScaleMap);

        input.close();
      
    }

    public Escala(){
    }
    
    public void upperScaleMap(String keyNote, String[] upperScaleMap){
        
        for(int i = 0; i < notes.length; i++){
            if (notes[i].equals(keyNote)){
                System.arraycopy(notes, i, upperScaleMap, 0, notes.length-i);
            }
        }

        for(int k = 0; k < notes.length; k++){
            if (upperScaleMap[k] == null){
                System.arraycopy(notes, 0, upperScaleMap, k, notes.length-k);
            }
        }
        System.out.println(Arrays.toString(upperScaleMap));
    }

    public void upperScale(String[] upperScaleMap){
        int j = 0;
        int i = 0;

        do{
            System.out.print(upperScaleMap[i] + " ");
            i += sequence[j];
            j++;
        }while(i < upperScaleMap.length);
    // return upperScaleMap;
    }
}