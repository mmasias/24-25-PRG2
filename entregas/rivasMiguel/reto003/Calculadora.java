package entregas.rivasMiguel.reto003;

public class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.ingresarNumero(5);
        calculadora.ingresarNumero(3);
        calculadora.ingresarNumero(7);
        System.out.println("Último número ingresado: " + calculadora.mostrar());
        System.out.println("Todos los números ingresados:");
        System.out.println(calculadora.mostrarTodo());
        // calculadora.sumar();
        // System.out.println("Resultado de la suma: " + calculadora.mostrar());
        // calculadora.restar();
        // System.out.println("Resultado de la resta: " + calculadora.mostrar());
        // calculadora.multiplicar();
        // System.out.println("Resultado de la multiplicación: " + calculadora.mostrar());
        // calculadora.dividir();
        // System.out.println("Resultado de la división: " + calculadora.mostrar());
        // calculadora.invertir();
        // System.out.println("Número invertido: " + calculadora.mostrar());
        // calculadora.calcularMedia();
        // System.out.println("Resultado de la media: " + calculadora.mostrar());
        // calculadora.limpiar();
        // System.out.println("Calculadora limpiada. Estado actual: " + calculadora.mostrar());
        // calculadora.calcularPorcentaje();
        // System.out.println("Porcentaje: " + calculadora.mostrar() + "%");
        // calculadora.calcularFactorial();
        // System.out.println("Factorial: " + calculadora.mostrar());
        // calculadora.calcularMaximo();
        // System.out.println("Maximo: " + calculadora.mostrar());
        // calculadora.calcularMinimo();
        // System.out.println("Minimo: " + calculadora.mostrar());
        // calculadora.sumar(7);
        // System.out.println("Suma: " + calculadora.mostrar());
        // calculadora.restar(1);
        // System.out.println("Resta: " + calculadora.mostrar());
        // calculadora.multiplicar(7);
        // System.out.println("Multiplicacion: " + calculadora.mostrar());
        // calculadora.dividir(14);
        // System.out.println("Division: " + calculadora.mostrar());
        // calculadora.calcularPorcentaje(14);
        // System.out.println("Porcentaje: " + calculadora.mostrar());
        // calculadora.intercambiar();
        // System.out.println("Intercambiados: " + calculadora.mostrarTodo());
        // calculadora.duplicarNumero();
        // System.out.println("Duplicado: " + calculadora.mostrarTodo());
        // calculadora.calcularRaizCuadrada();
        // System.out.println("Raiz cuadrada: " + calculadora.mostrar());
        calculadora.calcularPotencia();
        System.out.println("Potencia: " + calculadora.mostrar());
    }

    public Calculadora(int capacidad) {
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public Calculadora() {
        this(CAPACIDAD_POR_DEFECTO);
    }

    public Calculadora(double valor) {
        this();
        ingresarNumero(valor);
    }

    public Calculadora(double[] valoresIniciales) {
        this();
        for (double valor : valoresIniciales) {
            ingresarNumero(valor);
        }
    }

    public void ingresarNumero(double valor) {
        if (posicionActual < numeros.length) {
            numeros[posicionActual] = valor;
            posicionActual++;
        } else {
            error = true;
            mensajeError = "MEMORIA LLENA!!!";
        }
    }

    public String mostrar() {
        if (error) {
            return mensajeError;
        } else if (posicionActual > 0) {
            return "" + numeros[posicionActual - 1];
        } else {
            return "-";
        }
    }

    public String mostrarTodo() {
        String resultado = "";
        for (int i = 0; i < posicionActual; i = i + 1) {
            resultado = resultado + "[" + i + "] " + numeros[i] + "\n";
        }
        resultado = resultado + "-".repeat(10);
        return error ? mensajeError : resultado;
    }

    public void limpiar() {
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public void sumar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0] + operandos[1]);
        }
    }

    private double[] extraerOperandos(int numeroOperandos) {
        double[] operandos = new double[numeroOperandos];
        for (int i = 0; i < numeroOperandos; i++) {
            operandos[i] = extraerOperando();
        }
        return operandos;
    }

    private double extraerOperando() {
        posicionActual--;
        return numeros[posicionActual];
    }

    private boolean verificarOperandos(int numeroOperandos) {
        if (posicionActual >= numeroOperandos) {
            return true;
        } else {
            error = true;
            mensajeError = "Faltan operandos!";
            return false;
        }
    }

    public void invertir() {
        if (verificarOperandos(1)) {
            double[] operadores = extraerOperandos(1);
            ingresarNumero(-operadores[0]);
        }
    }

    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] - operandos[0]);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] / operandos[0]);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }

    public void calcularMedia() {
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        ingresarNumero(numeroDeOperandos);
        dividir();
    }

    public void calcularSumatoria() {
        int numeroDeOperandos = posicionActual;
        for (int i = 0; i < numeroDeOperandos - 1; i++) {
            sumar();
        }
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero((operandos[1] / operandos[0]) * 100);
        }
    }

    private boolean esNegativo(double numero) {
        return numero < 0;
    }

    private boolean esEntero(double numero) {
        return numero == (int) numero;
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double operando = extraerOperando();

            if (esNegativo(operando) || !esEntero(operando)) {
                error = true;
                mensajeError = "¡No se puede calcular el factorial de un número negativo o decimal!";
            } else {
                int resultado = 1;
                for (int i = 2; i <= operando; i++) {
                    resultado *= i;
                }
                ingresarNumero(resultado);
            }
        }
    }

    public void calcularMaximo() {
        int numeroDeOperandos = posicionActual;
        double maximo = numeros[0];

        for (int i = 1; i < numeroDeOperandos; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        ingresarNumero(maximo);
    }

    public void calcularMinimo() {
        int numeroDeOperandos = posicionActual;
        double minimo = numeros[0];
        for (int i = 1; i < numeroDeOperandos; i++) {
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
        }
        ingresarNumero(minimo);
    }

    public void sumar(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] + valor);
        }
    }

    public void restar(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] - valor);
        }
    }

    public void multiplicar(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] * valor);
        }
    }

 	public void dividir(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] / valor);
        }
    }

    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero((valor / operandos[0]) * 100);
        }
    }

    public void intercambiar() {
        if (verificarOperandos(2)) {
            double temp = numeros[posicionActual - 1];
            numeros[posicionActual - 1] = numeros[posicionActual - 2];
            numeros[posicionActual - 2] = temp;
        }
    }

    public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double operando = extraerOperando();
            ingresarNumero(operando);
            ingresarNumero(operando);
        }
    }

    public void calcularRaizCuadrada() {
        double operando = extraerOperando();
        if (esNegativo(operando)) {
            error = true;
            mensajeError = "¡No se puede calcular la raíz cuadrada de un número negativo!";
        } else {
            ingresarNumero(Math.sqrt(operando));
        }
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(Math.pow(operandos[1], operandos[0]));
        }
    }
}