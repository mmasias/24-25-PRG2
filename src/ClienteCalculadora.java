package src;

import src.calculadora.Calculadora;

public class ClienteCalculadora {

    public static void main(String[] args) {
       
        System.out.println("OPERACIONES BÁSICAS EXITOSAS");
        Calculadora calculadora = new Calculadora();
        calculadora.ingresarNumero(10);
        calculadora.ingresarNumero(5);
        calculadora.sumar();
        System.out.println("Resultado de 10 + 5:");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("INDUCIR ERROR -> RAÍZ CUADRADA DE NÚMERO NEGATIVO:");
        calculadora.ingresarNumero(-25);
        System.out.println("Intentando calcular raíz cuadrada de -25:");
        calculadora.calcularRaizCuadrada();
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("DEMOSTRAR QUE OPERACIONES NO SE EJECUTAN EN ESTADO DE ERROR:");
        System.out.println("Intentando agregar número 100 con error presente:");
        calculadora.ingresarNumero(100);
        System.out.println("Estado después de intentar ingresar 100:");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("Intentando sumar con error presente:");
        calculadora.sumar();
        System.out.println("Estado después de intentar sumar:");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("RECUPERACIÓN DEL ERROR:");
        System.out.println("Saliendo del estado de error:");
        calculadora.salirError();
        System.out.println("Estado después de salirError():");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("CONTINUAR OPERACIONES DESPUÉS DE RECUPERAR:");
        calculadora.ingresarNumero(16);
        calculadora.calcularRaizCuadrada();
        System.out.println("Raíz cuadrada de 16:");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("ERROR POR FALTA DE OPERANDOS:");
        calculadora.limpiar();
        System.out.println("Después de limpiar:");
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("Intentando multiplicar sin operandos suficientes:");
        calculadora.multiplicar();
        System.out.println(calculadora.mostrarTodo());
        
        System.out.println("ERROR DE MEMORIA LLENA:");
        calculadora.limpiar();
        System.out.println("Llenando memoria (capacidad predeterminada = 10):");
        for (int i = 0; i < 15; i++) {
            calculadora.ingresarNumero(i);
            if ((i+1) % 5 == 0) {
                System.out.println("Después de ingresar " + (i+1) + " números:");
                System.out.println(calculadora.mostrarTodo());
            }
        }
    }
}