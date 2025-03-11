package entregas.alvaradoCarlos.reto004;

public class Fraccion {

    private int NUMERADOR = 0;
    private int DENOMINADOR = 0;

    public static void main(String args[]){
        Fraccion fraccion = new Fraccion(1, 2);
        System.out.println(fraccion.toString());
    }

    public Fraccion(int numerador, int denominador) {

        assert denominador != 0: "Denominador igual a 0";

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        this.NUMERADOR = numerador;
        this.DENOMINADOR = denominador;

        int mcd = mcd(Math.abs(numerador), denominador);
        this.NUMERADOR = numerador / mcd;
        this.DENOMINADOR = denominador / mcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    public String toString() {
        if (DENOMINADOR == 1) {
            return "" + NUMERADOR;
        } else {
            return NUMERADOR + "/" + DENOMINADOR;
        }
    }
}
