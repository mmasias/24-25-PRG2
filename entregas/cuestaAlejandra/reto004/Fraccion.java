package entregas.cuestaAlejandra.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int num, int den) {
        if (den == 0) {
            den = 1;
        }
        numerador = num;
        denominador = den;
    }

    public Fraccion(int num) {
        numerador = num;
        denominador = 1;
    }

    public Fraccion() {
        numerador = 0;
        denominador = 1;
    }

    
}