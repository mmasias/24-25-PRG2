package src.calculadora;

public class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    private static final int CAPACIDAD_POR_DEFECTO = 10;

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
        this(valoresIniciales.length < CAPACIDAD_POR_DEFECTO ? CAPACIDAD_POR_DEFECTO : valoresIniciales.length);
        for (int i = 0; i < valoresIniciales.length; i++) {
            ingresarNumero(valoresIniciales[i]);
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
            ingresarNumero(operandos[0] / operandos[1]);
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            int operando = (int) extraerOperando();
            if (operando < 0) {
                error = true;
                mensajeError = "No se puede calcular factorial de valores negativos";
            } else {
                ingresarNumero(1);
                for (int i = 1; i <= operando; i++) {
                    ingresarNumero(i);
                    multiplicar();
                }
            }
        }
    }

    public void calcularMaximo() {
        if (verificarOperandos(1)) {
            double maximo = extraerOperando();
            while (posicionActual > 0) {
                double valor = extraerOperando();
                maximo = maximo < valor ? valor : maximo;
            }
            ingresarNumero(maximo);
        }
    }

    public void calcularMinimo() {
        if (verificarOperandos(1)) {
            double minimo = extraerOperando();
            while (posicionActual > 0) {
                double valor = extraerOperando();
                minimo = minimo > valor ? valor : minimo;
            }
            ingresarNumero(minimo);
        }
    }

    public void sumar(double valor) {
        ingresarNumero(valor);
        sumar();
    }

    public void restar(double valor) {
        ingresarNumero(valor);
        restar();
    }

    public void multiplicar(double valor) {
        ingresarNumero(valor);
        multiplicar();
    }

    public void dividir(double valor) {
        ingresarNumero(valor);
        dividir();
    }

    public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double operando = extraerOperando();
            for (int i = 0; i < 2; i++){
                ingresarNumero(operando);
            }
        }
    }

    public void intercambiar(){
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0]);
            ingresarNumero(operandos[1]);
        }
    }

    public void calcularPotencia(){
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(Math.pow(operandos[1],operandos[0]));
        }
    }

    public void calcularPotencia(double exponente){
        if (verificarOperandos(1)) {
            ingresarNumero(exponente);
            calcularPotencia();
        }        
    }

    public void ingresarPI(){
        ingresarNumero(Math.PI);
    }

    public void ingresarE(){
        ingresarNumero(Math.E);
    }


}
