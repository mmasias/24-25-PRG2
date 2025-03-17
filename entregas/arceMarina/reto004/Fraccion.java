package entregas.arceMarina.reto004.reto004;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0: "El denominador no puede ser 0";

        if (denominador < 0) {
            numerador = -numerador;
            denominador  = -denominador;
        }
        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador/ mcd;
        this.denominador = denominador/mcd;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }
}