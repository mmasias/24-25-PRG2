package entregas.fernandezIbuprofeno.reto003;

public class Calculadora {

    public Calculadora(int capacidad) {
        System.out.println("Me configuro con el parámetro " + capacidad);
    }

    public Calculadora() {
        System.out.println("Me configuro sin parámetros");
    }

    public void ingresarNumero(double valor) {
        System.out.println("Aqui ingresa un numero");
    }

    public String mostrar() {
        return "Devuelvo algo";
    }

    public String mostrarTodo() {
        return "Devuelvo muchas cosas";
    }

    public void limpiar() {
        System.out.println("Aqui limpio");
    }

    public void sumar() {
        System.out.println("Sumaré");
    }

    public void invertir() {
        System.out.println("Invertiré!");
    }

    public void restar() {
        invertir();
        sumar();
    }

    public void dividir() {
        System.out.println("Dividiré!");
    }

    public void multiplicar() {
        System.out.println("Multiplicaré!");
    }

    public void calcularMedia() {
        System.out.println("Calcularé la media!");
    }

    public void calcularSumatoria() {
        System.out.println("Calcularé la sumatoria!");
    }
}
