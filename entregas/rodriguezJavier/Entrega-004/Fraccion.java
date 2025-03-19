public class Fraccion {

    private int num, den;

    public Fraccion(int num, int den) {
        assert den != 0 : "Denominador no puede ser 0";
        if (den < 0) {
            num = -num;
            den = -den;
        }
        int mcd = calcularMCD(Math.abs(num), den);
        this.num = num / mcd;
        this.den = den / mcd;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar(Fraccion otra) {
        int nuevoNum = this.num * otra.den + otra.num * this.den;
        int nuevoDen = this.den * otra.den;
        return new Fraccion(nuevoNum, nuevoDen);
    }
}
