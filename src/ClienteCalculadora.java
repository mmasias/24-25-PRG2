package src;

import src.calculadora.Calculadora;

public class ClienteCalculadora {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        calculadora.ingresarNumero(16);
        calculadora.calcularRaizCuadrada();
        System.out.println(calculadora.mostrarTodo());
    }
}
