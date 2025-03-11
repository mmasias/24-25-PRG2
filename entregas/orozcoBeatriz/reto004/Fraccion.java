package entregas.orozcoBeatriz.reto004;

public class Fraccion {

    private int numerador, denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominadorNuevo = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion sumar(int entero) {
        int numeradorNuevo = this.numerador + entero * this.denominador;
        int denominadorNuevo = this.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }

    public Fraccion oponer() {

    }

    public Fraccion restar(Fraccion fraccion) {
        int numeradorNuevo = this.numerador * fraccion.denominador - fraccion.numerador - this.denominador;
        int denominadorNuevo = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorNuevo, denominadorNuevo);
    }
}
