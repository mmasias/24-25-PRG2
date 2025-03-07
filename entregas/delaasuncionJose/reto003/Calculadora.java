package entregas.delaasuncionJose.reto003;

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

    public Calculadora(double numero) {
        this();
        ingresarNumero(numero);
    }

    public Calculadora(double[] numerosIngresados) {
        this((numerosIngresados.length>CAPACIDAD_POR_DEFECTO) ? numerosIngresados.length:CAPACIDAD_POR_DEFECTO);
        for (double numero : numerosIngresados){
            ingresarNumero(numero);
        }
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

    public void intercambiar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1]);
            ingresarNumero(operandos[0]);
        }
    }

    public void duplicar() {
        if (verificarOperandos(1)) {
            double operando = extraerOperando();
            ingresarNumero(operando);
            ingresarNumero(operando);
        }
    }

    public void invertir() {
        if (verificarOperandos(1)) {
            double[] operadores = extraerOperandos(1);
            ingresarNumero(-operadores[0]);
        }
    }

    public void sumarValor(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(extraerOperando() + valor);
        }
    }

    public void sumar() {
        if (verificarOperandos(2)) {
            sumarValor(extraerOperando());
        }
    }

    public void restarValor(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(extraerOperando() - valor);
        }
    }

    public void restar() {
        if (verificarOperandos(2)) {
            restarValor(extraerOperando());
        }
    }

    public void dividirValor(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(extraerOperando() / valor);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            dividirValor(extraerOperando());
        }
    }

    public void multiplicarValor(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(extraerOperando() * valor);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
           multiplicarValor(extraerOperando());
        }
    }

    public void calcularPotenciaValor(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(Math.pow(extraerOperando(),valor));
        }
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)){
            calcularPotenciaValor(extraerOperando());
        }
    }

    public void calcularRaizCuadrada() {
        calcularPotenciaValor(0.5);
    }

    public void calcularMedia() {
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        dividirValor(numeroDeOperandos);
    }

    public void calcularSumatoria() {
        int numeroDeOperandos = posicionActual;
        for (int i = 0; i < numeroDeOperandos - 1; i++) {
            sumar();
        }
    }

    public void calcularValorAbsoluto() {
        calcularPotenciaValor(2);
        calcularRaizCuadrada();
    }

    public void calcularPorcentajeValor(double valor) {
        if (verificarOperandos(1)) {
            multiplicarValor(valor);
            dividirValor(100);
        }
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {
            calcularPorcentajeValor(extraerOperando());
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            calcularValorAbsoluto();
            int factorial = (int) extraerOperando();
            ingresarNumero(1);
            for (int i = 1;i<=factorial;i++){
                multiplicarValor(i);
            }
        }
    }

    public void calcularMinimo() {
        calcularMinMax(true);
    }

    public void calcularMaximo() {
        calcularMinMax(false);
    }

    private void calcularMinMax(boolean minimo){
        double[] operandos = extraerOperandos(posicionActual);
        double valor = operandos[0];
        for(int i = 1; i < operandos.length; i++){
            if ((minimo && valor > operandos[i]) || (!minimo && valor < operandos[i])){
                valor = operandos[i];
            }
        }
        ingresarNumero(valor);
    }
}