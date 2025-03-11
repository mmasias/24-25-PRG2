package entregas.lianoJavier.reto004;

public class Fraccion {
    private int denominador;
    private int numerador;

    public static void main(String[] args) {
        Fraccion fraccion = new Fraccion(3, 9);
        System.out.println(fraccion);
        Fraccion fraccion2 = new Fraccion(2, -4);
        System.out.println(fraccion2);
        Fraccion fraccion3 = new Fraccion(0, 1);
        System.out.println(fraccion3);
        Fraccion fraccion4 = new Fraccion(1, 0);
        System.out.println(fraccion4);
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        if (denominador < 0) {
            this.numerador *= -1;
            this.denominador *= -1;
        }

        int MinimoComunDivisor = calcularMinimoComunDivisor(Math.abs(numerador), denominador);
        this.numerador /= MinimoComunDivisor;
        this.denominador /= MinimoComunDivisor;

        this.numerador = numerador;
        this.denominador = denominador;
    }

    private int calcularMinimoComunDivisor(int primerValor, int segundoValor) {
        if (segundoValor == 0) {
            return primerValor;
        }
        return calcularMinimoComunDivisor(segundoValor, primerValor % segundoValor);
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        }
        return numerador + "/" + denominador;
    }

    // public Fraccion sumar(Fraccion fraccion) {
    // }

    // public Fraccion sumar(int entero) {
    // }

    // public Fraccion oponer() {
    // }

    // public Fraccion restar(Fraccion fraccion) {
    // }

    // public Fraccion restar(int entero) {
    // }

    // public Fraccion multiplicar(Fraccion fraccion) {
    // }

    // public Fraccion multiplicar(int entero) {
    // }

    // public Fraccion invertir() {
    // }

    // public Fraccion dividir(Fraccion fraccion) {
    // }

    // public Fraccion dividir(int entero) {
    // }

    // public Fraccion elevar(int exponente) {
    // }

    // public int numerador() {
    // }

    // public int denominador() {
    // }

    // public boolean esMenor(Fraccion fraccion) {
    // }

    // public boolean esMayor(Fraccion fraccion) {
    // }

    // public boolean esIgual(Fraccion fraccion) {
    // }

    // public Fraccion sumar(Fraccion fraccion) {

    // }

    // public double valueOf() {

    // }

    // public int compareTo(Fraccion fraccion) {

    // }

    // public Fraccion clone() {

    // }

}
