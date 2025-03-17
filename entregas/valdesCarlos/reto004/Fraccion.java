package entregas.valdesCarlos.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.println("Error: Denominador no puede ser cero.");
            denominador = 1;
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
        int nuevoNum = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDen = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion restar(Fraccion fraccion) {
        int nuevoNum = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int nuevoDen = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.denominador, this.denominador * fraccion.numerador);
    }

    public Fraccion dividir(int entero) {
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public Fraccion invertir() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.compareTo(fraccion) < 0;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.compareTo(fraccion) > 0;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.compareTo(fraccion) == 0;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    
    public int compareTo(Fraccion fraccion) {
        return Integer.compare(this.numerador * fraccion.denominador, fraccion.numerador * this.denominador);
    }

    
    public String toString() {
        return numerador + "/" + denominador;
    }

   
    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    private void simplificar() {
        int mcd = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int mcd(int a, int b) {
        return b == 0 ? a : mcd(b, a % b);
    }
}
