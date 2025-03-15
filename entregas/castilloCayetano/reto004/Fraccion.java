package entregas.castilloCayetano.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";
        
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
        int mcd = mcd(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    private int mcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return mcd(b, a % b);
    }
    

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNumerador = numerador * fraccion.denominador + fraccion.numerador * denominador;
        int nuevoDenominador = denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return new Fraccion(numerador + entero * denominador, denominador);
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        int nuevoNumerador = numerador * fraccion.denominador - fraccion.numerador * denominador;
        int nuevoDenominador = denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restar(int entero) {
        return new Fraccion(numerador - entero * denominador, denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.numerador, denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(numerador * entero, denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.denominador, denominador * fraccion.numerador);
    }

    public Fraccion dividir(int entero) {
        return new Fraccion(numerador, denominador * entero);
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
        return valueOf() < fraccion.valueOf();
    }

    public boolean esMayor(Fraccion fraccion) {
        return valueOf() > fraccion.valueOf();
    }

    public boolean esIgual(Fraccion fraccion) {
        return valueOf() == fraccion.valueOf();
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        return Double.compare(valueOf(), fraccion.valueOf());
    }

    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador);
        }
        if (numerador == 0) {
            return "0";
        }
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }

}