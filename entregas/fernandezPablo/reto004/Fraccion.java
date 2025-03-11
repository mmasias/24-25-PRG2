package entregas.fernandezPablo.reto004;


public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){

        assert denominador != 0: "El denominador no puede ser 0";

        if (denominador < 0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
        
    }
    
    public Fraccion(int numerador){
        this(numerador, 1);
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
        if (denominador == 1){
            return "" + numerador;
        } else {
            return numerador + "/" + denominador;
        }
    }

public Fraccion()
public Fraccion sumar(Fraccion fraccion)
public Fraccion sumar(int entero)
public Fraccion oponer()
public Fraccion restar(Fraccion fraccion)
public Fraccion restar(int entero)
public Fraccion multiplicar(Fraccion fraccion)
public Fraccion multiplicar(int entero)
public Fraccion invertir()
public Fraccion dividir(Fraccion fraccion)
public Fraccion dividir(int entero)
public Fraccion elevar(int exponente)
public int numerador()
public int denominador()
public boolean esMenor(Fraccion fraccion)
public boolean esMayor(Fraccion fraccion)
public boolean esIgual(Fraccion fraccion)
public double valueOf()
public int compareTo(Fraccion fraccion)
public Fraccion clone()

}
