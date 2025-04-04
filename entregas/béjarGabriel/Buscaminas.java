import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tablero tablero = new Tablero(6, 6, 6);
        boolean juegoActivo = true;
        while (juegoActivo) {
            tablero.mostrarTablero();
            System.out.println("[D]espejar o [M]arcar mina?");
            String accion = sc.nextLine().trim().toUpperCase();
            if (accion.equals("D") || accion.equals("M")) {
                System.out.println("Elija coordenada:");
                System.out.print("> Fila: ");
                int fila = sc.nextInt();
                System.out.print("> Columna: ");
                int columna = sc.nextInt();
                sc.nextLine();
                if (fila < 1 || fila > 6 || columna < 1 || columna > 6) {
                    System.out.println("Coordenada invalida");
                    continue;
                }
                if (accion.equals("D")) {
                    boolean resultado = tablero.despejar(fila - 1, columna - 1);
                    System.out.println("Coordenada despejada");
                    if (!resultado) {
                        tablero.mostrarTablero();
                        System.out.println("Derrota");
                        juegoActivo = false;
                        continue;
                    }
                } else if (accion.equals("M")) {
                    tablero.marcar(fila - 1, columna - 1);
                    System.out.println("Coordenada marcada");
                }
                if (tablero.verificarVictoria()) {
                    tablero.mostrarTablero();
                    System.out.println("Victoria");
                    juegoActivo = false;
                }
            }
        }
        sc.close();
    }
}