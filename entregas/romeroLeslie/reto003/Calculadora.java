public class Calculadora {

    private double[] memoria;
    private int posicion;
    private String error;
    private static final int CAPACIDAD_DEFECTO = 10;

    public Calculadora(int capacidad) {
        memoria = new double[capacidad];
        posicion = 0;
        error = null;
    }

    public Calculadora(double valorInicial) {
        this(CAPACIDAD_DEFECTO);
        agregar(valorInicial);
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length > 0 ? valoresIniciales.length : CAPACIDAD_DEFECTO);
        for (double valor : valoresIniciales) agregar(valor);
    }

    public void agregar(double valor) {
        if (posicion < memoria.length) {
            memoria[posicion++] = valor;
        } else {
            error = "MEMORIA LLENA!!!";
        }
    }

    public String mostrar() {
        return error != null ? error : (posicion > 0 ? String.valueOf(memoria[posicion - 1]) : "-");
    }

    public String mostrarTodo() {
        String resultado = "";
        for (int i = 0; i < posicion; i++) resultado += "[" + i + "] " + memoria[i] + "\n";
        for (int i = 0; i < 10; i++) resultado += "-";
        return error != null ? error : resultado;
    }

    public void limpiar() {
        posicion = 0;
        error = null;
    }

    private boolean verificarOperandos(int cantidad) {
        if (posicion >= cantidad) return true;
        error = "Faltan operandos!";
        return false;
    }

    private double extraer() {
        return memoria[--posicion];
    }

    private double[] obtenerOperandos(int cantidad) {
        double[] operandos = new double[cantidad];
        for (int i = 0; i < cantidad; i++) operandos[i] = extraer();
        return operandos;
    }

    public void sumar() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar(operandos[0] + operandos[1]);
        }
    }

    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar(operandos[1] - operandos[0]);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar(operandos[0] * operandos[1]);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar(operandos[1] / operandos[0]);
        }
    }

    public void invertir() {
        if (verificarOperandos(1)) agregar(-extraer());
    }

    public void calcularRaizCuadrada() {
        if (verificarOperandos(1)) agregar(Math.sqrt(extraer()));
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar(Math.pow(operandos[1], operandos[0]));
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) {
            double n = extraer(), fact = 1;
            for (int i = 1; i <= n; i++) fact *= i;
            agregar(fact);
        }
    }

    public void calcularMaximo() {
        if (posicion > 0) {
            double max = memoria[0];
            for (int i = 1; i < posicion; i++) if (memoria[i] > max) max = memoria[i];
            agregar(max);
        }
    }

    public void calcularMinimo() {
        if (posicion > 0) {
            double min = memoria[0];
            for (int i = 1; i < posicion; i++) if (memoria[i] < min) min = memoria[i];
            agregar(min);
        }
    }

    public void calcularSumatoria() {
        while (posicion > 1) sumar();
    }

    public void calcularMedia() {
        int total = posicion;
        calcularSumatoria();
        agregar(total);
        dividir();
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

public void duplicarNumero() {
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            ingresarNumero(operandos[0]);
            ingresarNumero(operandos[0]);
        }
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {
            double[] operandos = obtenerOperandos(2);
            agregar((operandos[1] / 100) * operandos[0]);
        }
    }

   
    public void intercambiar() {
        if (verificarOperandos(2)) {
            double a = extraer(), b = extraer();
            agregar(a);
            agregar(b);
        }
    }
}
