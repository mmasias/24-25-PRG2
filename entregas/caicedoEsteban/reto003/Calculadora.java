package entregas.caicedoEsteban.reto003;

public final class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public Calculadora(double[] valoresIniciales) {
        this();
        for (double valor : valoresIniciales) {
            ingresarNumero(valor);
        }
    }

    public Calculadora(double valorInicial) {
        this();
        ingresarNumero(valorInicial);
    }

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
            ingresarNumero(operandos[1] * operandos[0] / 100);
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            double resultado = 1;
            for (int i = 1; i <= operandos[0]; i++) {
                resultado *= i;
            }
            ingresarNumero(resultado);
        }
    }

    public void calcularMaximo() {
        if (verificarOperandos(1)) {
            double maximo = extraerOperando();
            for (int i = 0; i < posicionActual; i++) {
                double valor = extraerOperando();
                if (valor > maximo) {
                    maximo = valor;
                }
                if (i < posicionActual - 1) {
                    ingresarNumero(valor);
                }
            }
            ingresarNumero(maximo);
        }
    }

    public void calcularMinimo() {
        if (verificarOperandos(1)) {
            double minimo = extraerOperando();
            for (int i = 0; i < posicionActual; i++) {
                double valor = extraerOperando();
                if (valor < minimo) {
                    minimo = valor;
                }
                if (i < posicionActual - 1) {
                    ingresarNumero(valor);
                }
            }
            ingresarNumero(minimo);
        }
    }

    public void suma(double valor) {
        if (verificarOperandos(1)) {
            numeros[posicionActual - 1] += valor;
        }
    }

    public void restar(double valor) {
        if (verificarOperandos(1)) {
            numeros[posicionActual - 1] -= valor;
        }
    }

    public void multiplicar(double valor) {
        if (verificarOperandos(1)) {
            numeros[posicionActual - 1] *= valor;
        }
    }

    public void dividir(double valor) {
        if (verificarOperandos(1)) {
            numeros[posicionActual - 1] /= valor;
        }
    }

    public void calcularPorcentaje(double valor) {
        if (verificarOperandos(1)) {
            numeros[posicionActual - 1] *= valor / 100;
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

    public void calcularPotencia(double exponente) {
        double[] operandos = extraerOperandos(1);
        ingresarNumero(Math.pow(operandos[0], exponente));
    }
}