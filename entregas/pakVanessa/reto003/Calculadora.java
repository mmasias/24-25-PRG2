package entregas.pakVanessa.reto003;

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
        this(CAPACIDAD_POR_DEFECTO);  
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

    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] - operandos[0]);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            if (operandos[0] != 0) {
                ingresarNumero(operandos[1] / operandos[0]);
            } else {
                error = true;
                mensajeError = "ERROR: División por cero";
            }
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
            double porcentaje = (operandos[1] * operandos[0]) / 100;
            ingresarNumero(porcentaje);
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            int num = (int) operandos[0];
            if (num < 0) {
                error = true;
                mensajeError = "ERROR: No se puede calcular el factorial de un número negativo";
                return;
            }
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            ingresarNumero(factorial);
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
            ingresarNumero(max);
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
            ingresarNumero(min);
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
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            if (valor != 0) {
                ingresarNumero(operandos[0] / valor);
            } else {
                error = true;
                mensajeError = "ERROR: División por cero";
            }
        }
    }

    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            double porcentaje = (operandos[0] * valor) / 100;
            ingresarNumero(porcentaje);
        }
    }

    public void intercambiar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0]);
            ingresarNumero(operandos[1]);
        }
    }

    public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0] * 2);
        }
    }

    public void calcularRaizCuadrada() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            if (operandos[0] >= 0) {
                ingresarNumero(Math.sqrt(operandos[0]));
            } else {
                error = true;
                mensajeError = "ERROR: No se puede calcular la raíz cuadrada de un número negativo";
            }
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
