package entregas.alvaradoCarlos.reto004;

public class Fraccion {

    private int NUMERADOR = 0;
    private int DENOMINADOR = 0;

    public Fraccion(int numerador, int denominador) {

        assert denominador != 0: "Denominador igual a 0";

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        this.NUMERADOR = numerador;
        this.DENOMINADOR = denominador;

        int mcd = mcd(Math.abs(numerador), denominador);
        this.NUMERADOR = numerador / mcd;
        this.DENOMINADOR = denominador / mcd;
    }

    private int mcd(int a, int b) {
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
        this(0);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numerador = this.NUMERADOR * fraccion.DENOMINADOR + fraccion.NUMERADOR * DENOMINADOR;
        int denominador = this.DENOMINADOR * fraccion.DENOMINADOR;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-NUMERADOR, DENOMINADOR);
    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.NUMERADOR * fraccion.NUMERADOR, this.DENOMINADOR * fraccion.DENOMINADOR);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir() {
        return new Fraccion(DENOMINADOR, NUMERADOR);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero));
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(NUMERADOR, exponente), (int) Math.pow(DENOMINADOR, exponente));
    }

    public int numerador() {
        return NUMERADOR;
    }

    public int denominador() {
        return DENOMINADOR;
    }

    public boolean esMayor(Fraccion fraccion) {
        return numerador() * fraccion.denominador() > fraccion.numerador() * denominador();
    }

    public boolean esMenor(Fraccion fraccion) {
        return numerador() * fraccion.denominador() < fraccion.numerador() * denominador();
    }

    public boolean esIgual(Fraccion fraccion) {
        return numerador() * fraccion.denominador() == fraccion.numerador() * denominador();
    }

    public double valueOf() {
        return (double) numerador() / denominador();
    }

    public int compareTo(Fraccion fraccion) {
        if (esIgual(fraccion)) return 0;
        return esMayor(fraccion) ? 1 : -1;
    }

    public Fraccion clone() {
        return new Fraccion(NUMERADOR, DENOMINADOR);
    }

    public String toString() {
        if (DENOMINADOR == 1) {
            return "" + NUMERADOR;
        } else {
            return NUMERADOR + "/" + DENOMINADOR;
        }
    }
}
