package entregas.coboIsmael.reto004;
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero";
        this.numerador = numerador;
        this.denominador = (denominador == 0) ? 1 : denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        int num = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int den = this.denominador * fraccion.denominador;
        return new Fraccion(num, den);
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
        return new Fraccion(this.numerador - entero * this.denominador, this.denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        assert this.numerador != 0 : "No se puede invertir una fracción con numerador 0";
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion != null && fraccion.numerador != 0 : "No se puede dividir por una fracción con numerador 0 o nula";
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        assert entero != 0 : "No se puede dividir por cero";
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        int num = 1;
        int den = 1;
        for (int i = 0; i < Math.abs(exponente); i++) {
            num *= this.numerador;
            den *= this.denominador;
        }
        if (exponente < 0) {
            return new Fraccion(den, num);
        }
        return new Fraccion(num, den);
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        if (this.esIgual(fraccion)) return 0;
        return this.esMayor(fraccion) ? 1 : -1;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }
} 