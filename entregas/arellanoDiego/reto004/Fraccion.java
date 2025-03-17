package entregas.arellanoDiego.reto004;


public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1; 
        }
        if (denominador < 0) { 
            numerador = -numerador;
            denominador = -denominador;
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

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
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
        return this.sumar(-entero);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        if (this.numerador == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.denominador, this.numerador);
    }   

    public Fraccion dividir(Fraccion fraccion) {
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        if (entero == 0) {
            return new Fraccion(this.numerador, this.denominador); // Evitar división por cero
        }
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion(potencia(this.numerador, exponente), potencia(this.denominador, exponente));
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
    
    private void simplificar() {
        int gcd = mcd(Math.abs(numerador), Math.abs(denominador));
        this.numerador /= gcd;
        this.denominador /= gcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int potencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}
