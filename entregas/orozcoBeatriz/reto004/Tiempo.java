public class Tiempo {

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        return compareTo(tiempo) < 0;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return compareTo(tiempo) > 0;
    }

    public int compareTo(Tiempo tiempo) {
        if (this.horas < tiempo.horas || (this.horas == tiempo.horas && this.minutos < tiempo.minutos) ||
        (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos)) {
            return -1;
        } else if (this.horas > tiempo.horas || (this.horas == tiempo.horas && this.minutos > tiempo.minutos) ||
        (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Tiempo siguiente() {
        int nuevosSegundos = segundos + 1;
        int nuevosMinutos = minutos;
        int nuevaHora = horas;
        if (nuevosSegundos > 60) {
            nuevosSegundos = 0;
            nuevosMinutos = minutos + 1;
            if (nuevosMinutos > 60) {
                nuevosMinutos = 0;
                nuevaHora = horas + 1;
                if (nuevaHora > 24) {
                    nuevaHora = 0;
                }
            }
        }
        return new Tiempo(nuevaHora, nuevosMinutos, nuevosSegundos);
    }

    public String toString() { 
        return horas + ":" + minutos + ":" + segundos;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + tiempo.horas + (totalMinutos / 60);
        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
    }

    public boolean esHoraValida(int hora) {
        return hora >= 0 && hora <= 23;
    }

    public boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto <= 59;
    }

    public boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo <= 59;
    }
}
