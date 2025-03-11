package entregas.cuestaAlejandra.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int num, int den) {
        if (den == 0) {
            den = 1;
        }
        numerador = num;
        denominador = den;
    }

    public Fraccion(int num) {
        numerador = num;
        denominador = 1;
    }

    public Fraccion() {
        numerador = 0;
        denominador = 1;
    }

    public Fraccion sumar(Fraccion otra) {
        int nuevoNum = numerador * otra.denominador + otra.numerador * denominador;
        int nuevoDen = denominador * otra.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

     public Fraccion sumar(int entero) {
        return new Fraccion(numerador + entero * denominador, denominador);
    }

    public Fraccion restar(Fraccion otra) {
        int nuevoNum = numerador * otra.denominador - otra.numerador * denominador;
        int nuevoDen = denominador * otra.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion restar(int entero) {
        return new Fraccion(numerador - entero * denominador, denominador);
    }

    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(numerador * otra.numerador, denominador * otra.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(numerador * entero, denominador);
    }

    public Fraccion dividir(Fraccion otra) {
        return new Fraccion(numerador * otra.denominador, denominador * otra.numerador);
    }

    public Fraccion dividir(int entero) {
        return new Fraccion(numerador, denominador * entero);
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(numerador, exponente), (int) Math.pow(denominador, exponente));
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

     public boolean esMenor(Fraccion otra) {
        return numerador * otra.denominador < otra.numerador * denominador;
    }

    public boolean esMayor(Fraccion otra) {
        return numerador * otra.denominador > otra.numerador * denominador;
    }

     public boolean esIgual(Fraccion otra) {
        return numerador * otra.denominador == otra.numerador * denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

     public int compareTo(Fraccion otra) {
        if (esIgual(otra)) return 0;
        return esMayor(otra) ? 1 : -1;
    }

    public String toString() {
        if (denominador==1) {
            return " " + numerador;
        } else {
            return numerador + "\n-\n" + denominador;
        }
        
    }

     public Fraccion clone() {
        return new Fraccion(numerador, denominador);

    }
}