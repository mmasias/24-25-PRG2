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

    public int denominador(){
        return denominador;
    }

    public int numerador(){
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

    public void invertir(){
        int a = numerador;
        numerador = denominador;
        denominador = a;
    }

    public void sumar(Fraccion fraccion) {
        int mcm = mcm(denominador, fraccion.denominador);
        numerador = numerador*mcm + fraccion.numerador*mcm;
        denominador = mcm;
    }

    public void sumar(int numero) {
        numerador += denominador * numero;
    }

    public void restar(Fraccion fraccion) {
        int mcm = mcm(denominador, fraccion.denominador);
        numerador = numerador*mcm - fraccion.numerador*mcm;
        denominador = mcm;
    }

    public void restar(int numero) {
        numerador -= denominador * numero;
    }

    public void multiplicar	(Fraccion fraccion) {
        numerador *= fraccion.numerador;
        denominador *= fraccion.denominador;
    }

    public void multiplicar	(int numero) {
        numerador *= numero;
    }

    public void dividir	(Fraccion fraccion) {
        fraccion.invertir();
        multiplicar(fraccion);
    }

    public void dividir	(int numero) {
        denominador *= numero;
    }

    public Fraccion clone() {
        Fraccion fraccion(numerador, denominador);
        return fraccion;
    }
}