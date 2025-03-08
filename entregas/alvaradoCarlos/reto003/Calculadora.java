package entregas.alvaradoCarlos.reto003;

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
        this(valoresIniciales.length);
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
        dividir();
    }

    public void calcularFactorial() {
        int numeroOperandos = posicionActual;
        if (verificarOperandos(numeroOperandos)) {
            double[] operandos = extraerOperandos(numeroOperandos);
            double resultado = 1;
            for (int i = 1; i <= operandos[0]; i++) {
                resultado *= i;
            }
            ingresarNumero(resultado);
        }
    }

    public void calcularMaximo() {
        int numeroDeOperandos = posicionActual;
        double[] operandos = extraerOperandos(numeroDeOperandos);
        double maximo = operandos[0];
        for (int i = 1; i < numeroDeOperandos; i++) {
            if (operandos[i] > maximo) {
                maximo = operandos[i];
            }
        }
        limpiar();
        ingresarNumero(maximo);
    }

    public void calcularMinimo() {
        int numeroDeOperandos = posicionActual;
        double[] operandos = extraerOperandos(numeroDeOperandos);
        double minimo = operandos[0];
        for (int i = 1; i < numeroDeOperandos; i++) {
            if (operandos[i] < minimo) {
                minimo = operandos[i];
            }
        }
        limpiar();
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
            double swap = operandos[0];
            ingresarNumero(swap);
            swap = operandos[1];
            ingresarNumero(swap);
        }
    }

    public void duplicarNumero() {
        double ultimoValor = extraerOperando();
        ingresarNumero(ultimoValor);
        ingresarNumero(ultimoValor);
    }

    public void calcularRaizCuadrada() {
        double ultimoValor = extraerOperando();
        ingresarNumero(Math.sqrt(ultimoValor));
    }

    public void calcularFactorial(double valor) {
        ingresarNumero(valor);
        calcularFactorial();
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double penultimoValor = extraerOperando();
            double ultimoValor = extraerOperando();
            ingresarNumero(Math.pow(ultimoValor, penultimoValor));
        }
    }

    public void calcularPotencia(double valor) {
        ingresarNumero(valor);
        calcularPotencia();
    }
}