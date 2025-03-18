package entregas.navasNicolas.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero";
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
        int maximoComunDivisor = calcularMCD(Math.abs(numerador), denominador);
        this.numerador = numerador / maximoComunDivisor;
        this.denominador = denominador / maximoComunDivisor;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numerador = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion sumar(int entero) {
        return this.sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return this.restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int numerador = this.numerador * fraccion.numerador;
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion multiplicar(int entero) {
        return this.multiplicar(new Fraccion(entero));
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0 : "No se puede dividir por 0";
        int numerador = this.numerador * fraccion.denominador;
        int denominador = this.denominador * fraccion.numerador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion dividir(int entero) {
        return this.dividir(new Fraccion(entero));
    }

    public Fraccion invertir() {
        assert this.numerador != 0 : "No se puede invertir una fracción con numerador 0";
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion elevar(int exponente) {
        if (exponente >= 0) {
            int num = (int) Math.pow(this.numerador, exponente);
            int den = (int) Math.pow(this.denominador, exponente);
            return new Fraccion(num, den);
        } else {
            int num = (int) Math.pow(this.denominador, -exponente);
            int den = (int) Math.pow(this.numerador, -exponente);
            assert den != 0 : "Resultado no definido (división por cero)";
            return new Fraccion(num, den);
        }
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        int lhs = this.numerador * fraccion.denominador;
        int rhs = fraccion.numerador * this.denominador;
        return Integer.compare(lhs, rhs);
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    public String toString() {
        if (this.denominador == 1) {
            return String.valueOf(this.numerador);
        }
        return this.numerador + "/" + this.denominador;
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }
}
