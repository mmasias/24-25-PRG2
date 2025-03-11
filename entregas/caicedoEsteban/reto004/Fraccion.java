package entregas.caicedoEsteban.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;

        int mcd = mcd(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }
}
