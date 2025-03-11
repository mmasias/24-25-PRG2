package entregas.orejaPaula.reto004;

public class Fraccion implements Comparable<Fraccion>, Cloneable {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("El denominador no puede ser cero.");
        }
        int gcd = gcd(numerador, denominador);
        this.numerador = numerador / gcd;
        this.denominador = denominador / gcd;
        if (this.denominador < 0) {
            this.numerador = -this.numerador;
            this.denominador = -this.denominador;
        }
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.denominador + fraccion.numerador * this.denominador,
                            this.denominador * fraccion.denominador);
    }

    public Fraccion sumar(int entero) {
        return new Fraccion(this.numerador + entero * this.denominador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.denominador - fraccion.numerador * this.denominador,
                            this.denominador * fraccion.denominador);
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
        if (this.numerador == 0) {
            throw new ArithmeticException("No se puede invertir una fracción con numerador 0.");
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        if (entero == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (this.esIgual(fraccion)) return 0;
        return this.esMayor(fraccion) ? 1 : -1;
    }

    public String toString() {
        return this.denominador == 1 ? String.valueOf(this.numerador) : this.numerador + "/" + this.denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
}

