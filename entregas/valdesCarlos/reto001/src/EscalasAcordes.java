import java.util.Scanner;

public class EscalasAcordes {

    public static void main(String[] args) {
        int opcion = pedirNota();

        String[] escala = construirEscala(opcion);
        mostrarEscala(escala);

        String acorde = construirAcorde(escala);
        mostrarAcorde(acorde);
    }

    public static int pedirNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número correspondiente a la nota que quiere trabajar: 1: Do, 2: Do#, 3: Re, 4: Re#, 5: Mi, 6: Fa, 7: Fa#, 8: Sol, 9: Sol#, 10: La, 11: La#, 12: Si");
        return scanner.nextInt();
    }

    public static String[] construirEscala(int opcion) {
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        String[] escalaMayor = new String[8];
        
        int indiceBase = opcion - 1;

        escalaMayor[0] = notas[indiceBase]; 
        indiceBase = (indiceBase + 2) % 12;
        escalaMayor[1] = notas[indiceBase];
        indiceBase = (indiceBase + 2) % 12;
        escalaMayor[2] = notas[indiceBase];
        indiceBase = (indiceBase + 1) % 12;
        escalaMayor[3] = notas[indiceBase];
        indiceBase = (indiceBase + 2) % 12;
        escalaMayor[4] = notas[indiceBase];
        indiceBase = (indiceBase + 2) % 12;
        escalaMayor[5] = notas[indiceBase];
        indiceBase = (indiceBase + 2) % 12;
        escalaMayor[6] = notas[indiceBase];
        indiceBase = (indiceBase + 1) % 12;
        escalaMayor[7] = notas[indiceBase];
        
        return escalaMayor;
    }

    public static void mostrarEscala(String[] escala) {
        System.out.print("La escala mayor es: ");
        for (String nota : escala) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    public static String construirAcorde(String[] escala) {
        return "[" + escala[0] + "] / [" + escala[2] + "] / [" + escala[4] + "]";
    }

    public static void mostrarAcorde(String acorde) {
        System.out.println("El acorde mayor está conformado por: " + acorde);
    }
}
