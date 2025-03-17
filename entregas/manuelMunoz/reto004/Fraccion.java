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
        Fraccion primeraFraccion = amplificacion(new Fraccion(this.numerador, this.denominador), fraccion);
        Fraccion segundaFraccion = amplificacion(fraccion, new Fraccion(this.numerador, this.denominador));
        Fraccion fraccionResultante = new Fraccion((primeraFraccion.numerador + segundaFraccion.numerador), (primeraFraccion.denominador));
        return fraccionResultante;
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

    private Fraccion amplificacion(Fraccion primeraFraccion, Fraccion segundaFraccion){
        int mcm = (primeraFraccion.denominador * segundaFraccion. denominador) / mcd(primeraFraccion.denominador, segundaFraccion.denominador);
        int amplificadorDeFraccion = mcm / primeraFraccion.denominador;
        primeraFraccion.numerador = primeraFraccion.numerador * amplificadorDeFraccion;
        primeraFraccion.denominador = primeraFraccion.denominador * amplificadorDeFraccion;
        return primeraFraccion;
    }
}
