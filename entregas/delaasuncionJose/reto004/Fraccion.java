package entregas.delaasuncionJose.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador!=0 : "Denominador no puede ser CERO!";

        int mcd = mcd(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion(int numerador) {
        this(numerador,1);
    }

    public Fraccion() {
        this(0);
    }

    public int denominador() {
        return denominador;
    }

    public int numerador() {
        return numerador;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private int mcm(int a, int b) {
        return (a*b)/mcd(a,b);
    }

    public Fraccion invertir() {
        return new Fraccion(denominador,numerador);
    }

    public Fraccion oponer(){
        return new Fraccion(-numerador,denominador);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int mcm = mcm(denominador, fraccion.denominador);
        return new Fraccion(numerador*mcm + fraccion.numerador*mcm,mcm*denominador);
    }

    public Fraccion sumar(int numero) {
        return new Fraccion(numerador + numero*denominador,denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return this.sumar(fraccion.oponer());
    }

    public Fraccion restar(int numero) {
        return new Fraccion(numerador - denominador*numero, denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.numerador,denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(int numero) {
        return new Fraccion(numerador * numero, denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int numero) {
        return new Fraccion(numerador,denominador * numero);
    }

    public Fraccion elevar(int valor) {
        if (valor<0) return this.invertir().elevar(-valor);
        return new Fraccion((int) Math.pow(numerador,valor),(int) Math.pow(denominador,valor));
    }

    public boolean esMayor(Fraccion fraccion){
        return fraccion.valueOf() > this.valueOf();
    }

    public boolean esIgual(Fraccion fraccion) {
        return fraccion.valueOf() == this.valueOf();
    }

    public boolean esMenor(Fraccion fraccion){
        return fraccion.valueOf() < this.valueOf();
    }

    public int compareTo(Fraccion fraccion) {
        return esMayor(fraccion) ? 1 : esIgual(fraccion) ? 0 : -1;
    }

    public double valueOf() {
        return (numerador / denominador);
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}