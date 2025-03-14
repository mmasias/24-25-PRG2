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
        int mcm = mcm(this.denominador, fraccion.denominador);

        this.numerador = this.numerador * (mcm/fraccion.denominador);
        this.denominador = this.denominador * (mcm/fraccion.denominador);
        fraccion.numerador = fraccion.numerador * (mcm/this.denominador);
        fraccion.denominador = fraccion.denominador * (mcm/this.denominador);

        System.out.println(this.numerador);
        System.out.println(this.denominador);
        System.out.println(fraccion.numerador);
        System.out.println(fraccion.numerador);

        Fraccion fraccionResultante = new Fraccion((this.numerador + fraccion.numerador), (this.denominador + fraccion.denominador));
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

    private int mcm(int a, int b){
        int resultado = (a * b) / mcd(a,b);
        return  resultado;
    }
}
