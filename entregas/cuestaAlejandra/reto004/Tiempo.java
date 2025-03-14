public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = esHoraValida(horas) ? horas : 0;
        this.minutos = esMinutoValido(minutos) ? minutos : 0;
        this.segundos = esSegundoValido(segundos) ? segundos : 0;
    }