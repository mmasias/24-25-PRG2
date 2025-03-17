package entregas.rivasMiguel.reto004;

public class Fraccion {
public static void main(String[] args) {
    Fraccion f1 = new Fraccion(1, 3);
    Fraccion f2 = new Fraccion(1, 3);
    double resultado = f1.valueOf();
    System.out.println(resultado);
}


    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador), denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    public String toString() {
        if (denominador == 1) {
            return numerador + "";
        } else {
            return numerador + "/" + denominador;
        }
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        int nuevoNumerador = this.numerador + entero * this.denominador;
        return new Fraccion(nuevoNumerador, this.denominador);
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restar(int entero) {
        int nuevoNumerador = this.numerador - entero * this.denominador;
        return new Fraccion(nuevoNumerador, this.denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        int nuevoNumerador = this.numerador * entero;
        return new Fraccion(nuevoNumerador, this.denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(int entero) {
        int nuevoDenominador = this.denominador * entero;
        return new Fraccion(this.numerador, nuevoDenominador);
    }

    public Fraccion elevar(int exponente) {
        int nuevoNumerador = (int) Math.pow(this.numerador, exponente);
        int nuevoDenominador = (int) Math.pow(this.denominador, exponente);
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.valueOf() < fraccion.valueOf();
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.valueOf() > fraccion.valueOf();
    }

    public boolean esIgual(Fraccion fraccion) {
        return (this.numerador == fraccion.numerador) && (this.denominador == fraccion.denominador);
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }
    
}
