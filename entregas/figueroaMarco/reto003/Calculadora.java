package entregas.figueroaMarco.reto003;

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

    public Calculadora(double valorInicial) {
        this(CAPACIDAD_POR_DEFECTO);
        ingresarNumero(valorInicial);
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length > 0 ? valoresIniciales.length : CAPACIDAD_POR_DEFECTO);
        for (double valor : valoresIniciales) {
            ingresarNumero(valor);
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

    public void sumar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0] + operandos[1]);
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
        int cantidadOperandos = posicionActual;
        if (verificarOperandos(cantidadOperandos)) {
            double[] operandos = extraerOperandos(cantidadOperandos);
            ingresarNumero(operandos[1] * operandos[0] / 100);
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            double resultado = 1;
            for (int i = 1; i <= operandos[0]; i++) {
                resultado = resultado * i;
            }
            ingresarNumero(resultado);
        }
    }

    public void calcularMaximo() {
        int cantidadOperandos = posicionActual;
            double[] operandos = extraerOperandos(cantidadOperandos);
            double maximo = 0;
            for(int i=0;i<cantidadOperandos;i++){
                if(operandos[i]>maximo){
                    maximo = operandos[i];
                }
            }
            ingresarNumero(maximo);
        }

    public void calcularMinimo() {
        int cantidadOperandos = posicionActual;
            double[] operandos = extraerOperandos(cantidadOperandos);
            double minimo = operandos[0];
            for(int i=0;i<cantidadOperandos;i++){
                if(operandos[i]<minimo){
                    minimo = operandos[i];
                }
            }
            ingresarNumero(minimo);
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

    public void calcularPorcentaje(double valor) {
        ingresarNumero(valor);
        calcularPorcentaje();
    }

    public void intercambiar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1]);
            ingresarNumero(operandos[0]);
        }
    }

    public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0]);
            ingresarNumero(operandos[0]);
        }
    }

    public void calcularRaizCuadrada() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(Math.sqrt(operandos[0]));
        }
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(Math.pow(operandos[1], operandos[0]));
        }
    }

    public void calcularPotencia(double valor) {
        ingresarNumero(valor);
        calcularPotencia();
    }
    

}