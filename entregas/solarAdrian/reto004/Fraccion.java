package entregas.solarAdrian.reto004;

import java.util.Scanner;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return this.sumar(fraccion.oponer());
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(this.numerador * fraccion.numerador, this.denominador * fraccion.denominador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return this.multiplicar(fraccion.invertir());
    }

    public Fraccion invertir() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(this.numerador, exponente), (int) Math.pow(this.denominador, exponente));
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el numerador de la primera fracción: ");
        int num1 = scanner.nextInt();
        System.out.print("Introduce el denominador de la primera fracción: ");
        int den1 = scanner.nextInt();
        Fraccion fraccion1 = new Fraccion(num1, den1);
        
        System.out.print("Introduce el numerador de la segunda fracción: ");
        int num2 = scanner.nextInt();
        System.out.print("Introduce el denominador de la segunda fracción: ");
        int den2 = scanner.nextInt();
        Fraccion fraccion2 = new Fraccion(num2, den2);

        System.out.println("Constructor & .toString(): " + fraccion1);
        System.out.println("Numerador:   [" + fraccion1.numerador + "]");
        System.out.println("Denominador: [" + fraccion1.denominador + "]");

        System.out.println("Sumar: " + fraccion1.sumar(fraccion2));
        System.out.println("Oponer: " + fraccion1.oponer());
        System.out.println("Restar: " + fraccion1.restar(fraccion2));
        System.out.println("Multiplicar: " + fraccion1.multiplicar(fraccion2));
        System.out.println("Invertir: " + fraccion1.invertir());
        System.out.println("Dividir: " + fraccion1.dividir(fraccion2));
        System.out.println("Elevar: " + fraccion1.elevar(3));
        System.out.println("Es mayor: " + fraccion1.esMayor(fraccion2));
        System.out.println("Es menor: " + fraccion1.esMenor(fraccion2));
        System.out.println("Es igual: " + fraccion1.esIgual(fraccion2));
        System.out.println("Es igual: " + (fraccion1.esIgual(fraccion2) ? 0 : 1));
        System.out.println("valueOf(): " + fraccion1.valueOf());
        System.out.println("clone(): " + new Fraccion(fraccion1.numerador, fraccion1.denominador));

        scanner.close();
    }
}
