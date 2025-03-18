package entregas.cotareloDaniel.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "Imposible dividir entre 0";

        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    private void simplificar() {
        int a = Math.abs(numerador);
        int b = Math.abs(denominador);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        numerador /= a;
        denominador /= a;
    }

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null;

        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;

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
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir() {
        assert numerador != 0 : "No es posible que el numerador sea 0";
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0 : "No se puede dividir por una fracción con numerador 0";

        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;

        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero));
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
        if (this.valueOf() < fraccion.valueOf()) {
            return -1;
        } else if (this.valueOf() > fraccion.valueOf()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (this.denominador == 1) {
            return String.valueOf(this.numerador);
        }
        return this.numerador + "/" + this.denominador;
    }

    @Override
    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }
}
