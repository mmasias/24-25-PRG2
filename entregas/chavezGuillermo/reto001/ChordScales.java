import java.util.Scanner;
class ChordScales{
    public static void main(String[] args) {
        final String NOTES[]={"DO","DO#","RE","RE#","MI","FA","FA#","SOL","SOL#","LA","LA#","SI",};
        for(int i=0;i<NOTES.length;){
        System.out.println((i+1)+" - "+NOTES[i]);
        i=i+1;
	}
        int mayor[]={0,2,2,1,2,2,2,1};
        Scanner input = new Scanner(System.in);
        System.out.println("Mayor scale of what note?:");
        int userNote=input.nextInt();
        input.close();
        for(int i=0,j=0;i<=mayor.length;){
            System.out.println(NOTES[(userNote+mayor[(j%NOTES.length)])]);
            j=j+mayor[i];
            i=i+1;}
    }
}