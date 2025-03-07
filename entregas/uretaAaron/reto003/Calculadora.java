package entregas.uretaAaron.reto003;

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
        for (int i = 0; i < posicionActual; i++) {
            resultado += "[" + i + "] " + numeros[i] + "\n";
        }
        resultado += "-".repeat(10);
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
            ingresarNumero(extraerOperando() + valor);
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
            ingresarNumero(extraerOperando() - valor);
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
            ingresarNumero(extraerOperando() * valor);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            if (operandos[0] == 0) {
                error = true;
                mensajeError = "Error: División por cero!";
            } else {
                ingresarNumero(operandos[1] / operandos[0]);
            }
        }
    }

    public void invertir() {
        if (verificarOperandos(1)) {
            ingresarNumero(-extraerOperando());
        }
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * (operandos[0] / 100));
        }
    }

    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            ingresarNumero(extraerOperando() * (valor / 100));
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            int valor = (int) extraerOperando();
            if (valor < 0) {
                error = true;
                mensajeError = "Error: Factorial de número negativo!";
            } else {
                int resultado = 1;
                for (int i = 2; i <= valor; i++) {
                    resultado *= i;
                }
                ingresarNumero(resultado);
            }
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
}
