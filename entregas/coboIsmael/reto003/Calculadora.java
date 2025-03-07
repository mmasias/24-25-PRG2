package entregas.coboIsmael.reto003;

public class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public Calculadora(int capacidad) {
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public Calculadora() {
        this(CAPACIDAD_POR_DEFECTO);
    }
    
    public Calculadora(double valorInicial) {
        this();
        ingresarNumero(valorInicial);
    }
    
    public Calculadora(double[] valoresIniciales) {
        int capacidad = Math.max(CAPACIDAD_POR_DEFECTO, valoresIniciales.length);
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
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
        for (int i = 0; i < posicionActual; i++) {
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
    
    public void sumar(double valor) {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            ingresarNumero(numero + valor);
        }
    }
    
    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] - operandos[0]);
        }
    }
    
    public void restar(double valor) {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            ingresarNumero(numero - valor);
        }
    }
    
    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }
    
    public void multiplicar(double valor) {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            ingresarNumero(numero * valor);
        }
    }
    
    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] / operandos[0]);
        }
    }
    
    public void dividir(double valor) {
        if (verificarOperandos(1)) {
            if (valor == 0) {
                error = true;
                mensajeError = "División por cero!";
                return;
            }
            double numero = extraerOperando();
            ingresarNumero(numero / valor);
        }
    }
    
    public void invertir() {
        if (verificarOperandos(1)) {
            double[] operadores = extraerOperandos(1);
            ingresarNumero(-operadores[0]);
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
            double resultado = (operandos[1] * operandos[0]) / 100;
            ingresarNumero(resultado);
        }
    }
    
    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            double valor = operandos[0];
            if (valor < 0 || valor != Math.floor(valor)) {
                error = true;
                mensajeError = "Valor no válido para factorial";
                return;
            }
            int n = (int) valor;
            double resultado = 1;
            for (int i = 1; i <= n; i++) {
                resultado *= i;
            }
            ingresarNumero(resultado);
        }
    }
    
    public void calcularMaximo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay operandos!";
            return;
        }
        double max = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        posicionActual = 0;
        ingresarNumero(max);
    }
    
    public void calcularMinimo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay operandos!";
            return;
        }
        double min = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
        }
        posicionActual = 0;
        ingresarNumero(min);
    }
    
    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            ingresarNumero((numero * valor) / 100);
        }
    }
    
    public void intercambiar() {
        if (verificarOperandos(2)) {
            int lastIndex = posicionActual - 1;
            int penultimateIndex = posicionActual - 2;
            double temp = numeros[penultimateIndex];
            numeros[penultimateIndex] = numeros[lastIndex];
            numeros[lastIndex] = temp;
        }
    }
    
    public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double numero = numeros[posicionActual - 1];
            ingresarNumero(numero);
        }
    }
    
    public void calcularRaizCuadrada() {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            if (numero < 0) {
                error = true;
                mensajeError = "Número negativo para raíz cuadrada";
                return;
            }
            ingresarNumero(Math.sqrt(numero));
        }
    }
    
    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            double resultado = Math.pow(operandos[1], operandos[0]);
            ingresarNumero(resultado);
        }
    }
    
    public void calcularPotencia(double exponente) {
        if (verificarOperandos(1)) {
            double numero = extraerOperando();
            ingresarNumero(Math.pow(numero, exponente));
        }
    }
    
    private double[] extraerOperandos(int numeroOperandos) {
        double[] operandos = new double[numeroOperandos];
        for (int i = 0; i < numeroOperandos; i++) {
            operandos[i] = extraerOperando();
        }
        return operandos;
    }
    
    private double extraerOperando(){
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
}
