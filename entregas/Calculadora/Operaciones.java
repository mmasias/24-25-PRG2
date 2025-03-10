package entregas.Calculadora;

public class Operaciones extends Calculadora {


    public double sumar(){
        double resultado = 0;
        for (int i = 0; i < obtenerTamañoActual(); i++) {
            resultado = resultado + numeros[i];
        }
        return resultado;
    }

    public double restar(){
        double resultado = 0;
        for (int i = 0; i < obtenerTamañoActual(); i++) {
            resultado = resultado - numeros[i];
        }
        return resultado;
    }

    public double multiplicar(){
        double resultado = 1;
        for (int i = 0; i < obtenerTamañoActual(); i++) {
            resultado = resultado * numeros[i];
        }
        return resultado;
    }  
    
    public double dividir(){
        double resultado = 1;
        for (int i = 0; i < obtenerTamañoActual(); i++) {
            resultado = resultado / numeros[i];
        }
        return resultado;
    }
    
}
