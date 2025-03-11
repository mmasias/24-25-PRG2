package chaoZhen.reto004;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
       assert denominador !=0:"INVALIDACIÓN";

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
        int mcd = mcd(Math.abs(numerador), denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        } else {
            return numerador + " / " + denominador;
        }

    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion(int numerador) {

    }

    public Fraccion() {

    }
}
