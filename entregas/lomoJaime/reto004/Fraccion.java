package entregas.lomoJaime.reto004;

public class Fraccion {
        private int numerador;
        private int denominador;

    public Fraccion(int numerador, int denominador){
        assert denominador != 0:"El denominador no puede ser 0";

        if (denominador < 0) {
            numerador = -numerador;
            denominador  = -denominador;
        }
        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador/ mcd;
        this.denominador = denominador/mcd;
    }


    public Fraccion(int numerador){
        this(numerador,1);
    }

    public Fraccion(){
        this(0);
    }
    private int mcd (int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return  a;
    }
    public String toString(){
        if(denominador ==1){
            return "" + numerador; 
        }else{
            return numerador + "/" + denominador;
        }
    }
    public Fraccion sumar(Fraccion fraccion){
        assert fraccion != null;
       return new Fraccion(
        this.numerador*fraccion.denominador + fraccion.numerador*this.denominador,
        this.denominador * fraccion.numerador);
    }
    public Fraccion sumar(int entero){
       return this.sumar(new Fraccion(entero));
    }
    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        assert fraccion != null;
        return this.sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return this.restar(new Fraccion(entero));
    }

   



}