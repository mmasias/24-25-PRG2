package entregas.manuelMunoz.reto003;

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

    public Calculadora(double valorInicial){
        this(CAPACIDAD_POR_DEFECTO);
        numeros[0] = valorInicial;
    }

    public Calculadora(double[] valoresIniciales){
        this(CAPACIDAD_POR_DEFECTO);
        for(int i = 0; i < CAPACIDAD_POR_DEFECTO; i++){
            numeros[i] = valoresIniciales[i];
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

    public void calcularPorcentage(){
        dividir();
    }

    public void calcularFactorial(){
        int resultadoFactorial = 1;
        int factorial = (int)extraerOperando();
        for (int i = factorial; i > 0; i--){
            resultadoFactorial *= factorial;
            factorial--;
        }
        ingresarNumero(resultadoFactorial);
    }

    public void calcularMaximo(){
        double valorMaximo = 0;
        for(int i = 0; i < posicionActual; i++){
            if (valorMaximo < numeros[i]){
                valorMaximo = numeros[i];
            }
        }
        limpiar();
        ingresarNumero(valorMaximo);
    }

    public void calcularMinimo(){
        double valorMinimo = numeros[0];
        for(int i = 1; i < posicionActual; i++){
            if (valorMinimo > numeros[i]){
                valorMinimo = numeros[i];
            }
        }
        limpiar();
        ingresarNumero(valorMinimo);
    }

    public void intercambiar(){
        double numeroParaCambiar = numeros[posicionActual];
        numeros[posicionActual] = numeros[posicionActual - 1];
        numeros[posicionActual - 1] = numeroParaCambiar;
    }

    public void calcularPotencia(){
        double potencia = Math.pow(numeros[posicionActual], numeros[posicionActual - 1]);
        ingresarNumero(potencia);
    }

    public void calcularPotencia(double exponente){
        double potencia = Math.pow(numeros[posicionActual], exponente);
        ingresarNumero(potencia);
    }

    public void calcularRaizCuadrada(){
        double radical = Math.sqrt(numeros[posicionActual]);
        ingresarNumero(radical);
    }
    
    public void sumar(double valor){
        ingresarNumero(numeros[posicionActual] + valor);
    }

    public void restar(double valor){
        ingresarNumero(numeros[posicionActual] - valor);
    }

    public void multiplicar(double valor){
        ingresarNumero(numeros[posicionActual] * valor);
    }

    public void dividir(double valor){
        ingresarNumero(numeros[posicionActual] / valor);
    }

    public void calcularPorcentage(double valor){
        dividir(valor);
    }

    public void duplicarNumero(){
        if (posicionActual == (numeros.length - 1)){
            error = true;
            mensajeError = "La memoria esta llena";
        }else{
            numeros[posicionActual + 1] = numeros[posicionActual];
        }
    }
}
