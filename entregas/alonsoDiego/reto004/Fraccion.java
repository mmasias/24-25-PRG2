package entregas.alonsoDiego.reto004;
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            this.numerador = 0;
            this.denominador = 1;
        } else {
            this.numerador = numerador;
            this.denominador = denominador;
        }
    }

    public Fraccion(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion sumarFraccion(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumarEntero(int numeroEntero) {
        return this.sumarFraccion(new Fraccion(numeroEntero));
    }

    public Fraccion restarFraccion(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restarEntero(int numeroEntero) {
        return this.restarFraccion(new Fraccion(numeroEntero));
    }

    public Fraccion multiplicarFraccion(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion multiplicarEntero(int numeroEntero) {
        return new Fraccion(this.numerador * numeroEntero, this.denominador);
    }

    public Fraccion dividirFraccion(Fraccion fraccion) {
        if (fraccion.numerador == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.numerador * fraccion.denominador, this.denominador * fraccion.numerador);
    }

    public Fraccion dividirEntero(int numeroEntero) {
        if (numeroEntero == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.numerador, this.denominador * numeroEntero);
    }

    public Fraccion elevarExponente(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public Fraccion obtenerOpuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion obtenerInversa() {
        if (this.numerador == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public int obtenerNumerador() {
        return numerador;
    }

    public int obtenerDenominador() {
        return denominador;
    }

    public boolean verificarSiEsMenorQue(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean verificarSiEsMayorQue(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean verificarSiEsIgualA(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public int compararConFraccion(Fraccion fraccion) {
        if (this.verificarSiEsIgualA(fraccion)) return 0;
        if (this.verificarSiEsMayorQue(fraccion)) return 1;
        return -1;
    }

    public double obtenerValorDecimal() {
        return (double) this.numerador / this.denominador;
    }

    public String convertirAString() {
        if (denominador == 1) return numerador + "";
        return numerador + "/" + denominador;
    }

    public Fraccion clonarFraccion() {
        return new Fraccion(this.numerador, this.denominador);
    }
}

