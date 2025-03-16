package entregas.lianoJavier.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        alternarPolaridad(numerador, denominador);

        int maximoComunDivisor = calcularMaximoComunDivisor(Math.abs(numerador), Math.abs(denominador));
        this.numerador = numerador / maximoComunDivisor;
        this.denominador = denominador / maximoComunDivisor;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    private void alternarPolaridad(int numerador2, int denominador2) {
        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }
    }

    private int calcularMaximoComunDivisor(int primerValor, int segundoValor) {
        return segundoValor == 0 ? primerValor : calcularMaximoComunDivisor(segundoValor, primerValor % segundoValor);
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        }
        return numerador + "/" + denominador;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoDenominador = denominador * fraccion.denominador;
        int nuevoNumerador = numerador * fraccion.denominador + fraccion.numerador * denominador;
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
        int nuevoNumerador = numerador * fraccion.numerador;
        int nuevoDenominador = denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
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
        return numerador * fraccion.denominador < fraccion.numerador * denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return numerador * fraccion.denominador > fraccion.numerador * denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return numerador * fraccion.denominador == fraccion.numerador * denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (esMenor(fraccion)) {
            return -1;
        } else if (esMayor(fraccion)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}
