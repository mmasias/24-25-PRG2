package entregas.béjarGabriel;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "Imposible dividir entre 0";
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    private void simplificar() {
        int gcd = gcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= gcd;
        denominador /= gcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null;
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir() {
        assert numerador != 0 : "No es posible que el numerador sea 0";
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0 : "No se puede dividir por una fracción con numerador 0";
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero));
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(numerador, exponente), (int) Math.pow(denominador, exponente));
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return compareTo(fraccion) < 0;
    }

    public boolean esMayor(Fraccion fraccion) {
        return compareTo(fraccion) > 0;
    }

    public boolean esIgual(Fraccion fraccion) {
        return compareTo(fraccion) == 0;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        return Integer.compare(this.numerador * fraccion.denominador, fraccion.numerador * this.denominador);
    }

    public String toString() {
        return denominador == 1 ? String.valueOf(numerador) : numerador + "/" + denominador;
    }

    @Override
    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}