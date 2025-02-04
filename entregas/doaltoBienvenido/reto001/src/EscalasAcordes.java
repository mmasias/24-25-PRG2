import java.util.Scanner;

public class EscalasAcordes {
    public static void main(String[] args) 
    {

        String[] acordes = {"Do", "Do#", "Re","Re#", 
                            "Mi", "Fa", "Fa#","Sol", 
                            "Sol#", "La", "La#", "Si"};

        int[] intervalos = {2, 2, 1, 2, 2, 2, 1}; 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una nota a trabajar: 0: Do, 1: Do#, 2: Re, 3: Re#, 4: Mi, ...");
        int imputUsuario = scanner.nextInt();
                            
        
        String notaElegida = acordes[imputUsuario];
        System.out.println("Ha elegido la nota " + notaElegida);
        
        
        String[] escalaMayor = new String[8];
        int indice = imputUsuario;
        for (int i = 0; i < 7; i++) {
            escalaMayor[i] = acordes[indice];
            indice = (indice + intervalos[i]) % 12;
        }
        escalaMayor[7] = escalaMayor[0]; 
        
        System.out.print("La escala de " + notaElegida + " Mayor es: ");
        for (String nota : escalaMayor) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();
        
        String[] acordeMayor = {acordes[imputUsuario], acordes[(imputUsuario + 4) % 12], acordes[(imputUsuario + 7) % 12]};
        System.out.print("El acorde de " + notaElegida + " Mayor está conformado por: ");
        for (String nota : acordeMayor) {
            System.out.print("[" + nota + "] / ");
        }
        System.out.println();   
    }            
}

