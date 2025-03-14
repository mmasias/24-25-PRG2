package entregas.morenoSara.reto004;

public class Fraccion {
    
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){
        assert denominador !=0: "El denominador no puede ser CERO...BURRO!!!";

        if(denominador<0){
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador),denominador);
        this.numerador = numerador / mcd;
        this.denominador = numerador / mcd;

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
        if( denominador==1){
            return "" + numerador;
        }else{
            return numerador + "\n-\n " + denominador;
        }
        
    }
    
    public Fraccion sumar(Fraccion otra) {
        int nuevoNum = numerador * otra.denominador + otra.numerador * denominador;
        int nuevoDen = denominador * otra.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

     public Fraccion sumar(int entero) {
        return new Fraccion(numerador + entero * denominador, denominador);
    }

    public Fraccion restar(Fraccion otra) {
        int nuevoNum = numerador * otra.denominador - otra.numerador * denominador;
        int nuevoDen = denominador * otra.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion restar(int entero) {
        return new Fraccion(numerador - entero * denominador, denominador);
    }

    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(numerador * otra.numerador, denominador * otra.denominador);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(numerador * entero, denominador);
    }

    public Fraccion dividir(Fraccion otra) {
        return new Fraccion(numerador * otra.denominador, denominador * otra.numerador);
    }

    public Fraccion dividir(int entero) {
        return new Fraccion(numerador, denominador * entero);
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion invertir() {
        return new Fraccion(denominador, numerador);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(numerador, exponente), (int) Math.pow(denominador, exponente));
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

     public boolean esMenor(Fraccion otra) {
        return numerador * otra.denominador < otra.numerador * denominador;
    }

    public boolean esMayor(Fraccion otra) {
        return numerador * otra.denominador > otra.numerador * denominador;
    }

     public boolean esIgual(Fraccion otra) {
        return numerador * otra.denominador == otra.numerador * denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

     public int compareTo(Fraccion otra) {
        if (esIgual(otra)) return 0;
        return esMayor(otra) ? 1 : -1;
    }
    
     public Fraccion clone() {
        return new Fraccion(numerador, denominador);

    }
}


