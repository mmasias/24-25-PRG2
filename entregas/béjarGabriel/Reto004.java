package entregas.béjarGabriel;

public class Reto004 {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){
        assert denominador!=0: "El denominador no puede ser CERO.. BURRO!!!";

        if (denominador<0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd (Math.abs(numerador); denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion (int numerador){
        this(numerador, 1);
    }

    public Fraccion(){
        this(0);
    }

    private int mcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String toString(){
        if (denominador==1){
            return "" + numerador;
        } else {
            return numerador + "\n-\n" + denominador;
        }
    }
}
