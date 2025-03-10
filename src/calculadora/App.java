package src.calculadora;

public class App {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora(100);

        calculadora.ingresarNumero(5);
        calculadora.ingresarNumero(3);
        calculadora.sumar();       
        System.out.println(calculadora.mostrarTodo());

        calculadora.ingresarNumero(5);
        calculadora.ingresarNumero(3);
        calculadora.restar();       
        System.out.println(calculadora.mostrarTodo());

        calculadora.ingresarNumero(5);
        calculadora.ingresarNumero(3);
        calculadora.multiplicar();       
        System.out.println(calculadora.mostrarTodo());

        calculadora.ingresarNumero(45);
        calculadora.ingresarNumero(5);
        calculadora.dividir();       
        System.out.println(calculadora.mostrarTodo());

        calculadora.calcularSumatoria();
        System.out.println(calculadora.mostrarTodo());

        for(int i=0;i<15;i++){
            calculadora.ingresarNumero(Math.random()*100);
        }
        System.out.println(calculadora.mostrarTodo());

        calculadora.calcularMedia();
        System.out.println(calculadora.mostrarTodo());
    }
}
