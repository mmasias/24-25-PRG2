package entregas.rubioRicardo.reto001;

import java.util.Scanner;

public class escalasAcordes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] notas = {
                "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
        };

        System.out.println("Ingrese una la nota a trabajar: ");
        System.out.println("0: Do, 1: Do#, 2: Re, 3: Re#, 4: Mi, 5: Fa, 6: Fa#, 7: Sol, 8: Sol#, 9: La, 10: La#, 11: Si");

        int notaElegidaUsuario = scanner.nextInt();
        String notaElegida = notas[notaElegidaUsuario];
        
        System.out.println("Ha elegido la nota " + notaElegida);
        String[] escalaMayor = calcularEscalaMayor(notaElegida, notas);
        String[] acordeMayor = calcularAcordeMayor(notaElegida, notas);
        imprimirEscalaMayor(escalaMayor);
        imprimirAcordeMayor(acordeMayor);
            scanner.close();
            
        }
        public static String[] calcularEscalaMayor(String notaElegida, String[] notas) {
                int[] intervalosEscalaMayor = { 2, 2, 1, 2, 2, 2, 1 };
                int posicionNotaElegida = -1;
                int posicionActual = 0;
                int contadorNotas = 1;
            
                String[] escalaMayor = new String[8]; 
                escalaMayor[0] = notaElegida;
            
                
                while (posicionActual < notas.length) {
                    if (notas[posicionActual] == notaElegida) {
                        posicionNotaElegida = posicionActual;
                    }
                    posicionActual++;
                }
            
                
                while (contadorNotas < escalaMayor.length) {
                    posicionNotaElegida = (posicionNotaElegida + intervalosEscalaMayor[contadorNotas - 1]) % notas.length;
                    escalaMayor[contadorNotas] = notas[posicionNotaElegida];
                    contadorNotas++;
                }
            
                
 
            
                return escalaMayor;
            }
            public static String[] calcularAcordeMayor(String notaElegida, String[] notas) {
                int[] intervalosAcordeMayor = { 0, 4, 7 }; 
                int posicionNotaElegida = -1;
                int posicionActual = 0;
                int contadorNotas = 0;
            
                String[] acordeMayor = new String[3];
            
                
                while (posicionActual < notas.length) {
                    if (notas[posicionActual] == notaElegida) {
                        posicionNotaElegida = posicionActual;
                    }
                    posicionActual++;
                }
            
                
                while (contadorNotas < acordeMayor.length) {
                    int posicionNota = (posicionNotaElegida + intervalosAcordeMayor[contadorNotas]) % notas.length;
                    acordeMayor[contadorNotas] = notas[posicionNota];
                    contadorNotas++;
                }
            
            
                return acordeMayor;
            }
            
            public static void imprimirEscalaMayor(String[] escalaMayor){
                System.out.print("Escala mayor: ");
                for (int i = 0; i < escalaMayor.length; i++) {
                    System.out.print(escalaMayor[i] + " ");
                }
                System.out.println();
            }

            public static void imprimirAcordeMayor(String[] acordeMayor){
                System.out.print("Acorde mayor: ");
                for (int i = 0; i < acordeMayor.length; i++) {
                    System.out.print(acordeMayor[i] + " ");
                }
                System.out.println();
            }

           
        

}
