package entregas.Calculadora;

public class Main {
    public static void main(String[] args) {
        Operaciones calculadora = new Operaciones();

        calculadora.agregarNumeros(10);
        calculadora.agregarNumeros(5);

        calculadora.mostrarNumeros();

        System.out.println(calculadora.sumar());
    }
    
}
