package entregas.calderonJimena.reto004;

public class Fraccion {

    private int denominador;
    private int numerador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        if(denominador < 0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }




}
