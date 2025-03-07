package entregas;

import entregas.navasNicolas.reto003.Calculadora;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("==== PRUEBA DE CALCULADORA ====");

        System.out.println("-- Prueba de constructores --");
        Calculadora calculadora1 = new Calculadora();
        System.out.println("Constructor por defecto: " + calculadora1.mostrarTodo());

        Calculadora calculadora2 = new Calculadora(5);
        System.out.println("Constructor con capacidad: " + calculadora2.mostrarTodo());

        System.out.println("-- Operaciones básicas --");
        Calculadora calculadora = new Calculadora();

        calculadora.ingresarNumero(10.5);
        System.out.println("Ingresado 10.5: " + calculadora.mostrar());
        calculadora.ingresarNumero(5.5);
        System.out.println("Ingresado 5.5: " + calculadora.mostrar());
        System.out.println("Todos los valores: " + calculadora.mostrarTodo());

        calculadora.sumar();
        System.out.println("Suma (10.5 + 5.5): " + calculadora.mostrar());

        calculadora.ingresarNumero(20);
        calculadora.ingresarNumero(4);
        calculadora.restar();
        System.out.println("Resta (20 - 4): " + calculadora.mostrar());

        calculadora.ingresarNumero(6);
        calculadora.ingresarNumero(7);
        calculadora.multiplicar();
        System.out.println("Multiplicación (6 * 7): " + calculadora.mostrar());

        calculadora.ingresarNumero(20);
        calculadora.ingresarNumero(5);
        calculadora.dividir();
        System.out.println("División (20 / 5): " + calculadora.mostrar());

        calculadora.ingresarNumero(-15);
        System.out.println("Ingresado -15: " + calculadora.mostrar());
        calculadora.invertir();
        System.out.println("Invertir signo (-15 → 15): " + calculadora.mostrar());

        calculadora.limpiar();
        System.out.println("-- Estadísticas --");
        calculadora.ingresarNumero(10);
        calculadora.ingresarNumero(20);
        calculadora.ingresarNumero(30);
        calculadora.ingresarNumero(40);
        System.out.println("Valores: " + calculadora.mostrarTodo());

        calculadora.calcularMedia();
        System.out.println("Media: " + calculadora.mostrar());

        calculadora.calcularSumatoria();
        System.out.println("Sumatoria: " + calculadora.mostrar());

        System.out.println("==== FIN DE PRUEBAS ====");
    }
}
