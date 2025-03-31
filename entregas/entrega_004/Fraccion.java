package entregas.entrega_004;

public class Fraccion {
    private int numerador;
    private int denominador;
 
    public Fraccion(int numerador, int denominador) {
      this.numerador = numerador;
      this.denominador = denominador;
 
      assert denominador != 0 : "El denominador no puede ser 0";
 
      if (denominador < 0) {
        numerador = -numerador;
        denominador = -denominador;
      }
 
      int mcd = mcd(Math.abs(numerador), denominador);
      this.numerador = numerador / mcd;
      this.denominador = denominador / mcd;
    }
 
    private int mcd(int a, int b) {
      while (b != 0) {
        int t = b;
        b = a % b;
        a = t;
      }
      return a;
    }
 
    public Fraccion(int numerador) {
      this(numerador, 1);
    }
 
    public Fraccion() {
      this(0);
    }
 
    public String toDString() {
      if (denominador == 1) {
        return "" + numerador;
      } else {
        return numerador + "/" + denominador;
      }
    }
 
    public Fraccion sumar(Fraccion fraccion) {
      if (this.denominador == fraccion.denominador) {
        int numerador = this.numerador + fraccion.numerador;
        return new Fraccion(numerador, fraccion.denominador);
      } else {
        int numerador = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
      }
    }
 
    public Fraccion sumar(int numero) {
      return sumar(new Fraccion(numero));
    }
 
    public Fraccion oponer() {
      return new Fraccion(-numerador, denominador);
    }
 
    public Fraccion restar(Fraccion fraccion) {
      if (this.numerador == fraccion.denominador) {
        int numerador = this.numerador - fraccion.numerador;
        return new Fraccion(numerador, fraccion.denominador);
      } else {
        int numerador = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
      }
    }
 
    public Fraccion restar(int numero) {
      return restar(new Fraccion(numero));
    }
 
    public Fraccion multiplicar(Fraccion fraccion) {
      int numerador = this.numerador * fraccion.numerador;
      int denominador = this.denominador * fraccion.denominador;
      return new Fraccion(numerador, denominador);
    }
 
    public Fraccion multiplicar(int numero) {
      return multiplicar(new Fraccion(numero));
    }
 
    public Fraccion invertir() {
      return new Fraccion(denominador, numerador);
    }
 
    public Fraccion dividir(Fraccion fraccion) {
      int numerador = this.numerador * fraccion.denominador;
      int denominador = this.denominador * fraccion.numerador;
      return new Fraccion(numerador, denominador);
    }
 
    public Fraccion dividir(int numero) {
      return dividir(new Fraccion(numero));
    }
 
    public Fraccion elevar(int exponente) {
      int numerador = (int) Math.pow(this.numerador, exponente);
      int denominador = (int) Math.pow(this.denominador, exponente);
      return new Fraccion(numerador, denominador);
    }
 
    public Fraccion numerador() {
      return new Fraccion(numerador);
    }
 
    public Fraccion denominador() {
      return new Fraccion(denominador);
    }
 
    public boolean esMenor(Fraccion fraccion) {
      return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }
 
    public boolean esIgual(Fraccion fraccion) {
      return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }
 
    public boolean esMayor(Fraccion fraccion) {
      return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }
 
    public double valueOf() {
      return (double) numerador / denominador;
    }
 
    public int compareTo(Fraccion fraccion) {
      assert fraccion != null;
      if (this.esMenor(fraccion)) {
        return -1;
      } else if (this.esMayor(fraccion)) {
        return 1;
      } else {
        return 0;
      }
    }
 
    public String toString() {
      return numerador + "/" + denominador;
    }
 
    public Fraccion clone() {
      return new Fraccion(numerador, denominador);
    }
 
  }
