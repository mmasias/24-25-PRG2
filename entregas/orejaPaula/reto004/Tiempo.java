public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = esHoraValida(horas) ? horas : 0;
        this.minutos = esMinutoValido(minutos) ? minutos : 0;
        this.segundos = esSegundoValido(segundos) ? segundos : 0;
    }
    public boolean equals(Tiempo tiempo) {
        return compareTo(tiempo) == 0;
    }

    public boolean antesQue(Tiempo tiempo) {
        return compareTo(tiempo) < 0;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return compareTo(tiempo) > 0;
    }

    public int compareTo(Tiempo tiempo) {
    int thisTotalSegundos = this.horas * 3600 + this.minutos * 60 + this.segundos;
    int otroTotalSegundos = tiempo.horas * 3600 + tiempo.minutos * 60 + tiempo.segundos;
    return Integer.compare(thisTotalSegundos, otroTotalSegundos);
    }

    public Tiempo next() {
        return sumar(new Tiempo(0, 0, 1));
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = this.horas + tiempo.horas + totalMinutos / 60;
        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
    }

    public boolean esHoraValida(int hora) { return hora >= 0 && hora < 24; }
    public boolean esMinutoValido(int minuto) { return minuto >= 0 && minuto < 60; }
    public boolean esSegundoValido(int segundo) { return segundo >= 0 && segundo < 60; }

    public String toString() {
    return (horas < 10 ? "0" : "") + horas + ":" +
           (minutos < 10 ? "0" : "") + minutos + ":" +
           (segundos < 10 ? "0" : "") + segundos;
    }
}


