package entregas.grizoniManuela.Reto003;


public class Calculadora {

    private static final String ERROR_MSG = "Error";
    private double[] numeros;
    private int count;
    private int capacidad;
    private String error;

    public Calculadora() {
        this(10);
    }

    public Calculadora(int capacidad) {
        this.capacidad = capacidad;
        this.numeros = new double[capacidad];
        this.count = 0;
        this.error = null;
    }

    public Calculadora(double valorInicial) {
        this();
        ingresarNumero(valorInicial);
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length > 10 ? valoresIniciales.length : 10);
        for (double v : valoresIniciales) {
            ingresarNumero(v);
        }
    }

    public void ingresarNumero(double valor) {
        if (error != null) return;
        if (count >= capacidad) {
            error = ERROR_MSG;
            return;
        }
        numeros[count++] = valor;
    }

    public String mostrar() {
        if (error != null) return error;
        if (count == 0) return ERROR_MSG;
        return String.valueOf(numeros[count - 1]);
    }

    public String mostrarTodo() {
        if (error != null) return error;
        if (count == 0) return ERROR_MSG;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(numeros[i]);
            if (i < count - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void limpiar() {
        count = 0;
        error = null;
    }

    public void sumar() {
        if (!requireTwoOperands()) return;
        double b = numeros[count - 1];
        double a = numeros[count - 2];
        double resultado = a + b;
        count--;
        numeros[count - 1] = resultado;
    }

    public void restar() {
        if (!requireTwoOperands()) return;
        double b = numeros[count - 1];
        double a = numeros[count - 2];
        double resultado = a - b;
        count--;
        numeros[count - 1] = resultado;
    }

    public void multiplicar() {
        if (!requireTwoOperands()) return;
        double b = numeros[count - 1];
        double a = numeros[count - 2];
        double resultado = a * b;
        count--;
        numeros[count - 1] = resultado;
    }

    public void dividir() {
        if (!requireTwoOperands()) return;
        double b = numeros[count - 1];
        if (b == 0) {
            error = ERROR_MSG;
            return;
        }
        double a = numeros[count - 2];
        double resultado = a / b;
        count--;
        numeros[count - 1] = resultado;
    }

    public void invertir() {
        if (!requireOneOperand()) return;
        numeros[count - 1] = -numeros[count - 1];
    }

    public void calcularMedia() {
        if (error != null) return;
        if (count == 0) {
            error = ERROR_MSG;
            return;
        }
        double suma = 0;
        for (int i = 0; i < count; i++) {
            suma += numeros[i];
        }
        double media = suma / count;
        count = 1;
        numeros[0] = media;
    }

    public void calcularSumatoria() {
        if (error != null) return;
        if (count == 0) {
            error = ERROR_MSG;
            return;
        }
        double suma = 0;
        for (int i = 0; i < count; i++) {
            suma += numeros[i];
        }
        count = 1;
        numeros[0] = suma;
    }

    public void calcularPorcentaje() {
        if (!requireTwoOperands()) return;
        double base = numeros[count - 2];
        double porcentaje = numeros[count - 1];
        double resultado = (base * porcentaje) / 100;
        count--;
        numeros[count - 1] = resultado;
    }

    public void calcularFactorial() {
        if (!requireOneOperand()) return;
        double valor = numeros[count - 1];
        if (valor < 0 || valor != (int) valor) {
            error = ERROR_MSG;
            return;
        }
        int n = (int) valor;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        numeros[count - 1] = (double) fact;
    }

    public void calcularMaximo() {
        if (error != null) return;
        if (count == 0) {
            error = ERROR_MSG;
            return;
        }
        double max = numeros[0];
        for (int i = 1; i < count; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        count = 1;
        numeros[0] = max;
    }

    public void calcularMinimo() {
        if (error != null) return;
        if (count == 0) {
            error = ERROR_MSG;
            return;
        }
        double min = numeros[0];
        for (int i = 1; i < count; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
        }
        count = 1;
        numeros[0] = min;
    }

    public void sumar(double valor) {
        if (!requireOneOperand()) return;
        numeros[count - 1] += valor;
    }

    public void restar(double valor) {
        if (!requireOneOperand()) return;
        numeros[count - 1] -= valor;
    }

    public void multiplicar(double valor) {
        if (!requireOneOperand()) return;
        numeros[count - 1] *= valor;
    }

    public void dividir(double valor) {
        if (!requireOneOperand()) return;
        if (valor == 0) {
            error = ERROR_MSG;
            return;
        }
        numeros[count - 1] /= valor;
    }

    private boolean requireOneOperand() {
        if (error != null) return false;
        if (count < 1) {
            error = ERROR_MSG;
            return false;
        }
        return true;
    }

    private boolean requireTwoOperands() {
        if (error != null) return false;
        if (count < 2) {
            error = ERROR_MSG;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.ingresarNumero(15);
        calc.ingresarNumero(15);
        calc.sumar();
        System.out.println("MostrarTodo: " + calc.mostrarTodo());
        calc.limpiar();
        calc.ingresarNumero(20);
        calc.ingresarNumero(10);
        calc.dividir();
        System.out.println("Después de dividir: " + calc.mostrarTodo());
    }
}
