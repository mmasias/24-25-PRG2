package entregas.grizoniManuela.Reto004;

import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private int minas;
    
    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        casillas = new Casilla[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        colocarMinas();
    }
    
    private void colocarMinas() {
        Random random = new Random();
        int count = 0;
        while (count < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!casillas[fila][columna].isMina()) {
                casillas[fila][columna].setMina(true);
                count++;
            }
        }
    }
    
    public boolean despejar(int fila, int columna) {
        if (casillas[fila][columna].isMarcada() || casillas[fila][columna].isRevelada()) {
            return true;
        }
        casillas[fila][columna].setRevelada(true);
        if (casillas[fila][columna].isMina()) {
            return false;
        }
        return true;
    }
    
    public void marcar(int fila, int columna) {
        if (!casillas[fila][columna].isRevelada()) {
            casillas[fila][columna].setMarcada(true);
        }
    }
    
    public boolean verificarVictoria() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].isMina() && !casillas[i][j].isRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void mostrarTablero() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int j = 1; j <= columnas; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].isRevelada()) {
                    System.out.print("D ");
                } else if (casillas[i][j].isMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
