package entregas.doaltoBienvenido;

import java.util.Scanner;

class EscalasAcordes {
    static final String[] NOTAS = { "DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI" };
    static final int TONO = 2, SEMITONO = 1, TONOYMEDIO = 3;
    static final int[][] ESCALAS = 
    {
        { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO },
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO },
        { TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO },
        { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO },
        { TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO },
        { TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO },
        { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO },
        { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO },
        { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO },
        { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO },
        { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO },
        { TONO, TONO, TONO, TONO, TONO, TONO }
    };

    public static void main(String[] args) {

        String nota = preguntarNota();
        int[] escalaElegida = preguntarEscala();
        String[] escalaGenerada = construirEscala(nota, escalaElegida);
        String[] acorde = construirAcorde(escalaGenerada);
        
        System.out.println("Escala en " + nota + ":");
        mostrarSecuencia(escalaGenerada);
        System.out.println("Acorde:");
        mostrarSecuencia(acorde);
    }

    static void mostrarSecuencia(String[] secuenciaNotas) {
        for (String nota : secuenciaNotas) {
            System.out.print("[" + nota + "] ");
        }
        System.out.println();
    }

    static String[] construirAcorde(String[] escala) {
        return new String[] { escala[0], escala[2], escala[4] };
    }

    static String[] construirEscala(String nota, int[] intervalos) {
        
        int posicionEnNotas = obtenerIndiceNota(nota);
        String[] escala = new String[intervalos.length];

        for (int i = 0; i < escala.length; i++) {
            escala[i] = NOTAS[posicionEnNotas];
            if (i < intervalos.length) {
                posicionEnNotas = (posicionEnNotas + intervalos[i]) % NOTAS.length;
            }
        }
        return escala;
    }

    static int obtenerIndiceNota(String nota) {
        for (int i = 0; i < NOTAS.length; i++) {
            if (nota.equals(NOTAS[i])) {
                return i;
            }
        }
        return -1;
    }

    static String preguntarNota() {
        System.out.println("Elige Nota -> 1:do, 2:do#, 3:re...");
        int nota = new Scanner(System.in).nextInt();
        return NOTAS[nota - 1];
        
    }
    static int[] preguntarEscala() {
        System.out.println("Elige Escala:");
        System.out.println("1: Mayor");
        System.out.println("2: Menor natural");
        System.out.println("3: Menor armónica");
        System.out.println("4: Menor melódica");
        System.out.println("5: Pentatónica mayor");
        System.out.println("6: Pentatónica menor");
        System.out.println("7: Dórica");
        System.out.println("8: Frigia");
        System.out.println("9: Lidia");
        System.out.println("10: Mixolidia");
        System.out.println("11: Locria");
        System.out.println("12: Por tonos");
        int escala = new Scanner(System.in).nextInt();
        return ESCALAS[escala - 1];
    }
}