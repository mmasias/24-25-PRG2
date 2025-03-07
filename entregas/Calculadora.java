package entregas.fernandezIbuprofeno.reto003;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private List<Double> valores;

    public Calculadora(int capacidad) {
        this.valores = new ArrayList<>(capacidad);
        System.out.println("Me configuro con el parámetro " + capacidad);
    }

    public Calculadora() {
        this.valores = new ArrayList<>();
        System.out.println("Me configuro sin parámetros");
    }

    public void ingresarNumero(double valor) {
        valores.add(valor);
        System.out.println("Se ha ingresado el valor: " + valor);
    }

    public String mostrar() {
        return "Devuelvo algo";
    }

    public String mostrarTodo() {
        return "Devuelvo muchas cosas";
    }

    public void limpiar() {
        valores.clear();
        System.out.println("La lista ha sido limpiada.");
    }

    public void sumar() {
        System.out.println("Sumaré");
    }

    public void invertir() {
        System.out.println("Invertiré!");
    }

    public void restar() {
        invertir();
        sumar();
    }

    public void dividir() {
        System.out.println("Dividiré!");
    }

    public void multiplicar() {
        System.out.println("Multiplicaré!");
    }

    public void calcularMedia() {
        System.out.println("Calcularé la media!");
    }

    public void calcularSumatoria() {
        System.out.println("Calcularé la sumatoria!");
    }

    public void calcularFactorial() {
        if (valores.isEmpty()) {
            System.out.println("No hay valores para calcular el factorial.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        if (ultimoValor < 0 || ultimoValor != (int) ultimoValor) {
            System.out.println("El factorial solo está definido para números enteros no negativos.");
            return;
        }

        int n = (int) ultimoValor;
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + ultimoValor + " es: " + factorial);
    }

    public void calcularMaximo() {
        if (valores.isEmpty()) {
            System.out.println("No hay valores para calcular el máximo.");
            return;
        }

        double maximo = valores.get(0);
        for (double valor : valores) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        System.out.println("El valor máximo almacenado es: " + maximo);
    }

    public void calcularMinimo() {
        if (valores.isEmpty()) {
            System.out.println("No hay valores para calcular el mínimo.");
            return;
        }

        double minimo = valores.get(0);
        for (double valor : valores) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        System.out.println("El valor mínimo almacenado es: " + minimo);
    }

    public void sumar(double valor) {
        if (valores.isEmpty()) {
            System.out.println("No hay valores en la lista para sumar.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        ultimoValor += valor;
        valores.set(valores.size() - 1, ultimoValor);
        System.out.println("Nuevo valor después de sumar: " + ultimoValor);
    }

    public void restar(double valor) {
        if (valores.isEmpty()) {
            System.out.println("No hay valores en la lista para restar.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        ultimoValor -= valor;
        valores.set(valores.size() - 1, ultimoValor);
        System.out.println("Nuevo valor después de restar: " + ultimoValor);
    }

 
    public void multiplicar(double valor) {
        if (valores.isEmpty()) {
            System.out.println("No hay valores en la lista para multiplicar.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        ultimoValor *= valor;
        valores.set(valores.size() - 1, ultimoValor);
        System.out.println("Nuevo valor después de multiplicar: " + ultimoValor);
    }

    public void dividir(double valor) {
        if (valores.isEmpty()) {
            System.out.println("No hay valores en la lista para dividir.");
            return;
        }

        if (valor == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        ultimoValor /= valor;
        valores.set(valores.size() - 1, ultimoValor);
        System.out.println("Nuevo valor después de dividir: " + ultimoValor);
    }

    public void calcularPorcentaje(double valor) {
        if (valores.isEmpty()) {
            System.out.println("No hay valores en la lista para calcular el porcentaje.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        if (ultimoValor == 0) {
            System.out.println("Error: El último valor es 0. No se puede calcular el porcentaje.");
            return;
        }

        double porcentaje = (valor / ultimoValor) * 100;
        System.out.println("El porcentaje de " + valor + " sobre " + ultimoValor + " es: " + porcentaje + "%");
    }

   
    public void calcularRaizCuadrada() {
        if (valores.isEmpty()) {
            System.out.println("No hay valores para calcular la raíz cuadrada.");
            return;
        }

        double ultimoValor = valores.get(valores.size() - 1);
        if (ultimoValor < 0) {
            System.out.println("No se puede calcular la raíz cuadrada de un número negativo.");
            return;
        }
        double resultado = raizCuadrada(ultimoValor);
        System.out.println("La raíz cuadrada de " + ultimoValor + " es: " + resultado);
    }

    public double raizCuadrada(double num) {
        double epsilon = 0.0001;
        double bajo = 0;
        double alto = num;
        double medio = (bajo + alto) / 2;

        while (Math.abs(medio * medio - num) > epsilon) {
            if (medio * medio > num) {
                alto = medio;
            } else {
                bajo = medio;
            }
            medio = (bajo + alto) / 2;
        }
        return medio;
    }

    
    public void calcularPotencia() {
        if (valores.size() < 2) {
            System.out.println("No hay suficientes valores para calcular la potencia.");
            return;
        }

        double penultimoValor = valores.get(valores.size() - 2);
        double ultimoValor = valores.get(valores.size() - 1);

        double resultado = potencia(penultimoValor, ultimoValor);
        System.out.println(penultimoValor + " elevado a " + ultimoValor + " es: " + resultado);
    }

   
    public double potencia(double base, double exponente) {
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}
