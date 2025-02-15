
import java.util.Scanner;

public class EscalasYAcordesExtendido{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        int[] patronEscalaMayor = {2, 2, 1, 2, 2, 2, 1};
        int[] patronEscalaMenorNatural = {2, 1, 2, 2, 1, 2, 2};
        int[] patronEscalaMenorArmónica = {2, 1, 2, 2, 1, 3, 1};
        int[] patronEscalaMenorMelódica = {2, 1, 2, 2, 2, 2, 1};
        int[] patronEscalaPentatonicaMayor = {2,2,3,2,3};
        int[] patronEscalaPentatonicaMenor = {3,2,2,3,2};
        int[] patronEscalaDorica = {2,1,2,2,2,1,2};
        int[] patronEscalaFrigia = {1,2,2,2,1,2,2};
        int[] patronEscalaLidia = {2,2,2,1,2,2,1};
        int[] patronEscalaMixolidia = {2,2,1,2,2,1,2};
        int[] patronEscalaLocria = {1,2,2,1,2,2,2};
        int[] patronEscalaPorTonos = {2,2,2,2,2,2};


        String notaEscalaMayor;

        System.out.print("Ingrese una nota (Do, Re, Mi, etc.): ");

        String notaBase = scanner.nextLine();

        int indice = -1;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i].equalsIgnoreCase(notaBase)) {
                indice = i;
            }
        }

        System.out.println("Escala mayor de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaMayor.length; i++) {
            indice += (patronEscalaMayor[i]);
            notaEscalaMayor = CalcularEscala(i, notas, patronEscalaMayor, indice);
            System.out.print(notaEscalaMayor+",");
        }

        System.out.println();
        System.out.println("Escala menor natural de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaMenorNatural.length; i++) {
            indice += (patronEscalaMenorNatural[i]);
            CalcularEscala(i, notas, patronEscalaMenorNatural, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaMenorNatural, indice)+",");
        }
        
        System.out.println();
        System.out.println("Escala menor armónica de "+notaBase);
        System.out.print(notaBase+", ");
        
        for (int i = 0; i < patronEscalaMenorArmónica.length; i++) {
            indice += (patronEscalaMenorArmónica[i]);
            CalcularEscala(i, notas, patronEscalaMenorArmónica, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaMenorArmónica, indice)+",");
        }

        System.out.println();
        System.out.println("Escala menor melódica de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaMenorMelódica.length; i++) {
            indice += (patronEscalaMenorMelódica[i]);
            CalcularEscala(i, notas, patronEscalaMenorMelódica, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaMenorMelódica, indice)+",");
        }

        System.out.println();
        System.out.println("Escala pentatónica mayor de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaPentatonicaMayor.length; i++) {
            indice += (patronEscalaPentatonicaMayor[i]);
            CalcularEscala(i, notas, patronEscalaPentatonicaMayor, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaPentatonicaMayor, indice)+",");
        }

        System.out.println();
        System.out.println("Escala pentatónica menor de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaPentatonicaMenor.length; i++) {
            indice += (patronEscalaPentatonicaMenor[i]);
            CalcularEscala(i, notas, patronEscalaPentatonicaMenor, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaPentatonicaMenor, indice)+",");
        }

        System.out.println();
        System.out.println("Escala dórica de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaDorica.length; i++) {
            indice += (patronEscalaDorica[i]);
            CalcularEscala(i, notas, patronEscalaDorica, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaDorica, indice)+",");
        }


        System.out.println();
        System.out.println("Escala frigia de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaFrigia.length; i++) {
            indice += (patronEscalaFrigia[i]);
            CalcularEscala(i, notas, patronEscalaFrigia, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaFrigia, indice)+",");
        }

        System.out.println();
        System.out.println("Escala lidia de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaLidia.length; i++) {
            indice += (patronEscalaLidia[i]);
            CalcularEscala(i, notas, patronEscalaLidia, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaLidia, indice)+",");
        }

        System.out.println();
        System.out.println("Escala mixolidia de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaMixolidia.length; i++) {
            indice += (patronEscalaMixolidia[i]);
            CalcularEscala(i, notas, patronEscalaMixolidia, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaMixolidia, indice)+",");
        }

        System.out.println();
        System.out.println("Escala locria de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaLocria.length; i++) {
            indice += (patronEscalaLocria[i]);
            CalcularEscala(i, notas, patronEscalaLocria, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaLocria, indice)+",");
        }

        System.out.println();
        System.out.println("Escala por tonos de "+notaBase);
        System.out.print(notaBase+", ");

        for (int i = 0; i < patronEscalaPorTonos.length; i++) {
            indice += (patronEscalaPorTonos[i]);
            CalcularEscala(i, notas, patronEscalaPorTonos, indice);
            System.out.print(CalcularEscala(i, notas, patronEscalaPorTonos, indice)+",");
        }

        scanner.close();

    }

    static String CalcularEscala(int i, String[] notas, int[] patron, int indice) {

        indice = indice % 12;
        return (notas[indice]);

    }

}
