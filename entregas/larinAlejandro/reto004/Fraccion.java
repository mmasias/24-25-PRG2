public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    public Fraccion(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }
    public Fraccion(){
        this.numerador = 0;
        this.denominador = 1;
    }
    public Fraccion sumar(int entero){
        return new Fraccion(this.numerador + entero * this.denominador, this.denominador);
    }
    public Fraccion sumar(Fraccion fraccion){
        return new Fraccion(this.numerador * fraccion.denominador + fraccion.numerador * this.denominador, this.denominador * fraccion.denominador);
    }
    public Fraccion oponer(){
        return new Fraccion(-this.numerador, this.denominador);
    }
    public Fraccion restar(int entero){
        return new Fraccion(this.numerador - entero * this.denominador, this.denominador);
    }
    public Fraccion restar(Fraccion fraccion){
        return new Fraccion(this.numerador * fraccion.denominador - fraccion.numerador * this.denominador, this.denominador * fraccion.denominador);
    }
    public Fraccion multiplicar(int entero){
        return new Fraccion(this.numerador * entero, this.denominador);
    }
    public Fraccion multiplicar(Fraccion fraccion){
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }
    public Fraccion invertir(){
        return new Fraccion(this.denominador, this.numerador);
    }
    public Fraccion dividir(int entero){
        return new Fraccion(this.numerador, this.denominador * entero);
    }
    public Fraccion dividir(Fraccion fraccion){
        return new Fraccion(this.numerador * fraccion.denominador, this.denominador * fraccion.numerador);
    }
    public Fraccion elevar(int exponente){
        return new Fraccion((int)Math.pow(this.numerador, exponente), (int)Math.pow(this.denominador, exponente));
    }
    public int numerador(){
        return this.numerador;
    }
    public int denominador(){
        return this.denominador;
    }
    public boolean esMenor(Fraccion fraccion){
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }
    public boolean esMayor(Fraccion fraccion){
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }
    public boolean esIgual(Fraccion fraccion){
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }
    public double valueOf(){
        return (double)this.numerador / this.denominador;
    }
    public int compareTo(Fraccion fraccion){
        if(this.esMenor(fraccion)){
            return -1;
        }else if(this.esMayor(fraccion)){
            return 1;
        }else{
            return 0;
        }
    }
    public Fraccion clone(){
        return new Fraccion(this.numerador, this.denominador);
    }
    public String toString(){
        return this.numerador + "/" + this.denominador;
    }

}
