package src.calderonJimena.Gato;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    public void pedir() {
        do{
        System.out.println("Dime la fila (1 a 3)");
        this.fila = new Scanner(System.in).nextInt();
        System.out.println("Dime la columna (1 a 3)");
        columna = new Scanner(System.in).nextInt();
        }while (!esValida());
    }

    public boolean esValida() {
        return (fila >- 1 && fila <= 3 && columna >= 1 && columna <= 3);
        
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
       return columna;
    }

}
