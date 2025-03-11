package entregas.lianoJavier.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public static void main(String[] args) {
        // Test constructors
        Fraccion f1 = new Fraccion(2, 4);
        System.out.println("f1: " + f1.toString()); // Expected: 1/2

        Fraccion f2 = new Fraccion(2, -4);
        System.out.println("f2: " + f2.toString()); // Expected: -1/2

        Fraccion f3 = new Fraccion(5);
        System.out.println("f3: " + f3.toString()); // Expected: 5/1

        Fraccion f4 = new Fraccion();
        System.out.println("f4: " + f4.toString()); // Expected: 0/1

        // Test arithmetic operations
        Fraccion sum = f1.sumar(f2);
        System.out.println("f1 + f2: " + sum.toString()); // Expected: 0

        Fraccion product = f1.multiplicar(f2);
        System.out.println("f1 * f2: " + product.toString()); // Expected: -1/4

        Fraccion difference = f1.restar(f2);
        System.out.println("f1 - f2: " + difference.toString()); // Expected: 1

        Fraccion quotient = f1.dividir(f2);
        System.out.println("f1 / f2: " + quotient.toString()); // Expected: -1/2

        // Test comparisons
        System.out.println("f1 < f2: " + f1.esMenor(f2)); // Expected: false
        System.out.println("f1 > f2: " + f1.esMayor(f2)); // Expected: false
        System.out.println("f1 == f2: " + f1.esIgual(f2)); // Expected: false

        // Test valueOf
        System.out.println("f1 value: " + f1.valueOf()); // Expected: 0.5

        // Test clone
        Fraccion f1Clone = f1.clone();
        System.out.println("f1 clone: " + f1Clone.toString()); // Expected: 1/2
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }

        int maximoComunDivisor = calcularMaximoComunDivisor(Math.abs(numerador), Math.abs(denominador));
        this.numerador = numerador / maximoComunDivisor;
        this.denominador = denominador / maximoComunDivisor;
    }

    private int calcularMaximoComunDivisor(int primerValor, int segundoValor) {
        if (segundoValor == 0) {
            return primerValor;
        }
        return calcularMaximoComunDivisor(segundoValor, primerValor % segundoValor);
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        }
        return numerador + "/" + denominador;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoDenominador = this.denominador * fraccion.denominador;
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
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
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (this.esMenor(fraccion)) {
            return -1;
        } else if (this.esMayor(fraccion)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}
