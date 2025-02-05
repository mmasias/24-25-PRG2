import java.util.Scanner;

class EscalaAcordes {
    public static void main(String[] args) {
        int notaATrabajar = pedirNota();
        int[] escala = crearEscala(notaATrabajar);
        int[] acorde = crearAcorde(escala);
    }

    static int[] crearEscala(int notaATrabajar) {
        int[] escala = new int[8];

        String[] notas = getNotas();

        return escala;
    }

    static String[] getNotas() {
       String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        return notas;
    }

    static int[] crearAcorde() {
        int[] acorde = new int[3];

        return acorde;
    }

    static int pedirNota() {
        Scanner sc = new Scanner(System.in);
        int resultado = sc.nextInt();
        return resultado;
    }
}