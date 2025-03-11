package entregas.caicedoFernando.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public String toString() {
        if (numerador == 1) {
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }

    public Fraccion(int numerador) {

    }

    public Fraccion() {

    }
}
