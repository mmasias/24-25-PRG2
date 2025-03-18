package entregas.puenteSergio.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
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

    public Fraccion sumar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion restar(Fraccion otra) {
        return sumar(otra.opuesta());
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(this.numerador * otra.numerador, this.denominador * otra.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion dividir(Fraccion otra) {
        return multiplicar(otra.inversa());
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero));
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion inversa() {
        if (this.numerador == 0) {
            throw new ArithmeticException("No se puede invertir una fracción con numerador 0");
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public boolean esMenorQue(Fraccion otra) {
        return this.numerador * otra.denominador < otra.numerador * this.denominador;
    }

    public boolean esMayorQue(Fraccion otra) {
        return this.numerador * otra.denominador > otra.numerador * this.denominador;
    }

    public boolean esIgualA(Fraccion otra) {
        return this.numerador * otra.denominador == otra.numerador * this.denominador;
    }

    public int compareTo(Fraccion otra) {
        return Integer.compare(this.numerador * otra.denominador, otra.numerador * this.denominador);
    }

    public double valorDecimal() {
        return (double) this.numerador / this.denominador;
    }

    
    public String toString() {
        return numerador + "/" + denominador;
    }

    
    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    private void simplificar() {
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
    }

    private int calcularMCD(int a, int b) {
        return b == 0 ? a : calcularMCD(b, a % b);
    }
}