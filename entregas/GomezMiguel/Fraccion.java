package entregas.GomezMiguel;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) throw new IllegalArgumentException("El denominador no puede ser 0");
        this.numerador = numerador;
        this.denominador = denominador < 0 ? -denominador : denominador;
        this.numerador = denominador < 0 ? -numerador : numerador;
        simplificar();
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    private void simplificar() {
        int mcd = mcd(Math.abs(numerador), denominador);
        numerador /= mcd;
        denominador /= mcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return denominador == 1 ? String.valueOf(numerador) : numerador + "\n-\n" + denominador;
    }

    public Fraccion sumar(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.denominador + fraccion.numerador * denominador,
                            denominador * fraccion.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.denominador - fraccion.numerador * denominador,
                            denominador * fraccion.denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(numerador * fraccion.numerador, denominador * fraccion.denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        if (fraccion.numerador == 0) throw new IllegalArgumentException("División por cero");
        return new Fraccion(numerador * fraccion.denominador, denominador * fraccion.numerador);
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return numerador * fraccion.denominador < fraccion.numerador * denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return numerador * fraccion.denominador > fraccion.numerador * denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return numerador * fraccion.denominador == fraccion.numerador * denominador;
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }
}