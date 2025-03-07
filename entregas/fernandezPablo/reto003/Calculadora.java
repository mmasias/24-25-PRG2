package entregas.fernandezPablo.reto003;

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
        if (posicionActual > 0) {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor + valor;
            numeros[posicionActual - 1] = resultado;
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para sumar.";
        }
    }

    public void restar(double valor) {
        if (posicionActual > 0) {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor - valor;
            numeros[posicionActual - 1] = resultado;
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para restar.";
        }
    }

    public void multiplicar(double valor) {
        if (posicionActual > 0) {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor * valor;
            numeros[posicionActual - 1] = resultado;
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para multiplicar.";
        }
    }

    public void dividir(double valor) {
        if (posicionActual > 0) {
            if (valor == 0) {
                error = true;
                mensajeError = "No se puede dividir entre cero.";
                return;
            }
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor / valor;
            numeros[posicionActual - 1] = resultado;
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para dividir.";
        }
    }

    public void intercambiar() {
        if (posicionActual < 2) {
            error = true;
            mensajeError = "No hay suficientes valores para intercambiar.";
            return;
        }

        double temp = numeros[posicionActual - 1];
        numeros[posicionActual - 1] = numeros[posicionActual - 2];
        numeros[posicionActual - 2] = temp;
    }

    public void duplicarNumero() {
        if (posicionActual > 0) {
            double ultimoValor = numeros[posicionActual - 1];
            ingresarNumero(ultimoValor);
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para duplicar.";
        }
    }

    public void calcularRaizCuadrada() {
        if (posicionActual > 0) {
            double ultimoValor = numeros[posicionActual - 1];
            if (ultimoValor < 0) {
                error = true;
                mensajeError = "No se puede calcular la raíz cuadrada de un número negativo.";
                return;
            }
            double resultado = Math.sqrt(ultimoValor);
            numeros[posicionActual - 1] = resultado;
        } else {
            error = true;
            mensajeError = "No hay valores almacenados para calcular la raíz cuadrada.";
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double operando = extraerOperando();
            if (operando < 0 || operando != Math.floor(operando)) {
                error = true;
                mensajeError = "El factorial no está definido para números negativos o no enteros.";
                return;
            }
            int n = (int) operando;
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            ingresarNumero(factorial);
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

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }

    public void calcularMedia() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay valores almacenados para calcular la media.";
            return;
        }
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        ingresarNumero(numeroDeOperandos);
    }

    public void calcularSumatoria() {
        int numeroDeOperandos = posicionActual;
        for (int i = 0; i < numeroDeOperandos - 1; i++) {
            sumar();
        }
    }

    public void calcularMaximo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay valores almacenados.";
            return;
        }

        double maximo = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        ingresarNumero(maximo);
    }

    public void calcularMinimo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay valores almacenados.";
            return;
        }

        double minimo = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
        }
        ingresarNumero(minimo);
    }
}