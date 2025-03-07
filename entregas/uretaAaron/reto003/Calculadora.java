package entregas.uretaAaron.reto003

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
        this(Math.max(valoresIniciales.length, CAPACIDAD_POR_DEFECTO));
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
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < posicionActual; i++) {
            resultado.append("[").append(i).append("] ").append(numeros[i]).append("\n");
        }
        for (int i = 0; i < 10; i++) {
            resultado.append("-");
        }
        return error ? mensajeError : resultado.toString();
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

    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] - operandos[0]);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0] * operandos[1]);
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
            double[] operandos = extraerOperandos(1);
            ingresarNumero(-operandos[0]);
        }
    }

    public void calcularMedia() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números para calcular la media";
            return;
        }
        double suma = 0;
        for (int i = 0; i < posicionActual; i++) {
            suma += numeros[i];
        }
        limpiar();
        ingresarNumero(suma / posicionActual);
    }

    public void calcularSumatoria() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números para calcular la sumatoria";
            return;
        }
        double suma = 0;
        for (int i = 0; i < posicionActual; i++) {
            suma += numeros[i];
        }
        limpiar();
        ingresarNumero(suma);
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0] / 100);
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            int n = (int) operandos[0];

            if (n < 0) {
                error = true;
                mensajeError = "No se puede calcular el factorial de un número negativo";
                return;
            }

            double resultado = 1;
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            ingresarNumero(resultado);
        }
    }

    public void calcularMaximo() {
        if (posicionActual > 0) {
            double max = numeros[0];
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] > max) {
                    max = numeros[i];
                }
            }
            limpiar();
            ingresarNumero(max);
        } else {
            error = true;
            mensajeError = "No hay números para calcular el máximo";
        }
    }

    public void calcularMinimo() {
        if (posicionActual > 0) {
            double min = numeros[0];
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] < min) {
                    min = numeros[i];
                }
            }
            limpiar();
            ingresarNumero(min);
        } else {
            error = true;
            mensajeError = "No hay números para calcular el mínimo";
        }
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
        if (valor == 0) {
            error = true;
            mensajeError = "No se puede dividir por cero";
            return;
        }

        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] / valor);
        }
    }

    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] * valor / 100);
        }
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
            if (operandos[0] < 0) {
                error = true;
                mensajeError = "No se puede calcular la raíz cuadrada de un número negativo";
                return;
            }
            ingresarNumero(Math.sqrt(operandos[0]));
        }
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(Math.pow(operandos[1], operandos[0]));
        }
    }

    public void calcularPotencia(double exponente) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(Math.pow(operandos[0], exponente));
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