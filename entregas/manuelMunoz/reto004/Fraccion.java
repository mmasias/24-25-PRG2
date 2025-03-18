package entregas.manuelMunoz.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){
        assert denominador != 0 : "COMO VAS A DIVIDIR POR CERO??? QUIERES ROMPER LAS MATES";
        if (denominador < 0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador), denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion(int numerador){
        this(numerador,1);
    }

    public Fraccion(){
        this(0);
    }

    public Fraccion sumar(Fraccion fraccion){
        fraccion = amplificacion(fraccion);
        return new Fraccion((this.numerador + fraccion.numerador), fraccion.denominador);
    }

    public Fraccion sumar(int valor){
        Fraccion fraccion = new Fraccion(valor);
        return this.sumar(fraccion);
    }

    public Fraccion restar(Fraccion fraccion){
        fraccion = amplificacion(fraccion);
        return new Fraccion((this.numerador - fraccion.numerador), fraccion.denominador);
    }

    public Fraccion restar(int valor){
        Fraccion fraccion = new Fraccion(valor);
        return this.restar(fraccion);
    }

    public Fraccion multiplicar(Fraccion fraccion){
        return new Fraccion((this.numerador * fraccion.numerador), (this.denominador * fraccion.denominador));
    }

    public Fraccion multiplicar(int valor){
        Fraccion fraccion = new Fraccion(valor);
        return this.multiplicar(fraccion);
    }

    public Fraccion dividir(Fraccion fraccion){
        return new Fraccion((this.numerador * fraccion.denominador),(this.denominador * fraccion.numerador));
    }

    public Fraccion dividir(int valor){
        Fraccion fraccion = new Fraccion(valor);
        return this.dividir(fraccion);
    }

    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion elevar(int exponente){
        return new Fraccion((int)Math.pow(this.numerador, exponente),(int)Math.pow(this.denominador, exponente));
    }

    public int numerador(){
        return this.numerador;
    }

    public int denominador(){
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion){
        return (this.numerador/this.denominador)<(fraccion.numerador/fraccion.denominador) ? true : false;
    }

    public boolean esMayor(Fraccion fraccion){
        return (this.numerador/this.denominador)>(fraccion.numerador/fraccion.denominador) ? true : false;
    }

    public boolean esIgual(Fraccion fraccion){
        return (this.numerador/this.denominador)==(fraccion.numerador/fraccion.denominador) ? true : false;
    }

    public double valueOf(){
        return (this.numerador/this.denominador);
    }

    public int compareTo(Fraccion fraccion){
        if (esIgual(fraccion)){
            return 0;
        }else if(esMayor(fraccion)){
            return 1;
        }else{
            return -1;
        }
    }

    public Fraccion clone(){
        return new Fraccion(this.numerador, this.denominador);
    }
    
    public String toString(){
        if (denominador == 1){
            return numerador + "";
        }else{
            return numerador + "/" + denominador;
        }
    }

    private int mcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private Fraccion amplificacion(Fraccion fraccion){
        int mcm = (fraccion.denominador * this.denominador) / mcd(fraccion.denominador, this.denominador);
        int amplificadorDePrimeraFraccion = mcm / fraccion.denominador;
        int amplificadorDeSegundaFraccion = mcm / this.denominador;
        fraccion.numerador *= amplificadorDePrimeraFraccion;
        fraccion.denominador *= amplificadorDePrimeraFraccion;
        this.numerador *= amplificadorDeSegundaFraccion;
        this.denominador *= amplificadorDeSegundaFraccion;
        return fraccion;
    }
}
