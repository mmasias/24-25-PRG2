package entregas.arceMarina.reto004.reto004;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0: "El denominador no puede ser 0";

        if (denominador < 0) {
            numerador = -numerador;
            denominador  = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador/ mcd;
        this.denominador = denominador/mcd;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
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

    public String toString() {
        if (denominador != 1) {
            return numerador + "\n-\n" + denominador;
        } else {
            return numerador + "";
        }
    }

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null;
    
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    
    public Fraccion sumar(int entero) {
        return this.sumar(new Fraccion(entero));
    }

    public Fraccion restar(Fraccion fraccion) {
        assert fraccion != null;
    
        int nuevoNumerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    
    public Fraccion restar(int entero) {
        return this.restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        assert fraccion != null;
    
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    
    public Fraccion multiplicar(int entero) {
        return this.multiplicar(new Fraccion(entero));
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion != null;
    
        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }
    
    public Fraccion dividir(int entero) {
        return this.dividir(new Fraccion(entero));
    }
}


