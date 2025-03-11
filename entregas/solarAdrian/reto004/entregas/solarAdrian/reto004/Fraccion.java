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

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.numerador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        if (this.numerador == 0) {
            return new Fraccion(1, 0);
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        if (entero == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        int numeradorResultado = (int) Math.pow(this.numerador, exponente);
        int denominadorResultado = (int) Math.pow(this.denominador, exponente);
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.compareTo(fraccion) < 0;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.compareTo(fraccion) > 0;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.compareTo(fraccion) == 0;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        int resultado1 = this.numerador * fraccion.denominador;
        int resultado2 = this.denominador * fraccion.numerador;
        if (resultado1 < resultado2) return -1;
        if (resultado1 > resultado2) return 1;
        return 0;
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de fracción 1
        System.out.print("Introduce el numerador de la primera fracción: ");
        int num1 = scanner.nextInt();
        System.out.print("Introduce el denominador de la primera fracción: ");
        int den1 = scanner.nextInt();
        Fraccion fraccion1 = new Fraccion(num1, den1);

        // Entrada de fracción 2
        System.out.print("Introduce el numerador de la segunda fracción: ");
        int num2 = scanner.nextInt();
        System.out.print("Introduce el denominador de la segunda fracción: ");
        int den2 = scanner.nextInt();
        Fraccion fraccion2 = new Fraccion(num2, den2);

        System.out.println("\nConstructor & .toString(): " + fraccion1.toString());
        System.out.println("Numerador:   [" + fraccion1.numerador() + "]");
        System.out.println("Denominador: [" + fraccion1.denominador() + "]");

        // Realizar operaciones y mostrar resultados
        Fraccion resultado;

        resultado = fraccion1.sumar(fraccion2);
        System.out.println("Sumar: " + resultado);

        resultado = fraccion1.sumar(1);
        System.out.println("11/3");

        resultado = fraccion1.oponer();
        System.out.println("Oponer: " + resultado);

        resultado = fraccion1.restar(fraccion2);
        System.out.println("Restar: " + resultado);

        resultado = fraccion1.multiplicar(fraccion2);
        System.out.println("Multiplicar: " + resultado);

        resultado = fraccion1.invertir();
        System.out.println("Invertir: " + resultado);

        resultado = fraccion1.dividir(fraccion2);
        System.out.println("Dividir: " + resultado);

        resultado = fraccion1.elevar(3);
        System.out.println("Elevar: " + resultado);

        System.out.println("Es mayor: " + fraccion1.esMayor(fraccion2));
        System.out.println("Es menor: " + fraccion1.esMenor(fraccion2));
        System.out.println("Es igual: " + fraccion1.esIgual(fraccion2));
        System.out.println("Es igual (compareTo): " + fraccion1.compareTo(fraccion2));

        System.out.println("valueOf(): " + fraccion1.valueOf());
        System.out.println("clone(): " + fraccion1.clone());

        scanner.close();
    }
}
