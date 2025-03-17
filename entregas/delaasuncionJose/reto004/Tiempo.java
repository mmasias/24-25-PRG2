package entregas.delaasuncionJose.reto004;

public class Tiempo {
    public int horas;
    public int minutos;
    public int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert fechaInvalida(horas, minutos, segundos) : "Fecha invalida, introduzca una fecha valida.";

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int toSeconds() {
        return horas * 3600 + minutos * 60+ segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        return this.toSeconds < tiempo.toSeconds;
    }

    public boolean equals(Fecha fecha) {
        return this.toSeconds == tiempo.toSeconds;
    }

    public boolean despuesDe(Fecha fecha) {
        return this.toSeconds > tiempo.toSeconds;
    }

    public int compareTo(Fecha fecha) {
        return antesQue(fecha) ? 1 : equals(fecha) ? 0 : -1;
    }

    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
    }


}