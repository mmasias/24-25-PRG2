import java.util.Scanner;
class ChordScales{
    public static void main(String[] args) {
        final String NOTES[]={"DO","DO#","RE","RE#","MI","FA","FA#","SOL","SOL#","LA","LA#","SI",};
        for(int i=0;i<NOTES.length;){
        System.out.println((i+1)+" - "+NOTES[i]);
        i=i+1;
	}
        String Scale="mayor";
        int mayor[]={2,2,1,2,2,2,1};
        Scanner input = new Scanner(System.in);
        System.out.println("Mayor scale of what note?:");
        int userNote=(input.nextInt())-1;
        input.close();
        int j=userNote;
        System.out.println(Scale+" of "+NOTES[j]);
        for(int i=0;i<=(mayor.length);){
            System.out.print(NOTES[j]+" ");
            j=(j+mayor[i]);
            if(j>NOTES.length){
                j=j%NOTES.length;
            }
            i=i+1;
        }
    }
}