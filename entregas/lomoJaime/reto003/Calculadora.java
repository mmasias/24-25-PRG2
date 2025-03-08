package entregas.lomoJaime.reto003;

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
    public Calculadora(double[] valoresIniciales){
        this(valoresIniciales.length);
        for(int i=0;i<valoresIniciales.length;i++){
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

    private double[] extraerOperandos(int numeroOperandos) {
        double[] operandos = new double[numeroOperandos];
        for (int i = 0; i < numeroOperandos; i++) {
            operandos[i] = extraerOperando();
        }
        return operandos;
    }

    private double extraerOperando(){
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
        final int PORCENTAJE = 100;
        if (verificarOperandos(2)) {
            double[] operando = extraerOperandos(2);
           ingresarNumero((operando[1]/PORCENTAJE)* operando[0]);
        }
    }
    public void calcularFactorial() {
        if(verificarOperandos(1)) {
            double[] operando = extraerOperandos(1);
            int factorial = 1;
            for(int i = 1; i<= operando[0];i++){
                factorial *= i;
            }
            ingresarNumero(factorial);
        }
    }
    public void calcularMaximo(){
        int i = 0;
        extraerOperandos(i++); 
        double valorMaximo = numeros[0];
        do {
            extraerOperandos(i);
            if (numeros[i] > valorMaximo) {
                valorMaximo = numeros[i];
            }
            i++;
        } while (i < posicionActual);

        numeros[0] = valorMaximo;
        posicionActual = 1;
        ingresarNumero(valorMaximo);

    }

    public void cacularMinimo(){
        double valorMinimo= numeros[0];
        for(int i=1; i<posicionActual;i++) {
            if(numeros[i] > valorMinimo){
                valorMinimo = numeros[i];
            }
        }
        limpiar();
        ingresarNumero(valorMinimo);
    }

    public void sumar(double valor){
        ingresarNumero(valor);
        sumar();
    }
    public void restar(double valor){
        ingresarNumero(valor);
        restar();
    }
    public void multiplicar(double valor){
        ingresarNumero(valor);
        multiplicar();
    }
    public void calcularPorcentaje(double valor){
        ingresarNumero(valor);
        calcularPorcentaje();
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
            if (operandos[0] >= 0) {
                ingresarNumero(Math.sqrt(operandos[0]));
            }else{
                error = true;
                mensajeError = "No se puede hacer raiz cuadrade de numeros negativos";
            }
        }
    }

    public void calcularPotencia() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
             ingresarNumero(Math.pow(operandos[0], operandos[1]));
        }
    }

    public void calcularPotencia(double exponente) {
        ingresarNumero(exponente);
        calcularPotencia();
    }
}