package entregas.calderonJimena.reto004;

public class Fraccion {

    private int denominador;
    private int numerador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        if(denominador < 0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion (int numerador){
        this(numerador, 1);
    }

    public Fraccion(){
        this(0);
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar (Fraccion fraccion){
        int num = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int den = this.denominador * fraccion.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion sumar (int entero){
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer(){
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar (Fraccion fraccion){
        int num = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int den = this.denominador * fraccion.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion restar (int entero){
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar (Fraccion fraccion){
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicar (int entero){
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir (Fraccion fraccion){
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir (int entero){
        return dividir(new Fraccion(entero));
    }

    public Fraccion elevar (int potencia){
        return new Fraccion((int) Math.pow(this.numerador, potencia), (int) Math.pow(this.denominador, potencia));
    }

    public int denominador() {
        return denominador;
    }

    public int numerador() {
        return numerador;
    }

    public boolean esMenor(Fraccion fraccion){
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }
    
    public boolean esMayor(Fraccion fraccion){
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }
    
    public boolean esIgual(Fraccion fraccion){
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf(){
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion){
        if(this.esMenor(fraccion)){
            return -1;
        } else if(this.esMayor(fraccion)){
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }

    public Fraccion clone(){
        return new Fraccion(this.numerador, this.denominador);
    }
}
