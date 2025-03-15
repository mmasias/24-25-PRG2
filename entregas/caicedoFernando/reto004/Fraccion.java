package entregas.caicedoFernando.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        this.numerador = numerador;
        this.denominador = denominador;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    public Fraccion(int numerador) {
        this(numerador, 1 );
    }
    
    public Fraccion() {
        this(0);
    }

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null;

        int nuevoDenominador = this.denominador * fraccion.denominador;
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return this.sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion){
        assert fraccion != null;
        return this.sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero){
        return this.restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion){
        assert fraccion != null;
        return new Fraccion(
            this.numerador * fraccion.numerador, 
            this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int entero){
        return this.multiplicar(new Fraccion(entero));
    }

    public Fraccion dividir(Fraccion fraccion){
        assert fraccion != null;
        return new Fraccion(
            this.numerador * fraccion.denominador, 
            this.denominador * fraccion.numerador);
    }
}
