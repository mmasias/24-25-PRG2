package entregas.delaasuncionJose.reto001;

import java.util.Scanner;

class EscalaAcordes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] notasEscalaMayor = new String[8];
        String[] notasAcordeMayor = new String[3];
        calcularEscalaMayor(notasEscalaMayor, (obtenerNumeroUsuario(12,1,entrada)-1));
        calcularAcordeMayor(notasAcordeMayor, notasEscalaMayor);
        contarHistoria(notasAcordeMayor, notasEscalaMayor);

        entrada.close();
    }

    static int obtenerNumeroUsuario(int maximo, int minimo, Scanner entrada) {
        final String ERROR = "| >  Porfavor introduzca un numero dentro del intervalo de [1,12]∈ N";
        final String EMBELLECEDOR = "| >  ";
        int numeroUsuario;
        boolean taMal;

        do {
            System.out.print(EMBELLECEDOR);
            while(!entrada.hasNextInt()){
                System.out.println(ERROR);
                entrada.next();
                System.out.print(EMBELLECEDOR);
            }
            numeroUsuario = entrada.nextInt();
            taMal = numeroUsuario > maximo || numeroUsuario < minimo;
            if (taMal) {
                System.out.println(ERROR);
            }
        } while(taMal);
        return numeroUsuario;
    }

    static void calcularEscalaMayor(String[] notasEscalaMayor,int nota) {
        final String[] TONOS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        final int[] PATRON = {2,2,1,2,2,2,1};

        for (int i = 0; i < PATRON.length; i++) {
            notasEscalaMayor[i] = TONOS[nota];
            nota = (nota + PATRON[i]) % 12;
        }
        notasEscalaMayor[PATRON.length] = TONOS[nota];
    }

    static void calcularAcordeMayor(String[] notasAcordeMayor, String[] notasEscalaMayor) {
        final int[] GRADOS = {0, 2, 4};

        for (int i = 0; i < GRADOS.length; i++) {
            notasAcordeMayor[i] = notasEscalaMayor[GRADOS[i]];
        }
    }
    
    static void contarHistoria(String[] notasAcordeMayor, String[] notasEscalaMayor) {
        System.out.print("La escala de " + notasEscalaMayor[0] + " Mayor es: ");
        mostrarSecuencia(notasEscalaMayor);
        System.out.println();

        System.out.print("El acorde de " + notasAcordeMayor[0] + " Mayor está conformado por: ");
        mostrarSecuencia(notasAcordeMayor);
    }

    static void mostrarSecuencia(String[] secuencia) {
        for (int i = 0; i < secuencia.length; i++) {
            System.out.print("[" + secuencia[i] + "]");
            if (i < secuencia.length - 1) {
                System.out.print(" / ");
            }
        }
    }
}
