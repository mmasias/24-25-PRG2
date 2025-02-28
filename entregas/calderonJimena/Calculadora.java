package entregas.calderonJimena;

class Calculadora {
    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;

    public Calculadora() {
        numeros = new double[10];
        posicionActual = 0;
        error = false;
    }

    public void ingresarNumero(double valor) {
        numeros[posicionActual] = valor;
        posicionActual++;
    }

    public String mostrar() {
        if (error) {
            return mensajeError;
        } else {
            return "" + numeros[posicionActual - 1];
        }
    }

    public String mostrarTodo() {
        String resultado = "";
        for (int i = 0; i < posicionActual; i++) {
            resultado = resultado + numeros[i] + "\n";

        }
        return resultado;
    }

    public void limpiar() {
        numeros = new double[numeros.length];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public void sumar() {
        if (posicionActual >= 2) {

            double resultado = numeros[posicionActual - 1] + numeros[posicionActual - 2];
            numeros[posicionActual - 2] = resultado;
            posicionActual = posicionActual - 1;
        } else {
            error = true;
            mensajeError = "No hay suficientes numeros para sumar";
        }
    }

    public void restar() {
        if (posicionActual >= 2) {

            double resultado = numeros[posicionActual - 2] - numeros[posicionActual - 1];
            numeros[posicionActual - 2] = resultado;
            posicionActual = posicionActual - 1;
        } else {
            error = true;
            mensajeError = "No hay suficientes numeros para restar";
        }
    }
}
