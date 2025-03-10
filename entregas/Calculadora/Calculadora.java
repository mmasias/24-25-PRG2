package entregas.Calculadora;

public class Calculadora {

    protected double[] numeros;
    private int tamañoActual;

    public Calculadora() {
        this.numeros = new double[10];
        this.tamañoActual = 0;
    }

    public void mostrarNumeros() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Numeros[" + i + "] = " + numeros[i]);
        }
    }

    public void agregarNumeros(double numero) {
        if (tamañoActual == numeros.length) {

            double[] nuevoArray = new double[numeros.length * 2];

            for (int i = 0; i < numeros.length; i++) {
                nuevoArray[i] = numeros[i];
            }
            numeros = nuevoArray;
        }
        numeros[tamañoActual] = numero;
        tamañoActual++;
    }

    public void eliminarNumeros(int numero) {
        if (numero >= 0 && numero < tamañoActual) {
            for (int i = numero; i < tamañoActual - 1; i++) {
                numeros[i] = numeros[i + 1];
            }
            numeros[tamañoActual - 1] = 0;
            tamañoActual--;
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    public void borrarMemoria() {
        for (int i = 0; i < tamañoActual; i++) {
            numeros[i] = 0;
        }
        tamañoActual = 0;
    }

    public int obtenerTamañoActual() {
        return tamañoActual;
    }

}
