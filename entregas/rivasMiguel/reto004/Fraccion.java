package entregas.rivasMiguel.reto004;

public class Fraccion {
    public static void main(String[] args) {
        Fraccion fraccion = new Fraccion(4, 7);
        System.out.println(fraccion);
    }

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador), denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0);
    }

    public String toString() {
        if (denominador == 1) {
            return numerador + "";
        } else {
            return numerador + "/" + denominador;
        }
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
