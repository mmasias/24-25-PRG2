public class Calculadora {

    private double[] memoria;
    private int indiceActual;
    private static final int CAPACIDAD_PREDETERMINADA = 10;

    public Calculadora(int capacidad) {
        memoria = new double[capacidad];
        indiceActual = 0;
    }

    public Calculadora() {
        this(CAPACIDAD_PREDETERMINADA);
    }

    public Calculadora(double valorInicial) {
        this();
        agregarNumero(valorInicial);
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length);
        for (double valor : valoresIniciales) {
            agregarNumero(valor);
        }
    }

    public void agregarNumero(double valor) {
        if (indiceActual < memoria.length) {
            memoria[indiceActual++] = valor;
        } else {
        }
    }

    public void limpiarMemoria() {
        indiceActual = 0;
    }

    public void sumar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            agregarNumero(operandos[0] + operandos[1]);
        }
    }

    public void sumar(double valor) {
        operarUltimo(valor, '+');
    }

    public void restar(double valor) {
        operarUltimo(valor, '-');
    }

    public void multiplicar(double valor) {
        operarUltimo(valor, '*');
    }

    public void dividir(double valor) {
        if (valor == 0) {
            return;
        }
        operarUltimo(valor, '/');
    }

    private void operarUltimo(double valor, char operacion) {
        if (indiceActual > 0) {
            double ultimo = memoria[indiceActual - 1];
            switch (operacion) {
                case '+': memoria[indiceActual - 1] = ultimo + valor; break;
                case '-': memoria[indiceActual - 1] = ultimo - valor; break;
                case '*': memoria[indiceActual - 1] = ultimo * valor; break;
                case '/': memoria[indiceActual - 1] = ultimo / valor; break;
            }
        } else {
        }
    }

    private boolean verificarOperandos(int cantidad) {
        if (indiceActual >= cantidad) return true;
        return false;
    }

    private double[] extraerOperandos(int cantidad) {
        double[] operandos = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            operandos[i] = memoria[--indiceActual];
        }
        return operandos;
    }
}
