package entregas;

import entregas.lianoJavier.reto003.Calculadora;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("==== PRUEBA DE CALCULADORA ====");

        probarConstructores();

        Calculadora calculadora = new Calculadora();

        probarOperacionesBasicas(calculadora);

        calculadora.limpiar();
        probarOperacionesEstadisticas(calculadora);

        System.out.println("==== FIN DE PRUEBAS ====");
    }

    private static void probarOperacionesEstadisticas(Calculadora calculadora) {
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

        calculadora.ingresarNumero(80);
        calculadora.ingresarNumero(20);
        calculadora.calcularPorcentaje();
        System.out.println("Porcentaje: " + calculadora.mostrar());

        calculadora.ingresarNumero(5);
        calculadora.calcularFactorial();
        System.out.println("Factorial: " + calculadora.mostrar());

        calculadora.calcularMinimo();
        System.out.println("Mínimo: " + calculadora.mostrar());
    }

    private static void probarOperacionesBasicas(Calculadora calculadora) {
        System.out.println("-- Operaciones básicas --");

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

        calculadora.ingresarNumero(10);
        calculadora.sumar(5);
        System.out.println("Suma con 5: " + calculadora.mostrar());

        calculadora.ingresarNumero(20);
        calculadora.restar(5);
        System.out.println("Resta con 5: " + calculadora.mostrar());

        calculadora.ingresarNumero(3);
        calculadora.multiplicar(2);
        System.out.println("Multiplicación con 2: " + calculadora.mostrar());

        calculadora.ingresarNumero(10);
        calculadora.dividir(2);
        System.out.println("División con 2: " + calculadora.mostrar());

        calculadora.ingresarNumero(50);
        calculadora.calcularPorcentaje(10);
        System.out.println("10% de 50: " + calculadora.mostrar());

        calculadora.ingresarNumero(5);
        calculadora.ingresarNumero(10);
        calculadora.intercambiar();
        System.out.println("Intercambio: " + calculadora.mostrarTodo());

        calculadora.ingresarNumero(7);
        calculadora.duplicarNumero();
        System.out.println("Duplicar: " + calculadora.mostrarTodo());

        calculadora.ingresarNumero(16);
        calculadora.calcularRaizCuadrada();
        System.out.println("Raíz cuadrada: " + calculadora.mostrar());

        calculadora.ingresarNumero(2);
        calculadora.ingresarNumero(3);
        calculadora.calcularPotencia();
        System.out.println("Potencia: " + calculadora.mostrar());

        calculadora.ingresarNumero(4);
        calculadora.calcularPotencia(2);
        System.out.println("Potencia con exponente 2: " + calculadora.mostrar());
    }

    private static void probarConstructores() {
        System.out.println("-- Prueba de constructores --");
        Calculadora calculadora1 = new Calculadora();
        System.out.println("Constructor por defecto: " + calculadora1.mostrarTodo());

        Calculadora calculadora2 = new Calculadora(5);
        System.out.println("Constructor con capacidad: " + calculadora2.mostrarTodo());

        Calculadora calculadora3 = new Calculadora(5.0);
        System.out.println("Constructor con valor inicial: " + calculadora3.mostrarTodo());

        double[] valoresIniciales = {1.0, 2.0, 3.0, 4.0, 5.0};
        Calculadora calculadora4 = new Calculadora(valoresIniciales);
        System.out.println("Constructor con valores iniciales: " + calculadora4.mostrarTodo());
    }
}
