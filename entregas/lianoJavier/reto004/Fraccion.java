package entregas.lianoJavier.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public static void main(String[] args) {
        Fraccion fraccionSimplificada = new Fraccion(2, 4);
        System.out.println("fraccionSimplificada: " + fraccionSimplificada.toString());

        Fraccion fraccionNegativa = new Fraccion(2, -4);
        System.out.println("fraccionNegativa: " + fraccionNegativa.toString());

        Fraccion fraccionEntera = new Fraccion(5);
        System.out.println("fraccionEntera: " + fraccionEntera.toString());

        Fraccion fraccionVacia = new Fraccion();
        System.out.println("fraccionVacia: " + fraccionVacia.toString());

        Fraccion resultadoSuma = fraccionSimplificada.sumar(fraccionNegativa);
        System.out.println("fraccionSimplificada + fraccionNegativa: " + resultadoSuma.toString());

        Fraccion resultadoMultiplicacion = fraccionSimplificada.multiplicar(fraccionNegativa);
        System.out.println("fraccionSimplificada * fraccionNegativa: " + resultadoMultiplicacion.toString());

        Fraccion resultadoResta = fraccionSimplificada.restar(fraccionNegativa);
        System.out.println("fraccionSimplificada - fraccionNegativa: " + resultadoResta.toString());

        Fraccion resultadoDivision = fraccionSimplificada.dividir(fraccionNegativa);
        System.out.println("fraccionSimplificada / fraccionNegativa: " + resultadoDivision.toString());

        System.out.println("fraccionSimplificada < fraccionNegativa: " + fraccionSimplificada.esMenor(fraccionNegativa));
        System.out.println("fraccionSimplificada > fraccionNegativa: " + fraccionSimplificada.esMayor(fraccionNegativa));
        System.out.println("fraccionSimplificada == fraccionNegativa: " + fraccionSimplificada.esIgual(fraccionNegativa));

        System.out.println("fraccionSimplificada value: " + fraccionSimplificada.valueOf());

        Fraccion fraccionClonada = fraccionSimplificada.clone();
        System.out.println("fraccionSimplificada clone: " + fraccionClonada.toString());
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser 0";

        alternarPolaridad(numerador, denominador);

        int maximoComunDivisor = calcularMaximoComunDivisor(Math.abs(numerador), Math.abs(denominador));
        this.numerador = numerador / maximoComunDivisor;
        this.denominador = denominador / maximoComunDivisor;
    }

    private void alternarPolaridad(int numerador2, int denominador2) {
        if (denominador < 0) {
            numerador *= -1;
            denominador *= -1;
        }
    }

    private int calcularMaximoComunDivisor(int primerValor, int segundoValor) {
        if (segundoValor == 0) {
            return primerValor;
        }
        return calcularMaximoComunDivisor(segundoValor, primerValor % segundoValor);
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

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoDenominador = this.denominador * fraccion.denominador;
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int nuevoNumerador = numerador * fraccion.numerador;
        int nuevoDenominador = denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero));
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero));
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

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (this.esMenor(fraccion)) {
            return -1;
        } else if (this.esMayor(fraccion)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}
