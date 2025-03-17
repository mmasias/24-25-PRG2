package entregas.fernandezPablo.reto004;


public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){

        assert denominador != 0: "El denominador no puede ser 0";

        if (denominador < 0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
        
    }
    
    public Fraccion(int numerador){
        this(numerador, 1);
    }

    private int mcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer(){
        return new Fraccion(-this.numerador, this.denominador);
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

    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion){
        assert fraccion != null;

        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(int entero){
        return this.dividir(new Fraccion(entero));
    }

    public Fraccion elevar(int exponente) {
        if (exponente == 0) {
            return new Fraccion(1, 1);
        }
        if (exponente < 0) {
            return invertir().elevar(-exponente);
        }
        int nuevoNumerador = (int) Math.pow(numerador, exponente);
        int nuevoDenominador = (int) Math.pow(denominador, exponente);
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return compareTo(fraccion) < 0;
    }

    public boolean esMayor(Fraccion fraccion) {
        return compareTo(fraccion) > 0;
    }

    public boolean esIgual(Fraccion fraccion) {
        return compareTo(fraccion) == 0;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        long a = (long) this.numerador * fraccion.denominador;
        long b = (long) fraccion.numerador * this.denominador;
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString(){
        if (denominador == 1){
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }


    public Fraccion clone(){
        return new Fraccion(this.numerador, this.denominador);
    }
}