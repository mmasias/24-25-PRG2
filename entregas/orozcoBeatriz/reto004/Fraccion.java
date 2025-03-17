package entregas.orozcoBeatriz.reto004;

public class Fraccion {

    private int numerador, denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.println("El denominador no puede ser 0. Será 1.");
            denominador = 1;
        } else if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int maximoComunDivisor = maximoComunDivisor(Math.abs(numerador), denominador);
        this.numerador = numerador / maximoComunDivisor;
        this.denominador = denominador / maximoComunDivisor;
    }

    private int maximoComunDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominadorNuevo = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion sumar(int entero) {
        int numeradorNuevo = this.numerador + entero * this.denominador;
        return new Fraccion(numeradorNuevo, this.denominador);
    }

    public Fraccion oponer() {
        int numeradorNuevo = 0 - this.numerador;
        return new Fraccion(numeradorNuevo, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int denominadorNuevo = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion restar(int entero) {
        int numeradorNuevo = this.numerador - entero * this.denominador;
        return new Fraccion(numeradorNuevo, this.denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.numerador;
        int denominadorNuevo = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion multiplicar(int entero) {
        int numeradorNuevo = this.numerador * entero;
        return new Fraccion(numeradorNuevo, this.denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.denominador;
        int denominadorNuevo = this.denominador * fraccion.numerador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion dividir(int entero) {
        int denominadorNuevo = this.denominador * entero;
        return new Fraccion(this.numerador, denominadorNuevo);
    }

    public Fraccion elevar(int exponente) {
        int numeradorNuevo = (int) Math.pow(this.numerador, exponente);
        int denominadorNuevo = (int) Math.pow(this.denominador, exponente);
        return new Fraccion(numeradorNuevo, denominadorNuevo);
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
        if (this.esIgual(fraccion)) {
            return 0;
        } else if (this.esMayor(fraccion)) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        if (numerador == denominador) {
            return "1";
        } else if (numerador == 0) {
            return "0";
        }
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }

}
