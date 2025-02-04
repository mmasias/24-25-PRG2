package entregas.delaasuncionJose.reto001;

import java.util.Scanner;

class EscalaAcordes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] notasEscalaMayor = new String[8];
        calcularEscalamayor(notasEscalaMayor, 1);
        entrada.close();
    }

    static void calcularEscalamayor(String[] notasEscalaMayor,int nota) {
        final String[] tonos = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
        final int[] patron = {2,2,1,2,2,2,1};

        for (int i=0; i<= patron.length ;i++){
            notasEscalaMayor[i] = tonos[nota];
            nota += patron[i];
        }
    }
}
