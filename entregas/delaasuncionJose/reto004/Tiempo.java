package entregas.delaasuncionJose.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean esSegundoValido() {
        return segundos >= 0 && segundos < 60;
    }

    public boolean esMinutoValido() {
        return minutos >= 0 && minutos < 60;
    }

    public boolean esHoraValida() {
        return horas >= 0 && horas < 24;
    }

    public int toSeconds() {
        return horas * 3600 + minutos * 60 + segundos;
    }

    public Tiempo toTime(int segundosTotales) {
        int horas = (segundosTotales / 3600) % 24;
        int minutos = (segundosTotales % 3600) / 60;
        int segundos = segundosTotales % 60;
        return new Tiempo(horas, minutos, segundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        return toTime(this.toSeconds() + tiempo.toSeconds());
    }

    public boolean antesQue(Tiempo tiempo) {
        return this.toSeconds() < tiempo.toSeconds();
    }

    public boolean equals(Tiempo tiempo) {
        return this.toSeconds() == tiempo.toSeconds();
    }

    public boolean despuesDe(Tiempo tiempo) {
        return this.toSeconds() > tiempo.toSeconds();
    }

    public int compareTo(Tiempo tiempo) {
        return antesQue(tiempo) ? 1 : equals(tiempo) ? 0 : -1;
    }

    public Tiempo next() {
        if (segundos + 1 < 60) {
            return new Tiempo(horas, minutos, segundos + 1);
        } else if (minutos + 1 < 60) {
            return new Tiempo(horas, minutos + 1, 1);
        }else if (horas +1 < 24) {
            return new Tiempo(horas + 1, 1, 1);
        } return new Tiempo(0,0 , 0);
    }

    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
    }
}