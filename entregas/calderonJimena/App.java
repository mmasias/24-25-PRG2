package entregas.calderonJimena;

public 
class App {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.ingresarNumero(1);
        calculadora.ingresarNumero(1);
        calculadora.ingresarNumero(1);
        calculadora.sumar();
        System.out.println(calculadora.mostrar());
        calculadora.restar();
        System.out.println(calculadora.mostrar());
        
        
        
        
    }
}
