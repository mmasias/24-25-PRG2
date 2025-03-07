package entregas.vaqueroSara.reto003;

public class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public static void main(String[] args) {
        System.out.println("HOLA");
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

    public Calculadora(double valorInicial) {
        this(CAPACIDAD_POR_DEFECTO);
        ingresarNumero(valorInicial);  
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length);  
        for (int i = 0; i < valoresIniciales.length; i++) {
            ingresarNumero(valoresIniciales[i]);
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

    public void sumar(double valor) {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor + valor;
            ingresarNumero(resultado);
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

    public void restar(double valor) {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor - valor;
            ingresarNumero(resultado);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] / operandos[0]);
        }
    }

    public void dividir(double valor) {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else if (valor == 0) {
            error = true;
            mensajeError = "Error: División por cero.";
        } else {
            double ultimoValor = numeros[posicionActual - 1];
            double resultado = ultimoValor / valor;
            ingresarNumero(resultado);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }

    public void multiplicar(double valor) {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else {
            double ultimoValor = numeros[posicionActual - 1];  // Último número en la memoria
            double resultado = ultimoValor * valor;  // Multiplica el valor ingresado por el último número
            ingresarNumero(resultado);  // Ingresa el resultado de la multiplicación a la memoria
        }
    }

    public void calcularMaximo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else {
            double maximo = numeros[0];
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] > maximo) {
                    maximo = numeros[i];  
                }
            }
            ingresarNumero(maximo);  
        }
    }
 
    public void calcularMinimo() {
        if (posicionActual == 0) {
            error = true;
            mensajeError = "No hay números en la memoria.";
        } else {
            double minimo = numeros[0];  // Inicializa el mínimo con el primer número almacenado
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] < minimo) {
                    minimo = numeros[i];  // Si encontramos un número menor, lo actualizamos
                }
            }
            ingresarNumero(minimo);  // Ingresa el valor mínimo en la memoria
        }
    }

    public void calcularPorcentaje() {
        if (verificarOperandos(2)) {  
            double[] operandos = extraerOperandos(2);
            double valor = operandos[1];  
            double porcentaje = operandos[0];  
            double resultado = (valor * porcentaje) / 100;
            ingresarNumero(resultado);  
        }
    }

    public void calcularFactorial() {
        if (verificarOperandos(1)) { 
            double[] operandos = extraerOperandos(1);
            int numero = (int) operandos[0]; 
    
            if (numero < 0) {
                error = true;
                mensajeError = "No se puede calcular el factorial de un número negativo.";
                return;
            }
    
            long resultado = 1;
            for (int i = 1; i <= numero; i++) {
                resultado *= i;
            }
    
            ingresarNumero(resultado);
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
}