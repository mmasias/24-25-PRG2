package entregas.coboIsmael.reto004.Fraccion;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int num = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int den = this.denominador * fraccion.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion sumar(int entero) {
        return new Fraccion(this.numerador + entero * this.denominador, this.denominador);
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return this.sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return new Fraccion(this.numerador - entero * this.denominador, this.denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (this.esIgual(fraccion)) return 0;
        return this.esMayor(fraccion) ? 1 : -1;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }
}
