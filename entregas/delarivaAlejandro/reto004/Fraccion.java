package entregas.delarivAlejandro.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return new Fraccion(this.numerador + entero * this.denominador, this.denominador);
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion otra) {
        return this.sumar(otra.oponer());
    }

    public Fraccion restar(int entero) {
        return new Fraccion(this.numerador - entero * this.denominador, this.denominador);
    }

    public Fraccion multiplicar(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        return new Fraccion(this.numerador * otra.numerador, this.denominador * otra.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        if (this.numerador == 0) {
            throw new IllegalArgumentException("No se puede invertir una fracción con numerador 0");
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion otra) {
        if (otra == null || otra.numerador == 0) {
            throw new IllegalArgumentException("No se puede dividir por una fracción con numerador 0 o nula");
        }
        return this.multiplicar(otra.invertir());
    }

    public Fraccion dividir(int entero) {
        if (entero == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        int nuevoNumerador = (int) Math.pow(this.numerador, Math.abs(exponente));
        int nuevoDenominador = (int) Math.pow(this.denominador, Math.abs(exponente));
        if (exponente < 0) {
            return new Fraccion(nuevoDenominador, nuevoNumerador);
        }
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        return this.numerador * otra.denominador < otra.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        return this.numerador * otra.denominador > otra.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        return this.numerador * otra.denominador == otra.numerador * this.denominador;
    }

    public double valor() {
        return (double) this.numerador / this.denominador;
    }

    public int compararCon(Fraccion otra) {
        if (otra == null) {
            throw new IllegalArgumentException("La fracción no puede ser nula");
        }
        if (this.esIgual(otra)) return 0;
        return this.esMayor(otra) ? 1 : -1;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public Fraccion clonar() {
        return new Fraccion(this.numerador, this.denominador);
    }
}
