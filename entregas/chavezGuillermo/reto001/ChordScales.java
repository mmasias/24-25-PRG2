import java.util.Scanner;
class ChordScales{
    public static void main(String[] args) {
        // final int PIANO[]={2,1,2,1,2,2,1,2,1,2,1,2};
        final String NOTES[]={"DO","DO#","RE","RE#","MI","FA","FA#","SOL","SOL#","LA","LA#","SI",};
        int mayor[]={0,2,2,1,2,2,2,1};
        Scanner input = new Scanner(System.in);
        System.out.println("Mayor scale of what note?:");
        int userNote=input.nextInt();
        input.close();
        
        for(int i=0;i<=mayor.length;){
            System.out.println(NOTES[(userNote+mayor[i])]);
            i=i+1;
        }
        System.out.println(NOTES.length);
        
    }
}