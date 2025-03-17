package entregas.orozcoBeatriz.reto004;

public class Fecha {

    private int anio;
    private int mes;
    private int dia;

    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.anio == fecha.anio && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {

    }

    public boolean despuesDe(Fecha fecha) {

    }

    public int compareTo(Fecha fecha) {

    }

    public Fecha siguiente() {

    }

    public String toString() {

    }

    public boolean esMesValido(int mes) {

    }

    public boolean esDiaValido(int dia) {

    }

}