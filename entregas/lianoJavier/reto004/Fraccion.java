package entregas.lianoJavier.reto004;

public class Fraccion {
    private int denominador;
    private int numerador;

    public static void main(String[] args) {
        Fraccion fraccion = new Fraccion(3, 9);
        System.out.println(fraccion);
        Fraccion fraccion2 = new Fraccion(2, -4);
        System.out.println(fraccion2);
        Fraccion fraccion3 = new Fraccion(0, 1);
        System.out.println(fraccion3);
        Fraccion fraccion4 = new Fraccion(1, 0);
        System.out.println(fraccion4);
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        if (denominador < 0) {
            this.numerador *= -1;
            this.denominador *= -1;
        }

        int MinimoComunDivisor = calcularMinimoComunDivisor(Math.abs(numerador), denominador);
        this.numerador /= MinimoComunDivisor;
        this.denominador /= MinimoComunDivisor;

        this.numerador = numerador;
        this.denominador = denominador;
    }

    private int calcularMinimoComunDivisor(int primerValor, int segundoValor) {
        if (segundoValor == 0) {
            return primerValor;
        }
        return calcularMinimoComunDivisor(segundoValor, primerValor % segundoValor);
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
